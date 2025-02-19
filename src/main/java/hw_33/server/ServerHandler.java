package hw_33.server;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

import static hw_33.server.NettyServer.activeClients;
import static hw_33.server.NettyServer.clientCount;

@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger LOGGER = LogManager.getLogger(ServerHandler.class);
    private String clientName;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        clientName = "client-" + clientCount++;
        activeClients.put(clientName, ctx.channel());
        System.out.println(clientName + " connected at " + LocalDateTime.now());
        LOGGER.info("[SERVER] {} successfully connected at {}", clientName, LocalDateTime.now());
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
//        if ("exit".equalsIgnoreCase(msg.trim())) {
//            ctx.close();
//        } else {
//            LOGGER.info("[SERVER] Received from {}: {}", clientName, msg);
//        }
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        if ("exit".equalsIgnoreCase(msg.trim())) {
            ctx.close();
            System.exit(0);
        } else if (msg.startsWith("@")) {
            String[] parts = msg.split(" ", 2);
            if (parts.length > 1) {
                String targetClient = parts[0].substring(1);
                String message = parts[1];
                Channel targetChannel = activeClients.get(targetClient);
                if (targetChannel != null) {
                    targetChannel.writeAndFlush("[PRIVATE] " + clientName + ": " + message + "\n");
                } else {
                    ctx.writeAndFlush("[SERVER] Client " + targetClient + " not found\n");
                }
            }
        } else {
            for (Channel ch : activeClients.values()) {
                if (ch != ctx.channel()) {
                    ch.writeAndFlush("[CHAT] " + clientName + ": " + msg + "\n");
                }
            }
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        activeClients.remove(clientName);
        System.out.println("[SERVER] " + clientName + " disconnected");
        LOGGER.info("[SERVER] {} disconnected", clientName);
        System.exit(0);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("[SERVER] Error with {}", clientName, cause);
        ctx.close();
    }
}

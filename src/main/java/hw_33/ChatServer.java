package hw_33;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServer {
    private static final int PORT = 8080;
    private static final Logger logger = LogManager.getLogger(ChatServer.class);
    private static final ConcurrentHashMap<String, Channel> activeClients = new ConcurrentHashMap<>();
    private static final AtomicInteger clientCounter = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new ChatServer.ChatServerHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(PORT).sync();
            System.out.println("Server started on port: " + PORT);
            logger.info("[SERVER] Server started on port: " + PORT);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    static class ChatServerHandler extends SimpleChannelInboundHandler<String> {
        private String clientName;

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            clientName = "client-" + clientCounter.getAndIncrement();
            activeClients.put(clientName, ctx.channel());
            logger.info("[SERVER] " + clientName + " успішно підключився");
            broadcastMessage("[SERVER] " + clientName + " приєднався до чату");
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) {
            if (msg.startsWith("/name ")) {
                String newName = msg.substring(6).trim();
                if (!newName.isEmpty() && !activeClients.containsKey(newName)) {
                    activeClients.remove(clientName);
                    activeClients.put(newName, ctx.channel());
                    broadcastMessage("[SERVER] " + clientName + " змінив ім'я на " + newName);
                    clientName = newName;
                } else {
                    ctx.writeAndFlush("[SERVER] Це ім'я вже зайняте або некоректне!\n");
                }
            } else if ("exit".equalsIgnoreCase(msg)) {
                ctx.close();
            } else {
                broadcastMessage("[" + clientName + "]: " + msg);
            }
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) {
            activeClients.remove(clientName);
            logger.info("[SERVER] " + clientName + " відключився");
            broadcastMessage("[SERVER] " + clientName + " покинув чат");
        }

        private void broadcastMessage(String message) {
            for (Channel channel : activeClients.values()) {
                channel.writeAndFlush(message + "\n");
            }
        }
    }
}

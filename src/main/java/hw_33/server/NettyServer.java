package hw_33.server;

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

public class NettyServer {
    private static final Logger LOGGER = LogManager.getLogger(NettyServer.class);
    static ConcurrentHashMap<String, Channel> activeClients = new ConcurrentHashMap<>();
    static int clientCount = 1;
    private static final int PORT = 8080;

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

//                            pipeline.addLast(new StringDecoder());
//                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new ServerHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(PORT).sync();
            System.out.println("Server started on port " + PORT);
            LOGGER.info("Server started on port: " + PORT);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

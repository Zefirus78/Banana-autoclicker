package hw_33.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class NettyClient1 {

//    static final String HOST = "localhost";
//    static final int PORT = 8080;
//
//    public void run() {
//        EventLoopGroup group = new NioEventLoopGroup();
//
//        try {
//            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(group)
//                    .channel(NioSocketChannel.class)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        public void initChannel(SocketChannel socketChannel)     {
//                            ChannelPipeline p =  socketChannel.pipeline();
//
//                            p.addLast(new StringDecoder());
//                            p.addLast(new StringEncoder());
//                            p.addLast(new ClientHandler());
//                        }
//                    });
//            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();
//            String input = "Peter";
//            Channel channel = future.sync().channel();
//            channel.writeAndFlush(input);
//            channel.flush();
//            future.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            group.shutdownGracefully();
//        }
//
//    }



    private static final Logger logger = LogManager.getLogger(NettyClient1.class);
    private final String host;
    private final int port;

    public NettyClient1(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });

            Channel channel = bootstrap.connect(host, port).sync().channel();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                channel.writeAndFlush(input + "\n");
                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.exit(0);
                }
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyClient1("localhost", 8080).run();
    }
}

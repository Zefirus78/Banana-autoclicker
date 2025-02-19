package hw_33;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

    public class ChatClient {
        private static final String HOST = "localhost";
        private static final int PORT = 8080;
        private static final Logger logger = LogManager.getLogger(ChatClient.class);

        public static void main(String[] args) throws InterruptedException {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<Channel>() {
                            @Override
                            protected void initChannel(Channel ch) {
                                ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new ChatClientHandler());
                            }
                        });
                Channel channel = bootstrap.connect(HOST, PORT).sync().channel();
                logger.info("[CLIENT] Підключено до сервера на " + HOST + ":" + PORT);

                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    channel.writeAndFlush(message + "\n");
                    if ("exit".equalsIgnoreCase(message)) {
                        channel.closeFuture().sync();
                        break;
                    }
                }
            } finally {
                group.shutdownGracefully();
            }
        }
    }


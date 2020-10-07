package netyDemo02MutilClient;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossExecutors = new NioEventLoopGroup();
        EventLoopGroup workExecutors = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossExecutors,workExecutors).channel(NioServerSocketChannel.class).
                    childHandler(new ServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8596).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossExecutors.shutdownGracefully();
            workExecutors.shutdownGracefully();
        }
    }
}

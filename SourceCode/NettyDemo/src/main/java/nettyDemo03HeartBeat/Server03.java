package nettyDemo03HeartBeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class Server03 {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossExecutors = new NioEventLoopGroup();
        EventLoopGroup workExecutors = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossExecutors,workExecutors).channel(NioServerSocketChannel.class).
                    //handler是用于处理bossExecutors
                    //childHandler是用于处理workExecutors
                    handler(new LoggingHandler(LogLevel.INFO)).
                    childHandler(new ServerInitializer03());

            ChannelFuture channelFuture = serverBootstrap.bind(9006).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossExecutors.shutdownGracefully();
            workExecutors.shutdownGracefully();
        }
    }
}

package nettyDemo03HeartBeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @autserhor liujun
 * @version 1.0
 * @date 2020/5/13
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class MutilClient03 {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).
                    handler(new MutilClientInitializer03());

            Channel channel = bootstrap.connect("localhost", 9006).sync().channel();
//            channelFuture.channel().closeFuture().sync();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                channel.writeAndFlush(br.readLine()+"\r\n");
            }

        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}

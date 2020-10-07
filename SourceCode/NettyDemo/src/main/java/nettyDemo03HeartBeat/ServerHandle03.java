package nettyDemo03HeartBeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;


/**
 * @author liujun
 * @version 1.0
 * @date 2020/5/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ServerHandle03 extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read idel";
                    break;
                case WRITER_IDLE:
                    eventType = "write idel";
                    break;
                case ALL_IDLE:
                    eventType = "read and write idel";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件" + eventType);
            ctx.channel().close();
        }
    }
}

# 第二个Netty程序：多客户端连接与通信

### 目的及介绍
+ 编写一个多客户端的程序，与服务器端通信
+ 满足某客户端上线，服务器端能通知其他客户端：上线通知
+ 满足某客户发送消息，服务器端能转发至其他客户端

### 项目源码
+ [HighAvailability_HighConcurrency_HighPerformance](https://github.com/ljfirst/HighAvailability_HighConcurrency_HighPerformance)

### 搭建、设计思路
+ 客户端设计
  + 为了能获取服务器发送的上线通知和其他客户端发送来的广播信息。客户端只需要在MutilClientHandler的channelRead0回调中输出信息就行。 
  + 编解码工作需要在MutilClientInitializer中进行
  + 为了能发送消息，客户端必须有个死循环，不断从system.in获取用户输入的消息
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
for (; ; ) {
    channel.writeAndFlush(br.readLine()+"\r\n");
}
```
+ 服务器端设计
  + 编解码工作需要在ServerInitializer中进行
  + 当客户端上线时，会触发ServerHandle的channelActive方法，此时可以发送广播消息，通知其他客户端，通知的方法用channelGroup的广播方法channelGroup.writeAndFlush
  + 当客户端发送消息时，会触发ServerHandle的channelRead0方法，需要写个方法判断信息来源，并发送消息至其他客户端
```java
channelGroup.forEach(dfg -> {
  if (channel != dfg) {
      dfg.writeAndFlush(channel.remoteAddress() + "发送来消息：" + msg +"\n");
  } else {
    channel.writeAndFlush("[自己]发送来消息：" + msg +"\n");
  }
});
```

### 具体步骤
+ 这里只显示handler的处理方法，其他代码见github
+ MutilClientHandler
```java
public class MutilClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("client output:" + msg);
    }
}
```

+ ServerHandle
```java
public class ServerHandle extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(dfg -> {
            if (channel != dfg) {
                dfg.writeAndFlush(channel.remoteAddress() + "发送来消息：" + msg +"\n");
            } else {
                channel.writeAndFlush("[自己]发送来消息：" + msg +"\n");
            }
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "channelActive");
        channelGroup.writeAndFlush("[服务器]-" + channel.remoteAddress() + "已经上线channelActive"+"\n");
        channelGroup.add(channel);
        System.out.println("channelGroup.size():" + channelGroup.size());
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "-----channelInactive");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelUnregistered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "handlerAdded");
        channelGroup.writeAndFlush("[服务器]-" + channel.remoteAddress() + "已经上线"+"\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "handlerRemoved");
        channelGroup.writeAndFlush("[服务器]-" + channel.remoteAddress() + "已经下线"+"\n");
        System.out.println("channelGroup.size():" + channelGroup.size());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
```
### 排坑细节
+ idea如何想启动多客户端，需要在run/debug configurations中勾选allow parallel run
+ **大坑**：其他用户上线后，根本没有收到上线通知，或者没有收到其他客户端发送的消息
  + 因为ServerInitializer设置来编解码方式，
  + 所以ServerHandle，必须在msg后面显式的加上"\n" 或者"\t"
  + 不设置则不会收到消息，服务端会一直存储着该消息

# 第一个Netty程序：使用Netty来获取请求

### 目的及介绍
+ Netty是一款类似于Tomcat的服务器，它更关注网络编程，相对来说网络通信性能更高。
+ 搭建一款简单的Netty程序，只编写简单的服务端程序，通过浏览器或者bash的curl方式来感受一下netty的通信模式

### 项目源码
+ HighAvailability_HighConcurrency_HighPerformance\sourcecode\nettyDemo\src\main\java\nettyDemo01GetHttpmsg

### 搭建、设计思路
+ 一个简单且完整的Netty服务器端程序，包括一个Server、ServerInitializer、ServerHandle
+ Server主要用于接收请求、ServerInitializer用于建立pipeline、ServerHandle用于对channel进行handle处理
  + Server：
    + 包含两个EventLoopGroup，bossExecutors用于接收外部传入的请求，然后交给workExecutors去执行。
    + ServerBootstrap用于启动该项目
      + serverBootstrap建一个组，组里有boss和work，然后通过反射获取一个channel，对channel建立handle，一般这个handle是我们自己实现。
      + serverBootstrap需要绑定端口。
      + serverBootstrap的channel执行完需要关闭。
    + 优雅的关闭boss和work
  + ServerInitializer：
    + 继承自ChannelInitializer，需要建立pipeline
    + 通过addLast，将执行操作增加到pipeline的结尾
  + ServerHandle：
    + 继承自SimpleChannelInboundHandler，在channelRead0方法内写具体逻辑
    + handle是一个回调方法，将接收到的msg转化为httpRequest
    + 将需要发送的信息，通过Unpooled.copiedBuffer转化为一个ByteBuf
    + 将这个ByteBuf通过DefaultFullHttpResponse包装，同时设置请求头headers
    + 最后，使用writeAndFlush的方式发送消息 
+ 启动服务，通过浏览器，或者使用curl访问localhost:8899,就可以拿到你想要的信息

### 具体步骤
+ Server：
```java
public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossExecutors = new NioEventLoopGroup();
        EventLoopGroup workExecutors = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossExecutors,workExecutors).channel(NioServerSocketChannel.class).
                    childHandler(new TestServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossExecutors.shutdownGracefully();
            workExecutors.shutdownGracefully();
        }
    }
}
```
+ ServerInitializer：
```java
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandle());
    }
}
```
+ ServerHandle：

```java
public class TestHttpServerHandle extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("请求方法名：" + httpRequest.method().name());

            ByteBuf content = Unpooled.copiedBuffer("ljfirst", CharsetUtil.UTF_8);

            FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK, content);
            fullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            fullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(fullHttpResponse);
        }
    }
}
```
### 排坑细节
+ ctx.writeAndFlush(fullHttpResponse)，这里不要填写成msg了，不是发生消息，而是发送包装好的消息。
+ ServerHandle继承自SimpleChannelInboundHandler，此处是一个范性，最好填入HttpObject。
+ TestHttpServerHandle类中，对favicon.ico的拦截，需要注意此处的 "/"，写错了不拦截
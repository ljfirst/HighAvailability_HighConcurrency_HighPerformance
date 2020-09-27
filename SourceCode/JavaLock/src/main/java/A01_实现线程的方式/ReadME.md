实现线程的方式简单梳理了8种（含重复），分别是：
  + implements Runnable：见 RunnableDemo.java
  + extends Thread：见 ThreadDemo.java
  + 使用线程池：见 ThreadPoolDemo.java
  + 使用线程工厂：见 ThreadFactoryDemo.java
  + implements Callable：见CallableDemo.java
  + implements FutureTask：见FutureTaskDemo.java
  + 使用注解@Async：见AsyncDemo.java
  + 定时器Timer创建线程：见TimerDemo.java
  
但是本质上只有一种,因为他们最终都会执行一句：new Thread。
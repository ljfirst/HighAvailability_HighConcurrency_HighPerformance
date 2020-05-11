# Synchronized、Volatile、Lock、Condition之间的关系

### 它们是什么？有什么用？
+ Synchronized：
  + 用于控制同步程序的代码段。 
+ Volatile：
  + 保证变量的可见性。
+ Lock：
  + 用于控制同步程序的代码段。 
+ Condition：
  + 配合lock使用，做阻塞用，用来替代传统的Object的wait()、notify()实现线程间的协作。 

### Synchronized：
+ 实现原理
+ 用法
+ 存在的坑
### Volatile：
+ 实现原理：
  + volatile通过插入内存屏障来保证**可见性**和禁止**语句重排**。
  + 内存屏障：volatile 关键字在汇编时会生成lock 前缀指令
  + 可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
+ 用法
  + Volatile可以保证可见性：下面这段代码，不同线程执行，不一定会中断的了循环。
    + 一方面指令重拍，导致flag失效
    + 另一方面，即使没有重拍，线程2修改的flag没有立刻强制同步到线程1，因此会导致循环延迟停止。
    + 加上Volatile，可以避免**原子性操作**的变量出现上述情况。

```java
//线程1
boolean flag = false;
while(!flag){
    doSomething();
}
//线程2
flag = true;
```

+ 存在的坑
  + 虽然Volatile可以保障可见性，但是不能保障原子性，因此对于非原子操作（比如count++），还是不准的。
比如下面的输出依旧不会是10000。
```java
public class Test {
    public volatile int count = 0;
     
    public void increase() {
        count++;
    }
     
    public static void main(String[] args) {
        final Test test = new Test();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
         
        while(Thread.activeCount()>1){
            //保证前面的线程都执行完
            Thread.yield();
        }  
        System.out.println(test.count);
    }
}
```

### Lock：
+ 实现原理
+ 用法
+ 存在的坑
### Condition：
+ 实现原理
+ 用法
+ 存在的坑


### 实现原理

未完待续

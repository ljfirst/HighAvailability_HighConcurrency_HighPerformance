package A01_实现线程的方式;

import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 使用implements Runnable
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("i am RunnableDemo");
    }

    @Test
    public void test(){
        RunnableDemo r = new RunnableDemo();
        Thread t = new Thread(r);
        t.start();
    }

    //对比test1 和 test2 的实现异同
    @Test
    public void test1(){
        new Thread(
                new Runnable(){
                    @Override
                    public void run() {
                        System.out.println("i am 匿名内部类");
                    }
                }
        ).start();
    }

    @Test
    public void test2(){
        new Thread(()->{
            System.out.println("i am 匿名内部类");
        }).start();
    }
}

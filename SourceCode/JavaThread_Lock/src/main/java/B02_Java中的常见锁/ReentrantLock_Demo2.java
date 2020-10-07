package B02_Java中的常见锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 使用 reentrantlock 展示 可重入锁
 */
public class ReentrantLock_Demo2 extends Thread{
    private Lock lock = new ReentrantLock();

    public void aa() {
        lock.lock();
        System.out.println("i am aa ====" + Thread.currentThread().getName());
        bb();
        lock.unlock();
    }

    public void bb() {
        lock.lock();
        System.out.println("i am bb ====" + Thread.currentThread().getName());
        lock.unlock();
    }

    @Override
    public void run() {
        aa();
    }

    public static void main(String[] args) {
        ReentrantLock_Demo2 demo = new ReentrantLock_Demo2();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        Thread t3 = new Thread(demo);
        Thread t4 = new Thread(demo);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

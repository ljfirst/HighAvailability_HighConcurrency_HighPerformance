package B02_Java中的常见锁;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 使用 synchronized 展示 可重入锁
 */
public class ReentrantLock_Demo1 extends Thread {

    //同一把锁，锁的是当前对象，可重入
    public synchronized void aa() {
        System.out.println("i am aa " + Thread.currentThread().getName());
        bb();
    }

    public synchronized void bb() {
        System.out.println("i am bb " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        aa();
    }

    public static void main(String[] args) {
        ReentrantLock_Demo1 demo = new ReentrantLock_Demo1();
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

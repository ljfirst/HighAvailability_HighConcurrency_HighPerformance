package A02_正确停止线程;

import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class StopThread {
    @Test
    public void test() throws Exception {
        Thread t = new Thread(() -> {
            int count = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("======" + (count++) + "=====");
            }
        });
        t.start();
        Thread.sleep(5);
        t.interrupt();
    }

    //在sleep的情况下，能否感受到中断
    @Test
    public void test1() throws Exception {
        Thread t = new Thread(() -> {
            int count = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("======" + (count++) + "=====");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //如果后续方法需要捕捉到中断，需要在此处加上 interrupt
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        Thread.sleep(50);
        t.interrupt();
    }
}

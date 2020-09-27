package E01_ThreadLocal;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/16
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class A_Demo {

    @Test//两个线程
    public void ThreadLocalDemo_2() throws InterruptedException {
        new Thread(() -> {
            String date = new A_Demo().date(1);
            System.out.println(date);
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            String date = new A_Demo().date(2);
            System.out.println(date);
        }).start();
    }

    @Test//十个线程
    public void ThreadLocalDemo_10() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int fi = i;
            new Thread(() -> {
                String date = new A_Demo().date(fi);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }
    }

    public static ExecutorService tpool = Executors.newFixedThreadPool(10);

    @Test//一千个线程
    public void ThreadLocalDemo_1000() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int fi = i;
            tpool.submit(()-> {
                String date = new A_Demo().date(fi);
                System.out.println(Thread.currentThread().getName()+":     "+date);
            });

        }
        Thread.sleep(100);
        tpool.shutdown();
    }

    public String date(int second) {
        Date date = new Date(1000 * second);
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        return df.format(date);
    }
}

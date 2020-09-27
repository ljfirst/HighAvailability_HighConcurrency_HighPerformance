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
public class ErrorThreadLocalDemo {

    public static ExecutorService tpool = Executors.newFixedThreadPool(10);
    static SimpleDateFormat df1 = new SimpleDateFormat("mm:ss");

    @Test//一千个线程
    public void ThreadLocalDemo_1000_1() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int fi = i;
            tpool.submit(() -> {
                String date = new ErrorThreadLocalDemo().date(fi);
                System.out.println(Thread.currentThread().getName() + ":     " + date);
            });

        }
        //Thread.sleep(100);
        tpool.shutdown();
    }

    @Test//加锁保证：一千个线程
    public void ThreadLocalDemo_1000_lock() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int fi = i;
            tpool.submit(() -> {
                String date = new ErrorThreadLocalDemo().date_lock(fi);
                System.out.println(Thread.currentThread().getName() + ":     " + date);
            });

        }
        //Thread.sleep(100);
        tpool.shutdown();
    }

    public String date(int second) {
        Date date = new Date(1000 * second);
        return df1.format(date);
    }

    public String date_lock(int second) {
        Date date = new Date(1000 * second);
        String s = null;
        synchronized (ErrorThreadLocalDemo.class) {
            s = df1.format(date);
        }
        return s;
    }
}

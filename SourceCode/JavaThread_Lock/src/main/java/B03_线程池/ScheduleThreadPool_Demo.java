package B03_线程池;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ScheduleThreadPool_Demo {

    private static Runnable forSchdule = () -> {
        try {

            System.out.println(System.currentTimeMillis());
            Thread.sleep(7_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程池中线程的名字:" + Thread.currentThread().getName());
    };

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleAtFixedRate(forSchdule, 1,3, TimeUnit.SECONDS);
        //service.scheduleWithFixedDelay(forSchdule, 1,3, TimeUnit.SECONDS);
        /*for (int i = 0; i < 30; i++) {
            service.schedule(forSchdule, 5, TimeUnit.SECONDS);
        }*/
        System.out.println("main中线程的名字:" + Thread.currentThread().getName());
        //service.shutdown();
    }

}
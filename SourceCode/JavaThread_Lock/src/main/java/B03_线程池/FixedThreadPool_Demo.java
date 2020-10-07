package B03_线程池;

import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class FixedThreadPool_Demo {

    @Test
    public void testFixThread_Demo01() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        //通过实现证明，FixedThreadPool执行的是AbortPolicy,
        //因为它只能打印出5个 "9999999"
        for (int i = 0; i < 100; i++) {
            service.execute(new ForFixedThread());
            System.out.println("00000");
        }
        System.out.println("main中线程的名字:" + Thread.currentThread().getName());
        //service.shutdown();强行在瞬间关闭线程池
    }
}


class ForFixedThread implements Runnable {
    @Override
    public void run() {
        //因为是固定线程数量，所以可以看到打印出来的线程就那么几个
        try {
            System.out.println("9999999");
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程池中线程的名字:" + Thread.currentThread().getName());
    }
}

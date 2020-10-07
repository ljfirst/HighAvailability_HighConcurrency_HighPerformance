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
public class CachedThreadPool_Demo {

    @Test
    public void testCache() {
        ExecutorService service = Executors.newCachedThreadPool();
        //1000个任务，虽然存在线程复用，但是依然会不停的创造线程
        for (int i = 0; i < 1000; i++) {
            service.execute(new ForFixedThread());
        }
    }
}

class ForCache implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程池中线程的名字:" + Thread.currentThread().getName());
    }
}

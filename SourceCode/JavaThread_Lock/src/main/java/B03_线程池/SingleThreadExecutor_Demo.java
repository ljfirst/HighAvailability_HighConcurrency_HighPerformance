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
public class SingleThreadExecutor_Demo {

    private static int count = 0;
    private static Runnable forsing = () -> {
        count++;
        if (count == 5) {
            int y = count / 0;
        }
        System.out.println("main中线程的名字:" + Thread.currentThread().getName() + "count:" + count);
    };

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 500; i++) {
            service.execute(forsing);
        }
        service.shutdown();
    }
}

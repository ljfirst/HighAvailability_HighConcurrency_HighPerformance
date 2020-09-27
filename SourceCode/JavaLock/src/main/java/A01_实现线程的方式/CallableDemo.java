package A01_实现线程的方式;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("i am CallableDemo");
        Thread.sleep(2000);
        return "i am CallableDemo return";
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        // Future future = exec.submit(this::call);
        Future future = exec.submit(new CallableDemo());
        Thread.sleep(2000);
        System.out.println("\n=======test=========");
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

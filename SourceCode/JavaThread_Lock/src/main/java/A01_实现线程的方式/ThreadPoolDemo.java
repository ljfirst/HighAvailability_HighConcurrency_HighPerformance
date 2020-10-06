package A01_实现线程的方式;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 使用线程池的方式
 */
public class ThreadPoolDemo {

    ExecutorService pools = Executors.newFixedThreadPool(10);

    @Test
    public void test() {
        pools.submit(() -> {
            System.out.println("ThreadPoolDemo");
        });
    }
}

package E01_ThreadLocal;

import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/16
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 证明线程池复用 threadlocal 会造成污染
 */
public class threadlocal复用污染 {
    public static ExecutorService tpool = Executors.newFixedThreadPool(10);

    @Test
    public void test() {
        Thread t = new Thread(()->{
            Tools.tl.set("bbb");
            System.out.println(Thread.currentThread().getName() + ":======" + Tools.tl.get());
            //这句话不加会导致后续的线程复用时，threadlocal也被复用，因此造成线程不安全
            Tools.tl.remove();
        });
        tpool.submit(t);
        Thread t1 = new Thread(()->{
            Tools.dd();
            System.out.println(Thread.currentThread().getName() + ":======" + Tools.tl.get());
            /*
            ddd.tl.remove()：这句话不加会导致后续的线程复用时，threadlocal也被复用，因此造成线程不安全
            现象：所有的pool-1-thread-1 只会出现一次pool-1-thread-1:======bbb，
            pool-1-thread-2没有清除threadlocal，因此会出现多次 pool-1-thread-2aaaa
            */
        });
        tpool.submit(t1);

        for (int i = 0; i < 100; i++) {
            tpool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + Tools.tl.get());
            });
        }
        tpool.shutdown();
    }
}

class Tools {
    static ThreadLocal<String> tl = new ThreadLocal<>();
    public static void dd() {
        tl.set("aaaa");
    }
}



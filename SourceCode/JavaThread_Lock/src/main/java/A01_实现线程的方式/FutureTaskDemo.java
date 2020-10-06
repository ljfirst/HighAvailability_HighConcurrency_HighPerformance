package A01_实现线程的方式;

import java.util.concurrent.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class FutureTaskDemo extends FutureTask {

    public FutureTaskDemo(Callable callable) {
        super(callable);
    }

    public void test(){
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "i am FutureTaskDemo return";
            }
        });
    }
}

package B03_线程池;

import java.util.concurrent.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class SelfDefinitionThreadPool {

    public static ExecutorService get(int corePoolSize){
        return new ThreadPoolExecutor(corePoolSize, 20,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
    }

    private static Runnable runnable = ()->{
        System.out.println("线程的名字:" + Thread.currentThread().getName());
    };

    public static void main(String[] args) {
        ExecutorService service = SelfDefinitionThreadPool.get(5);
        for (int i = 0; i < 60; i++) {
            service.execute(runnable);
        }
        service.shutdown();
    }
}

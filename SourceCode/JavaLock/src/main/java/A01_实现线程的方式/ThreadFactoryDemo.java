package A01_实现线程的方式;

import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;


/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ThreadFactoryDemo {

    @Test
    public void test() {
        ThreadFactory tf = new CustomizableThreadFactory("aaa");
        ExecutorService exec = new
                ThreadPoolExecutor(1,1,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(10),tf);
        exec.submit(()->{
            System.out.println("i am ThreadFactoryDemo");
        });
    }
}

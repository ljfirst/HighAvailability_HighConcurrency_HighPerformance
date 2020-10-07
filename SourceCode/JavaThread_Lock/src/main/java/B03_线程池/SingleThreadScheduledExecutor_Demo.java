package B03_线程池;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class SingleThreadScheduledExecutor_Demo {

    public static Runnable forsingthreadsch = ()->{
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("main中线程的名字:" + Thread.currentThread().getName());
    };

    @Test
    public void test(){
        ExecutorService service = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 20; i++) {
            service.execute(forsingthreadsch);
        }
    }
}

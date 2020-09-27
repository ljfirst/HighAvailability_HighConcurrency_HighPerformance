package A01_实现线程的方式;

import org.junit.Test;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
@EnableAsync
public class AsyncDemoTest {

    @Test
    public void test1(){
        //去除TestController上的@EnableAsync或者new 一个TestService对象（该对象没有加载进Spring的容器中），
        //那么TestController中的print()方法都会同步执行，后台打印日志也可以看到只有一个线程在执行：
        //这就是为什么此处是同步显示的原因
        AsyncDemo asyncDemo = new AsyncDemo();
        asyncDemo.test();
        //既然是两个线程，那么效果应该是交替执行
        for (int i = 0; i < 100; i++) {
            System.out.println("======="+i);
        }
    }
}

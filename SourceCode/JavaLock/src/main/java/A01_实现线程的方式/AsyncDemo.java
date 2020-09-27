package A01_实现线程的方式;


/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
//@Service
public class AsyncDemo {

    //@Async
    public void test(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"   ==========");
        }
    }

}

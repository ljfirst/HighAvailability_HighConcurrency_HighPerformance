package A02_正确停止线程;

import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/12
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class VolatileStopThread extends Thread {

    volatile boolean flag = false;

    @Override
    public void run() {
        int num = 0;
        while (!flag && num <= 1500) {
            if (num / 15 == 0) {
                System.out.println(++num);
            }
        }
    }

    @Test
    public void test() throws Exception{
        VolatileStopThread vs = new VolatileStopThread();
        Thread t = new Thread(vs);
        t.start();
        Thread.sleep(5000);
        vs.flag=true;
    }
}

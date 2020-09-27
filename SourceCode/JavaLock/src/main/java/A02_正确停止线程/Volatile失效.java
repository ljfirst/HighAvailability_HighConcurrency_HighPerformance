package A02_正确停止线程;

import org.junit.Test;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/15
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description  失效原因是 BlockingQueue 的put 操作会引起 阻塞
 */

public class Volatile失效 {

    @Test
    public void testnoAction() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(8);
        Produce p = new Produce(queue);
        Thread t = new Thread(p);
        t.start();

        Consumer c = new Consumer(queue);
        while (c.needmoreNums()) {
            System.out.println(c.queue.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者结束了");
        p.flag = true;
        System.out.println("p.flag:" + p.flag);
    }
}

class Produce implements Runnable {
    public volatile boolean flag = false;
    BlockingQueue queue;

    public Produce(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 1000 && !flag) {
                if (num % 50 == 0) {
                    //此处因为一直在put,而队列的容量只有8个，所以装不下的时候，发送了阻塞
                    queue.put(num);
                    System.out.println("queue.put(num):" + num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Produce end");
        }
    }
}

class Consumer {
    BlockingQueue queue;

    public Consumer(BlockingQueue q) {
        this.queue = q;
    }

    public boolean needmoreNums() {
        if (Math.random() > 0.97) {
            return false;
        }
        return true;
    }
}
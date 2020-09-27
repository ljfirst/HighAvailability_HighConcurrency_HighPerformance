package distribute_main.distributeLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/29
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 分布式锁实现
 */
@Component
public class Dis_LockImpl implements Dis_Lock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ThreadLocal<String> threadLocal = new ThreadLocal();

    @Override
    public boolean lock(String key, long timeout, TimeUnit t) {
        boolean flag = false;
        long time = timeout / 2;
        if (threadLocal.get() == null) {//可重入
            Thread y = new Thread(() -> {//异步续时
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("=====lock=======" + Thread.currentThread().getName());
                    stringRedisTemplate.expire(key, timeout, t);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"线程已关闭："+Thread.currentThread().getId());
            });
            String uuid_put = y.getId() + ":" + UUID.randomUUID().toString();
            y.setDaemon(true);
            y.start();
            System.out.println("-----curr:"+Thread.currentThread().getName()+"=====demo:"+y.getName());
            threadLocal.set(uuid_put);
            flag = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid_put, timeout, t);

            if (!flag) {
                while (true) {//阻塞
                    flag = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid_put, timeout, t);
                    if (flag) {
                        break;
                    }
                }
            }
        } else if (threadLocal.get().equals(stringRedisTemplate.opsForValue().get(key))) {
            System.out.println(";;;;;;;;;;chongru======");
            return true;
        }
        return flag;
    }

    @Override
    public void unlock(String key) {
        String uuid_get = threadLocal.get();
        String threadid = uuid_get.split(":")[0];
        if (uuid_get.equals(stringRedisTemplate.opsForValue().get(key))) {
            stringRedisTemplate.delete(key);
            /*for (Thread t : Thread.getAllStackTraces().keySet()) {
                if (t.getName().equals(threadname)) {
                    System.out.println(t.getName());
                    t.isInterrupted();
                }
            }*/
            ThreadGroup group = Thread.currentThread().getThreadGroup();
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadid.equals(threads[i].getId())) {
                    threads[i].interrupt();
                    System.out.println("0000000000000置断点："+threadid);
                }
            }
            System.out.println("-----unlock:" + Thread.currentThread().getName());
            //阅后即焚，防止脏数据
            threadLocal.remove();
        }
    }
}

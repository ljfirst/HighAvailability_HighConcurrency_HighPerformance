package distribute_main.distributeLock;

import java.util.concurrent.TimeUnit;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/29
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 分布式锁
 */
public interface Dis_Lock {

    //加锁
    public boolean lock(String key, long timeout, TimeUnit t);

    //解锁
    public void unlock(String key);
}

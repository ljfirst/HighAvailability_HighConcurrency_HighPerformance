package distribute_main.control;

import distribute_main.distributeLock.Dis_LockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/16
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
@RestController
@RequestMapping("ljfirst")
public class DistbControl {

    @RequestMapping("test")
    public String test() {
        return "wwwww";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    Dis_LockImpl dis_lock;
    private String lockkey = "lockkey";


    @RequestMapping("distributedLock")
    public String countNum() {
        if (dis_lock.lock(lockkey, 2_000, TimeUnit.MILLISECONDS)) {
            try {
                int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
                if (stock > 0) {
                    stock--;
                    stringRedisTemplate.opsForValue().set("stock", stock + "");
                    try {
                        Thread.sleep(4_000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("success:   " + stock);
                } else {
                    System.out.println("失败：error");
                }
            } finally {
                dis_lock.unlock(lockkey);
            }
        }
        return "end";
    }
}

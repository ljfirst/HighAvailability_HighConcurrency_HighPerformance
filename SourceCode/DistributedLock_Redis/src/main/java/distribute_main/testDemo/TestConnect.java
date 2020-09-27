package distribute_main.testDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/23
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestConnect {

    @Autowired
    //此处使用 @Resource，会在redis中显示乱码
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void set() {
        Random r = new Random();
        int y = r.nextInt(10000);
        redisTemplate.opsForValue().set("lisi", "liuj"+y);
        System.out.println(redisTemplate.opsForValue().get("lisi"));
    }

}

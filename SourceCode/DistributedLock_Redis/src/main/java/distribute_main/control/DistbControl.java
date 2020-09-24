package distribute_main.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //@Autowired
    //private StringRedisTemplate stringRedisTemplate;

    /*@RequestMapping("distributedLock")
    public String ff() {
        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        if (stock > 0) {
            stock--;
            stringRedisTemplate.opsForValue().set("stock", stock + "");
            System.out.println("success:   " + stock);
        } else {
            System.out.println("error");
        }
        return "end";
    }*/
}

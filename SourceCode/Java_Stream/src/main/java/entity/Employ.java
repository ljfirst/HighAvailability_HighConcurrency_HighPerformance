package entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
public class Employ {
    int age;
    String name;
    String addr;
    double salary;

    public List getEmploylist() {
        List list = new ArrayList() {{
            add(new Employ(12, "zhangsan1", "黄浦区", 1200.34));
            add(new Employ(13, "zhangsan2", "黄浦区", 1200.34));
            add(new Employ(14, "zhangsan3", "黄浦区", 2400.34));
            add(new Employ(15, "zhangsan4", "闵行区", 2400.34));
            add(new Employ(16, "zhangsan5", "闵行区", 3600.34));
            add(new Employ(17, "zhangsan6", "闵行区", 3600.34));
            add(new Employ(18, "zhangsan7", "浦东新区", 1200.34));
            add(new Employ(19, "zhangsan8", "浦东新区", 1200.34));
            add(new Employ(12, "zhangsan9", "浦东新区", 1200.34));
            add(new Employ(13, "zhangsan10", "宝山区", 8567.098));
            add(new Employ(14, "zhangsan11", "宝山区", 654.345));
            add(new Employ(15, "zhangsan12", "宝山区", 765.234));
            add(new Employ(16, "zhangsan13", "宝山区", 43.65));
        }};
        return list;
    }
}

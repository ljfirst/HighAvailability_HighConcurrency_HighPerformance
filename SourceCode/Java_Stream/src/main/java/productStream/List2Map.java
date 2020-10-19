package productStream;

import entity.Employ;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description List2Map
 */
public class List2Map {

    @Test
    public void list2Map() {
        Employ employ = new Employ();
        List<Employ> list = employ.getEmploylist();
        Map<String, Double> map = list.stream().collect(Collectors.toMap(Employ::getName, Employ::getSalary));

        for (String i : map.keySet()) {
            System.out.println("key:   " + i + "     value:  " + map.get(i));
        }
    }
}

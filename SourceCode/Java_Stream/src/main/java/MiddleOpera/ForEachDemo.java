package MiddleOpera;

import entity.Employ;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ForEachDemo {

    @Test
    public void forecahdemoStudent(){
        Employ employ = new Employ();
        List<Employ> list = employ.getEmploylist();
        list.stream().map(Employ::getAddr).
                collect(Collectors.toList()).
                //forEach(b-> System.out.println(b));
                forEach(System.out::println);
    }
}

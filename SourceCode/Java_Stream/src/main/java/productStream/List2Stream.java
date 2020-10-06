package productStream;

import entity.Employ;

import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class List2Stream {

    public void list2Stream() {
        Employ employ = new Employ();
        List<Employ> list = employ.getEmploylist();
        //list.stream().mapToDouble(Employ::getSalary).collect();
    }
}

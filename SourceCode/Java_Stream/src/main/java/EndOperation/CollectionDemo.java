package EndOperation;

import entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/8
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class CollectionDemo {

    Student s = new Student();

    @Test
    public void demo() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List l = Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}

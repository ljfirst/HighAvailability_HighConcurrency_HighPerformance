package EndOperation;

import entity.Student;
import org.junit.Test;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/8
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description FindFirst_Any
 */
public class FindFirst_Any_Demo {

    Student s = new Student();

    @Test
    public void demo() {
        List<Student> l = s.getStudentlist();
        l.stream().findFirst().ifPresent(System.out::print);
        System.out.println("\n===================\n");

        l.stream().findAny().ifPresent(System.out::print);
        //加入parallel后，结果可能会和findFirst不一样，并且每次结果可能都不一样
        l.stream().parallel().findAny().ifPresent(System.out::print);
        System.out.println();

        /*Optional<String> stringOptional =
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .findFirst();
        stringOptional.ifPresent(e -> System.out.println(e));*/
    }
}

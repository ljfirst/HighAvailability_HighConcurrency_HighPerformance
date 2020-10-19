package MiddleOpera;

import entity.Student;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/8
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description max_min 最大 最小 操作
 */
public class Max_MinDemo {

    Student student = new Student();
    List<Student> list = student.getStudentlist();

    @Test
    public void demo() {
        Stream.of(0, 9, 8, 4, 5, 6, -1)
                .max(Integer::compareTo)
                .ifPresent(System.out::print);
        System.out.println("\n\n===ifPresent()=====\n");

        list.stream()
                .min(Comparator.comparing(x -> x.getAge()))
                .ifPresent(System.out::print);

        System.out.println("\n\n===get()=====\n");
        Student u = list.stream()
                .max(Comparator.comparing(x -> x.getAge()))
                .get();
        System.out.println(u.toString());

    }
}

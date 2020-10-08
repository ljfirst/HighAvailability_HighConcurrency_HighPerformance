package MiddleOpera;

import entity.Student;
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
public class LimitDemo {
    @Test
    public void limitDemoStudent() {
        Student student = new Student();
        List<Student> l = student.getStudentlist();
        l.stream().
                filter(student1 -> (17 == student1.getAge())).
                forEach(System.out::println);

        System.out.println("\n=======limit=======\n");
        //limit
        l.stream().
                filter(student1 -> (17 == student1.getAge())).
                limit(3).
                forEach(System.out::println);
    }
}

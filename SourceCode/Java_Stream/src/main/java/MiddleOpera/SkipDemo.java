package MiddleOpera;

import entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description skip
 */
public class SkipDemo {

    @Test
    public void skipdemo() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        list.stream()
                .filter(x -> x.getAge() > 16)
                .forEach(System.out::println);
        System.out.println("\n=======   skip  ======\n");
        list.stream()
                .filter(x -> x.getAge() > 16)
                .skip(2)
                .forEach(System.out::println);
    }
}

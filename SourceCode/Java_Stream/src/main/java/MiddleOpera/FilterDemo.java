package MiddleOpera;

import entity.Employ;
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
public class FilterDemo {

    //filter Demo
    @Test
    public void filterDemoStudent() {
        Student student = new Student();
        List<Student> l = student.getStudentlist();
        l = l.stream()
                .filter(student1 -> (15 >= student1.getAge())).
                collect(Collectors.toList());
        for (Student ss : l) {
            System.out.println(ss.toString());
        }
    }

    @Test
    public void filterDemoEmploy() {
        Employ employ = new Employ();
        List<Employ> l = employ.getEmploylist();
        l.stream()
                .filter(employ1 -> ("宝山区" == employ1.getAddr()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}

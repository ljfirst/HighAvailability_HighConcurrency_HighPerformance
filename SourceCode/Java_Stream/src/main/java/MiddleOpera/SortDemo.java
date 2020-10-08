package MiddleOpera;

import entity.Employ;
import entity.Student;
import org.junit.Test;

import java.util.Comparator;
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
public class SortDemo {

    //sort demo
    @Test
    public void sortDemoStudent() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        list = list.stream().
                sorted(Comparator.comparing(Student::getAge)).
                collect(Collectors.toList());
        for (Student s : list) {
            System.out.println(s.toString());
            ;
        }
    }

    @Test
    public void sortDemoStudent1() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        list.stream()
                //.sorted(Comparator.comparing(Student::getAge))
                .sorted(
                        (x1, x2) -> x1.getAge() > x2.getAge() ? 1 : x1.getAge() == x2.getAge() ? 0 : -1
                )
                .forEach(System.out::println);
    }

    @Test
    public void sortDemoEmploy() {
        Employ employ = new Employ();
        List<Employ> list = employ.getEmploylist();
        list.stream()
                .sorted(Comparator.comparing(Employ::getSalary))
                .forEach(System.out::println);
    }
}

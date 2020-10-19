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
 * @description sort
 */
public class SortDemo {

    Student student = new Student();

    //sort demo
    @Test
    public void sortDemoStudent() {
        List<Student> list = student.getStudentlist();
        list.stream().
                sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void sortDemoStudent1() {
        List<Student> list = student.getStudentlist();
        list.stream().sorted(
                //(x1, x2) -> x1.getAge() > x2.getAge() ? 1 : x1.getAge() == x2.getAge() ? 0 : -1
                (x1, x2) -> Integer.compare(x1.getAge(), x2.getAge())
                ).forEach(System.out::println);
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

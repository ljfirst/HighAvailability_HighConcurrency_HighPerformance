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
public class MapDemo {

    //Map demo
    @Test
    public void mapDemoStudent() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        List<String> l = list.stream().map(Student::getAddress).collect(Collectors.toList());
        //List<String> l = list.stream().map(x->x.getAddress()).collect(Collectors.toList());
        for(String s:l){
            System.out.println(s);
        }
    }
    @Test
    public void mapDemoStudent1() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        list.stream().
                //map(x->x.getClassname().length()).
                map(x->x.getName().length()).
                collect(Collectors.toList()).
                forEach(System.out::println);
    }

    @Test
    public void mapDemoEmploy() {
        Employ employ = new Employ();
        List<Employ> list = employ.getEmploylist();
        List<String> l = list.stream().
                map(Employ::getAddr).
                //map(x->x.getAddr())
                collect(Collectors.toList());
        for(String s:l){
            System.out.println(s);
        }
    }
}

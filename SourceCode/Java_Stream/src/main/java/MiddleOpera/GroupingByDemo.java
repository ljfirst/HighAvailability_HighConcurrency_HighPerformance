package MiddleOpera;

import entity.Student;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class GroupingByDemo {
    //groupingBy
    @Test
    public void groupingBydemoStudent() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        Map<Integer, List<Student>> map = list.stream().
                collect(Collectors.groupingBy(Student::getAge));

        //如何打印Map
        for (Integer i :map.keySet()) {
            System.out.println("===="+i+":=====");
            List<Student> l = map.get(i);
            for(Student ss :l){
                System.out.print(ss.toString()+"  -  ");
            }
            System.out.println();
        }
    }
}

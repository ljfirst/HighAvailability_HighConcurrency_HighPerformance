package MiddleOpera;

import entity.Student;
import org.junit.Test;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/8
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description peek 操作
 */
public class PeekDemo {

    @Test
    public void peekDemo() {
        Student s = new Student();
        List<Student> list = s.getStudentlist();
        list.stream()
                .peek(x->x.setName(x.getClassname()+x.getAge()))
                .forEach(System.out::println);
    }
}

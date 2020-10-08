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
 * @description
 */
public class CountDemo {
    Student student = new Student();

    @Test
    public void distinctdemoStudent() {
        List<Student> list = student.getStudentlist();
        //注意 返回的是 long 类型
        long i = list.stream().count();
        System.out.println(i);
    }
}

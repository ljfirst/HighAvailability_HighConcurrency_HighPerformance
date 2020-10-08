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
 * @description 规约操作
 */
public class ReduceDemo {
    Student student = new Student();
    List<Student> list = student.getStudentlist();

    @Test
    public void Reduce() {

        //先map 再reduce
        int ageSum = list.stream()
                .map(x -> x.getAge())
                .reduce(0, (x1, x2) -> x1 + x2);
        System.out.println(ageSum);
    }
}

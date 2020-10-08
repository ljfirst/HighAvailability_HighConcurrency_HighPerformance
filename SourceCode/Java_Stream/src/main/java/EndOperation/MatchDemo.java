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
 * @description 主要介绍 noneMatch 、allMatch 和 anyMatch
 */
public class MatchDemo {
    Student student = new Student();
    List<Student> list = student.getStudentlist();
    @Test
    public void noneMatch() {

        //注意 返回的是 long 类型
        list.stream().forEach(System.out::println);
        System.out.println("=============\n");
        //16存在，则返回false,26不存在，则返回true
        boolean t = list.stream().noneMatch(x -> x.getAge() == 16);
        boolean t1 = list.stream().noneMatch(x -> x.getAge() == 26);
        System.out.println(t);
        System.out.println(t1);
    }

    @Test
    public void allMatch(){
        //全部都含有班这个字
        boolean t = list.stream().allMatch(x -> x.getClassname().contains("班"));
        System.out.println(t);
    }

    @Test
    public void anyMatch(){
        //只要有一个含有 李四4
        boolean t = list.stream().anyMatch(x -> x.getName().equals("李四4"));
        System.out.println(t);
    }

}

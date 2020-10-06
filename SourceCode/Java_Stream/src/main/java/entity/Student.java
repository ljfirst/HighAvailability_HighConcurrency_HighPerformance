package entity;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/7/13
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString(of={"name","age","classname"},exclude = {"address"})
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    int age;
    String classname;
    String address;
    //@Cleanup 自动关闭资源，针对实现了java.io.Closeable接口的对象有效，如：典型的IO流对象
    public List getStudentlist() {
        List StudentList = new ArrayList<Student>() {
            {
                add(new Student("张三", 13, "三班", "门前路333号"));

                add(new Student("李四", 14, "四班", "门前路444号"));
                add(new Student("李四1", 14, "四班", "门前路444号"));
                add(new Student("李四2", 14, "四班", "门前路444号"));
                add(new Student("李四3", 15, "四班", "门前路444号"));
                add(new Student("李四4", 15, "四班", "门前路444号"));
                add(new Student("李四5", 15, "四班", "门前路444号"));

                add(new Student("王五", 15, "五班", "门前路555号"));
                add(new Student("刘六", 16, "六班", "门前路666号"));

                add(new Student("孙七", 17, "七班", "门前路777号"));
                add(new Student("孙七1", 17, "七班", "门前路777号"));
                add(new Student("孙七2", 17, "七班", "门前路778号"));
                add(new Student("孙七3", 17, "七班", "门前路779号"));
                add(new Student("孙七4", 17, "七班", "门前路779号"));
            }
        };
        return StudentList;
    }
}

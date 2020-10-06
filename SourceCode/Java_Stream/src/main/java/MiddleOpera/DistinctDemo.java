package MiddleOpera;

import entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class DistinctDemo {

    @Test
    public void distinctdemoStudent() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        long i = list.stream().distinct().count();
        System.out.println(i);
    }

    @Test
    //distinct（）不提供按照属性对 对象列表 进行去重的直接实现
    public void distinctdemoStudent1() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        list.stream().
                filter(distinctByKey(b -> b.getClassname())).
                forEach(System.out::println);
    }

    @Test
    public void distinctdemoStudent2() {
        Student student = new Student();
        List<Student> list = student.getStudentlist();
        // 根据 age,classname 两个属性去重
        /*list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(
                                Comparator.comparing(o -> o.getAge() + ";" + o.getClassname()
                                ))
                        ), ArrayList::new)).
                forEach(System.out::println);*/

        list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(
                                Comparator.comparing(o -> o.getAge() + ";" + o.getClassname()
                                ))
                        ), ArrayList::new)).
                forEach(System.out::println);
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

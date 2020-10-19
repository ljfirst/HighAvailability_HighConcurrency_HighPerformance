package MiddleOpera;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description iterate_generate
 */
public class Function2Stream {

    @Test
    public void method1() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(5);
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void method2() {
        Stream<Double> stream = Stream.generate(Math::random).limit(5);
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }
}

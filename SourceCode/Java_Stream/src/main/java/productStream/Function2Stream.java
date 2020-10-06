package productStream;

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
 * @description
 */
public class Function2Stream {

    @Test
    public void method1() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(5);
        List<Integer> l = stream.collect(Collectors.toList());
        for(Integer ii : l){
            System.out.println(ii);
        }
    }

    @Test
    public void method2() {
        Stream<Double> stream = Stream.generate(Math::random).limit(5);
        List<Double> l = stream.collect(Collectors.toList());
        for(Double ii : l){
            System.out.println(ii);
        }
    }
}

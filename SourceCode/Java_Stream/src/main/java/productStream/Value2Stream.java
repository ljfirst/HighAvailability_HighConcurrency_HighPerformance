package productStream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description  Value2Stream 将一组数转换成stream
 */
public class Value2Stream {

    @Test
    public void value2stream() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.distinct().forEach(ii -> {
            System.out.println(ii);
        });
    }
}

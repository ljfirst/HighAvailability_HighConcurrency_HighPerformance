package productStream;

import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class Value2Stream {
    public void value2stream() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }
}

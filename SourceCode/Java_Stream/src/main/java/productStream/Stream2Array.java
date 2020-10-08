package productStream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/8
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class Stream2Array {

    @Test
    public void test() {
        Object[] array = Stream.of(1, 3, 4, 6, 94, 3, 90, 5, 77, 6, 54, 3).toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

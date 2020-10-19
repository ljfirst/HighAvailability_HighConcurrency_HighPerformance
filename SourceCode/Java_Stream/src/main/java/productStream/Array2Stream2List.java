package productStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description Array2Stream2List
 */
public class Array2Stream2List {

    @Test
    public void array2list() {
        //int数组不可以
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> l = Arrays.stream(arr).filter(x -> x % 2 == 0).
                collect(Collectors.toList());
        for (int i : l) {
            System.out.println(i);
        }
    }
}

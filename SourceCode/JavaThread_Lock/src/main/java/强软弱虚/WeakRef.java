package 强软弱虚;


import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/17
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 弱引用
 * 弱引用的特点是不管内存是否足够，只要发生GC，都会被回收
 */
public class WeakRef {

    @Test
    public void test() {
        WeakReference<byte[]> weakReference = new WeakReference<byte[]>(new byte[1]);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }

}

package 强软弱虚;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/17
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 软引用
 * 当内存不足，会触发JVM的GC，如果GC后，内存还是不足，就会把软引用的包裹的对象给干掉，
 * 也就是只有在内存不足，JVM才会回收该对象
 */
public class SoftRef {
    @Test
    public void test() {
        SoftReference<byte[]> softReference = new SoftReference<byte[]>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());

        //测试的时候，需要设置VM Operation
        //第一步：Edit Configurations，在VmOperationa里面设置：-Xmx20M
        //第二步：如果第一步不生效，看一下Maven的import，并修改
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get());
    }
}

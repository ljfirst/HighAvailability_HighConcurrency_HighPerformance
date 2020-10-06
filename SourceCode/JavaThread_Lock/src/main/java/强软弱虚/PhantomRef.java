package 强软弱虚;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/17
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 虚引用
 * 无法通过虚引用来获取对一个对象的真实引用
 *
 * 虚引用必须与ReferenceQueue一起使用，当GC准备回收一个对象，
 * 如果发现它还有虚引用，就会在回收之前，把这个虚引用加入到与之关联的ReferenceQueue中
 *
 * 当发生GC，虚引用就会被回收，并且会把回收的通知放到ReferenceQueue中。
 *
 * 虚引用有什么用呢？在NIO中，就运用了虚引用管理堆外内存
 */
public class PhantomRef {

    @Test//此处证明
    public void test01(){
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<byte[]> reference = new PhantomReference<byte[]>(new byte[1], queue);
        System.out.println(reference.get());
    }

    @Test//此处证明
    public void test(){
        ReferenceQueue queue = new ReferenceQueue();
        List<byte[]> bytes = new ArrayList<>();
        PhantomReference<StrongRef> reference = new PhantomReference<StrongRef>(new StrongRef(),queue);
        new Thread(() -> {
            for (int i = 0; i < 100;i++ ) {
                bytes.add(new byte[1024 * 1024]);
                System.out.println("+++++add+++++++");
            }
        }).start();
        /*
        两个线程交替执行，第一次GC的时候，会打印出："虚引用被回收了"
        后续会一直持续到OOM：
        Exception in thread "Thread-0" java.lang.OutOfMemoryError: Java heap space
        */

        new Thread(() -> {
            while (true) {
                Reference poll = queue.poll();
                if (poll != null) {
                    System.out.println("虚引用被回收了：" + poll);
                }
                System.out.print("====--------======|||");
            }
        }).start();
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
    }
}

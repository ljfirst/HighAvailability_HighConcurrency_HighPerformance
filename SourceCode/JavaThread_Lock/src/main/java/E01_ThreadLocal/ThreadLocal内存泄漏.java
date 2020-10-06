package E01_ThreadLocal;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/16
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description 验证 ThreadLocal 存在 内存泄漏
 */
public class ThreadLocal内存泄漏 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Task().calc(10);
            //通过下方的Evaluate Expression 可以看出在80前后回收了 线程里面的内容
            //但是仅仅回收了map 的 key（当前的ThreadLocal），并不是回收Value。
            //因此存在内存溢出的问题。
            if (i == 80) {
                System.gc();
            }
        }
    }

    static class Task {
        ThreadLocal<Integer> value;

        public int calc(int i) {
            value = new ThreadLocal();
            value.set((value.get() == null ? 0 : value.get()) + i);
            return value.get();
        }
    }
}

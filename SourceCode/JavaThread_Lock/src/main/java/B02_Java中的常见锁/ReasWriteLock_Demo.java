package B02_Java中的常见锁;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/10/7
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description
 */
public class ReasWriteLock_Demo {

    private static Map<String, String> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock w = lock.writeLock();
    private static Lock r = lock.readLock();

    public static Object read(String key) {
        try {
            r.lock();
            System.out.println("+++=====read key:" + key + "【");
            Object oj = map.get(key);
            System.out.println("+++=====read key:" + key + "value:" + oj + "】");
            System.out.println();
            return oj;
        } finally {
            r.unlock();
        }
    }

    public static Object write(String key, String value) {
        try {
            w.lock();
            System.out.println("=====write key:" + key + "value:" + value + "【");
            Object oj = map.put(key, value);
            System.out.println("=====write key:" + key + "value:" + value + "】");
            System.out.println();
            return oj;
        } finally {
            w.unlock();
        }
    }

    private static Runnable readThread = () -> {
        for (int i = 0; i < 20; i++) {
            ReasWriteLock_Demo.read(i + "");
        }
    };
    private static Runnable writeThread = () -> {
        for (int i = 0; i < 20; i++) {
            ReasWriteLock_Demo.write(i + "", i + "");
        }
    };

    public static void main(String[] args) {
        Thread tR = new Thread(readThread);
        Thread tW = new Thread(writeThread);
        tR.start();
        tW.start();
    }
}

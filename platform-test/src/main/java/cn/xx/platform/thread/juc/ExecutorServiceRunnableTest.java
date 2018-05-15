package cn.xx.platform.thread.juc;/**
 * Created by Administrator on 2018/3/19.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 16:11 2018/3/19
 * @Modified By:
 */
public class ExecutorServiceRunnableTest {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int k=i;
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        String currentName=Thread.currentThread().getName();
                        System.out.println("[" + currentName + "]  start...."+k);
                        Thread.sleep((int) (Math.random() * 10000));
                        System.out.println("[" + currentName + "] end."+k);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        long end=System.currentTimeMillis();
        System.out.println("finish waist :" + (end - start));
        executorService.shutdown();
    }
}

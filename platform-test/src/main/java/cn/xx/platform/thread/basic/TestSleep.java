package cn.xx.platform.thread.basic;/**
 * Created by Administrator on 2018/3/12.
 */

import java.lang.*;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 9:44 2018/3/12
 * @Modified By:
 */
public class TestSleep extends Thread {
    private int i = 0;
    private Object o=new Object();
    public static void main(String[] args) {
        System.out.println("进入线程"+Thread.currentThread().getName());
        TestSleep thread = new TestSleep();
        ThreadTest thread1 = thread.new ThreadTest();
        ThreadTest thread2 = thread.new ThreadTest();
        thread1.start();
        thread2.start();
    }
    synchronized void testSleep(){
        i++;
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠前i:"+i);
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        i++;
        System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束后i:"+i);
    }
    class ThreadTest extends Thread {
        @Override
        public void run() {
//            synchronized (o){
//                for (int j = 0; j < 10; j++) {
//                    i++;
//                    Thread thread = Thread.currentThread();
//                    System.out.println("当前线程名字：" + thread.getName() + " 执行的i值:" + i);
//                }
//            }
            testSleep();
        }

    }
}

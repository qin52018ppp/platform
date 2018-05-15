package cn.xx.platform.thread.basic;/**
 * Created by Administrator on 2018/3/13.
 */

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 16:11 2018/3/13
 * @Modified By:
 */
public class TestRunable implements Runnable {
    private int i=100;
    public void run() {
        i--;
        System.out.println(Thread.currentThread().getName()+"has execute"+i);
    }

    public static void main(String[] args) {
        TestRunable testRunable=new TestRunable();
        new Thread(testRunable).start();
        new Thread(testRunable).start();
        new Thread(testRunable).start();
        new Thread(testRunable).start();
    }
}

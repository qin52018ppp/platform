package cn.xx.platform.thread.juc;/**
 * Created by Administrator on 2018/3/19.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:10 2018/3/19
 * @Modified By:
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        final Semaphore s=new Semaphore(2);//创建Semaphore信号量，初始化许可大小为3
        for (int i = 1; i <5 ; i++) {
            final int index=i;
            service.execute(new Runnable() {
                public void run() {
                    try {
                        s.acquire();//请求获得许可，如果有可获得的许可则继续往下执行，许可数减1。否则进入阻塞状态
                        String currentName=Thread.currentThread().getName();
                        System.out.println("[" + currentName + "]  start....executor序号:"+index+",当前已有" + (2-s.availablePermits()) + "个并发 begin");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("[" + currentName + "]  start....executor序号:"+index+",当前已有" + (2-s.availablePermits()) + "个并发 end");
                        s.release();//释放许可，许可数加1
                        // 下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                        System.out.println("[" + currentName + "]  start....executor序号:"+index+",当前已有" + (2-s.availablePermits()) + "个并发 no");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}

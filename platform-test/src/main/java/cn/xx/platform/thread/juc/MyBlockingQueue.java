package cn.xx.platform.thread.juc;

import java.util.concurrent.*;

public class MyBlockingQueue extends Thread {
    static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    public static void main(String args[]) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index=i;
            service.submit(new Runnable() {
                public void run() {
                    try {
                        queue.put(String.valueOf(index));
                        System.out.println("{" + index + "} in queue!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread thread = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep((int) (Math.random() * 1000));
                        System.out.println("=======" + MyBlockingQueue.queue.size());
                        if (MyBlockingQueue.queue.isEmpty())
                            break;
                        String str = MyBlockingQueue.queue.take();
                        System.out.println(str + " has take!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        service.submit(thread);
        service.shutdown();
    }
}
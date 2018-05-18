package cn.xx.platform.pattern;/**
 * Created by Administrator on 2018/5/16.
 *
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 10:11 2018/5/16
 * @Modified By:
 */

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 10:11 2018/5/16
 * @Modified By:
 */

/**
 * 懒汉式，线程不安全
 */
class MySingleton1 {
    private static MySingleton1 instance;

    private MySingleton1() {
    }

    public static MySingleton1 getInstance() {
        if (instance == null) {
            instance = new MySingleton1();
        }
        return instance;
    }
}

/**
 * 懒汉式，线程安全  效率不咋的
 */
class MySingleton2 {
    private static MySingleton2 instance;

    private MySingleton2() {
    }

    public static synchronized MySingleton2 getInstance() {
        if (instance == null) {
            instance = new MySingleton2();
        }
        return instance;
    }
}

/**
 * 饿汉式，线程安全
 */
class MySingleton3 {
    private static MySingleton3 instance = new MySingleton3();

    private MySingleton3() {
    }

    public static MySingleton3 getInstance() {
        return instance;
    }
}

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
class MySingleton4 {
    private static MySingleton4 instance;

    private MySingleton4() {
    }

    public static MySingleton4 getInstance() {
        if (instance == null) {
//            synchronized(this)是对象锁，如果有多个对象就有相对应的多个锁
//            synchronized(类的名.class)是全局锁，不管有几个对象就公用一把锁
            synchronized (MySingleton4.class) {
                if (instance == null) {
                    instance = new MySingleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 登记式 单例 静态内部类
 */
class MySingleton5 {
    private static class SingletonHolder {
        private static final MySingleton5 INSTANCE = new MySingleton5();
    }

    private MySingleton5() {
    }

    public static final MySingleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

enum SingletonPartten {
    INSTANCE;

    public void method() {
        System.out.println("do Something");
    }
}

enum Color {
    RED(1), GREEN(2), BLUE(3);
    private int code;

    Color(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

enum Reason {
    chun, xia, qiu, dong;

    Reason() {
        System.out.println("构造函数被调用");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print() {
        System.out.println("调用枚举类的静态方法");
    }
}

public class Singleton {
    public static void main(String[] args) {
//            SingletonPartten.INSTANCE.method();
        Reason.print();
    }
}
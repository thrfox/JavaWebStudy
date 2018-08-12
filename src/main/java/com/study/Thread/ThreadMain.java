package com.study.Thread;

import org.junit.Test;

/**
 * 多线程
 */
public class ThreadMain {

    /*
     * 2.sleep() 和 wait()的区别
     * sleep()不能被wake up(notify)，而wait()可以，并且wait()和notify()只能在synchronize同步块中使用
     * sleep()是由Thread类调用的(Thread.sleep())，而wait()是由需要指定synchronize的锁来调用(Object.wait())
     * sleep()不会释放锁，wait()会将线程释放锁并放入等待池。
     * 即sleep会让线程带着锁进入阻塞状态，wait()会交出锁再进入阻塞状态，notify()后会进入就绪状态，但如果得不到锁，就无法进入运行状态。
     * sleep是 ： 运行 → 阻塞 → (sleep结束)运行
     * wait是  ： 运行 → 阻塞 → (notify)就绪 → (拿到锁后)运行
     */
    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        Thread sleepThread = new Thread(new sleepThread(service));
        Thread waitThread = new Thread(new waitThread(service));

        //先调用sleep线程，再调用wait线程
//        sleepThread.start();
//        waitThread.start();
        //先调用wait线程，再调用sleep线程
        waitThread.start();
        sleepThread.start();
    }

    /*
     * 1.start() 和 run()的区别
     * 首先需要先理解线程的5种状态：
     * <1>.创建  <2>.就绪  <3>.运行  <4>.阻塞 <5>.死亡
     * start()才会创建新的线程。将线程置于就绪状态，但该线程还没开始运行，只有当CPU把该线程置为当前线程时，才会执行run()方法，
     * run()方法本质上其实是runable接口定义的普通方法，只是将该方法内的代码执行，不会创建新的线程。只有执行start()才实现了多线程运行。
     */
    @Test
    public void startAndRun(){

        //此时的new 为状态1:创建线程
        Thread thread1 = new Thread("线程1-"){
            public void run(){
                System.out.println("线程1进入run方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println(currentThread().getName() + i);
                }
            }
        };
        Thread thread2 = new Thread("线程2-"){
            public void run(){
                System.out.println("线程2进入run方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println(currentThread().getName() + i);
                }
            }
        };

//        System.out.println("--------start()--------");
//        //此时的start输出可以看到两个线程是交叉执行的
//        thread1.start();
//        thread2.start();
//        System.out.println("--------run()--------");
        //此时输出可以看到是顺序执行的，因为其实只是单纯的调用了thread1中run()方法，此时的run方法是运行在主线程main上的
        thread1.run();
        thread2.run();
    }

}

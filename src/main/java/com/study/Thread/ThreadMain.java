package com.study.Thread;

import org.junit.Test;

/**
 * 多线程
 */
public class ThreadMain {

    /*
     * 1.start() 和 run()的区别
     * 首先需要先理解线程的5种状态：
     * <1>.创建  <2>.就绪  <3>.运行  <4>.阻塞 <5>.死亡
     * start()将线程置于就绪状态，但该线程还没开始运行，只有当CPU把该线程置为当前线程时，才会执行run()方法，会创建新的线程。
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
    /*
     * 2.sleep() 和 wait()的区别
     */

}

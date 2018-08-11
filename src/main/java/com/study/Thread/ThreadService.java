package com.study.Thread;

public class ThreadService {
    void MySleep() {
        //此处的this为同一个锁ThreadService
        synchronized (this) {
            try {
                System.out.println("sleepThread睡眠3秒开始");
                Thread.sleep(3 * 1000); // 睡眠3秒
                //1.线程sleep后启动MyWait，但sleep后将锁带入，mywait拿不到锁造成死锁
//                this.notifyAll();
                System.out.println("sleepThread睡眠3秒结束");
                //2.线程sleep结束启动MyWait，此时mywait可以拿到锁
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void MyWait() {
        synchronized (this) {
            try {
                System.out.println("waitThread等待开始");
                this.wait(); // 等待直到调用notify
                System.out.println("waitThread等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.study.Thread;

public class sleepThread implements Runnable {
    private ThreadService service;

    public sleepThread(ThreadService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.MySleep();
    }
}

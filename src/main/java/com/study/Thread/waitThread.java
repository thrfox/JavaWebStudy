package com.study.Thread;

public class waitThread implements Runnable {
    private ThreadService service;

    public waitThread(ThreadService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.MyWait();
    }
}

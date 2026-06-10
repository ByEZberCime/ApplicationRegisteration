package com.applicationregisteration.fx.byezbercime.schedules.impl;

import androidx.appcompat.app.AppCompatActivity;

public abstract class TimeSchedules {

    AppCompatActivity instance;
     Thread schedules;
    private long tick;

    public TimeSchedules() {

        if (!String.valueOf(tick).isEmpty()) {
            schedules = new Thread(()-> {
                while (true) {

                    backgroundSyncTickTimer();

                    try {
                        Thread.sleep(tick);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            schedules.setDaemon(false);
            schedules.start();
        }

    }

    public TimeSchedules runSyncSchedulers(long tick) {
        this.tick = tick;
        return this;
    }

    protected abstract void backgroundSyncTickTimer();

    public AppCompatActivity getInstance() {
        return instance;
    }

    public void setInstance(AppCompatActivity instance) {
        this.instance = instance;
    }
}

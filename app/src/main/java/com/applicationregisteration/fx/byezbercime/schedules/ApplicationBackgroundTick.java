package com.applicationregisteration.fx.byezbercime.schedules;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.applicationregisteration.fx.byezbercime.MainPageActivity;
import com.applicationregisteration.fx.byezbercime.managers.BackgroundSyncCooldownManager;
import com.applicationregisteration.fx.byezbercime.schedules.impl.TimeSchedules;

import java.util.Map;

public class ApplicationBackgroundTick extends TimeSchedules {

    private MainPageActivity instance;
    private BackgroundSyncCooldownManager syncCooldownManager;

    public ApplicationBackgroundTick(MainPageActivity instance) {

        syncCooldownManager = new BackgroundSyncCooldownManager();

        this.instance = instance;
        setInstance(instance);

    }

    @Override
    protected void backgroundSyncTickTimer() {
        if (!syncCooldownManager.getBackgroundSyncCooldowns().isEmpty()) {
            for (Map.Entry<String, Long> entry : syncCooldownManager.getBackgroundSyncCooldowns().entrySet()) {

                long beforeDate = entry.getValue();
                long nowDate = System.currentTimeMillis();

                if (entry.getKey().equals("error_is_empty")) {
                    if (instance.isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorRegisterEmptyMessage().setVisibility(View.INVISIBLE);
                                instance.getErrorContainer().setVisibility(View.INVISIBLE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_password_wrong")) {
                    if (instance.isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorPasswordMessage().setVisibility(View.INVISIBLE);
                                instance.getErrorContainer().setVisibility(View.INVISIBLE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_email")) {
                    if (instance.isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorMailMessage().setVisibility(View.INVISIBLE);
                                instance.getErrorContainer().setVisibility(View.INVISIBLE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_birthday")) {
                    if (instance.isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorBirthdayMessage().setVisibility(View.INVISIBLE);
                                instance.getErrorContainer().setVisibility(View.INVISIBLE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                }


            }
        }
    }

    public BackgroundSyncCooldownManager getSyncCooldownManager() {
        return syncCooldownManager;
    }
}

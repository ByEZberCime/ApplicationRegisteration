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
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorRegisterEmptyMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_password_wrong")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorPasswordMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_email")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorMailMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_birthday")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorBirthdayMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_of_name")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorNameWrongMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_of_username")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorUsernameWrongMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_of_username_uppercase")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorUsernameUppercaseInvalidMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_phonenumber_invalid")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorPhonenumberInvalidMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("error_is_country_not_support")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getErrorCountryIsNotSupportedMessage().setVisibility(View.GONE);
                                instance.getErrorContainer().setVisibility(View.GONE);

                            }
                        });

                        syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                    }
                } else if (entry.getKey().equals("success_registered_content")) {
                    if (instance.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                instance.getSuccessRegisteredMessage().setVisibility(View.GONE);
                                instance.getSuccessContainer().setVisibility(View.GONE);

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

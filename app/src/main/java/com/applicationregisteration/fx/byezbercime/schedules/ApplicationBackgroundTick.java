package com.applicationregisteration.fx.byezbercime.schedules;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.applicationregisteration.fx.byezbercime.RegisterActivity;
import com.applicationregisteration.fx.byezbercime.managers.BackgroundSyncCooldownManager;
import com.applicationregisteration.fx.byezbercime.schedules.impl.TimeSchedules;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class ApplicationBackgroundTick extends TimeSchedules {

    private RegisterActivity registerActivity;
    private BackgroundSyncCooldownManager syncCooldownManager;

    public ApplicationBackgroundTick(RegisterActivity instance) {

        syncCooldownManager = new BackgroundSyncCooldownManager();
        this.registerActivity = instance;
        setInstance(instance);

    }

    @Override
    protected void backgroundSyncTickTimer() {

        try {

            if (!syncCooldownManager.getBackgroundSyncCooldowns().isEmpty()) {
                for (Map.Entry<String, Long> entry : syncCooldownManager.getBackgroundSyncCooldowns().entrySet()) {

                    long beforeDate = entry.getValue();
                    long nowDate = System.currentTimeMillis();

                    if (entry.getKey().equals("error_is_empty")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorRegisterEmptyMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_password_wrong")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorPasswordMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_email")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorMailMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_birthday")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorBirthdayMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_of_name")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorNameWrongMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_of_username")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorUsernameWrongMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_of_username_uppercase")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorUsernameUppercaseInvalidMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_phonenumber_invalid")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorPhonenumberInvalidMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_country_not_support")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorCountryIsNotSupportedMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("error_is_password_character_not_enough_wrong")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getErrorPasswordCharacterNotEnoughMessage().setVisibility(View.GONE);
                                    registerActivity.getErrorContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    } else if (entry.getKey().equals("success_registered_content")) {
                        if (registerActivity.getAuthenticationManager().isOverloadCooldownData(nowDate,beforeDate)) {

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    registerActivity.getSuccessRegisteredMessage().setVisibility(View.GONE);
                                    registerActivity.getSuccessContainer().setVisibility(View.GONE);

                                }
                            });

                            syncCooldownManager.getBackgroundSyncCooldowns().remove(entry.getKey());
                        }
                    }


                }
            }

        } catch (ConcurrentModificationException e) {
            return;
        }

    }

    public BackgroundSyncCooldownManager getSyncCooldownManager() {
        return syncCooldownManager;
    }

}

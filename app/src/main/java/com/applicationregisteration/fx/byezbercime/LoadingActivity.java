package com.applicationregisteration.fx.byezbercime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    private Thread loadingSchedules;

    private TextView loadingBarValue;
    private int progressBarValue = 1;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading_activity);


        this.loadingProgressBar = (ProgressBar) findViewById(R.id.laoding_progressbar);
        this.loadingBarValue = (TextView) findViewById(R.id.loadingbar_value_text);

        onLoadingSchedules();

        BackgroundApplicationStorage.backgroundAsynqSchedulesRunnableIndex = 1;

    }

    @Deprecated
    private void onLoadingSchedules() {
        loadingSchedules = new Thread(() -> {
            while (true) {

                if (BackgroundApplicationStorage.backgroundAsynqSchedulesRunnableIndex == 1) {

                    if (progressBarValue > -1)
                        loadingBarValue.setText(String.valueOf(progressBarValue));

                    if (progressBarValue == 100) {

                        Intent loadingIntent = new Intent(LoadingActivity.this,MainPageActivity.class);
                        startActivity(loadingIntent);
                        finish();

                        BackgroundApplicationStorage.backgroundAsynqSchedulesRunnableIndex = -1;
                        progressBarValue = -1;

                    } else if (progressBarValue >= 0){

                        loadingProgressBar.setMin(progressBarValue);

                        progressBarValue++;

                    }

                }

                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        loadingSchedules.setDaemon(false);
        loadingSchedules.start();
    }


}
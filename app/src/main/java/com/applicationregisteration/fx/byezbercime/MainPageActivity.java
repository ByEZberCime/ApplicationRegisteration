package com.applicationregisteration.fx.byezbercime;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.applicationregisteration.fx.byezbercime.managers.AuthenticationManager;
import com.applicationregisteration.fx.byezbercime.managers.DeviceManager;
import com.applicationregisteration.fx.byezbercime.schedules.ApplicationBackgroundTick;
import com.applicationregisteration.fx.byezbercime.util.CountryPhoneCode;
import com.google.android.gms.location.LocationServices;

public class MainPageActivity extends AppCompatActivity {

    @RequiresPermission("android.permission.READ_PRIVILEGED_PHONE_STATE")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);



    }


}
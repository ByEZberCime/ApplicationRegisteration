package com.applicationregisteration.fx.byezbercime;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.applicationregisteration.fx.byezbercime.managers.BackgroundSyncCooldownManager;
import com.applicationregisteration.fx.byezbercime.schedules.ApplicationBackgroundTick;

import java.util.Map;

public class MainPageActivity extends AppCompatActivity {

    private ApplicationBackgroundTick tickManager;

    private Button registerButton;

    private EditText emailText;
    private EditText realName;
    private EditText sourName;
    private EditText username;
    private EditText phoneNumber;
    private EditText birthday;
    private EditText password;
    private EditText confirmPassword;

    private CardView errorContainer;
    private CardView successContainer;

    private TextView successRegisteredMessage;

    private TextView errorMailMessage;
    private TextView errorPasswordMessage;
    private TextView errorRegisterEmptyMessage;
    private TextView errorBirthdayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);

        this.successContainer = (CardView) findViewById(R.id.register_success_container);
        this.errorContainer = (CardView) findViewById(R.id.register_error_container);

        this.successRegisteredMessage = (TextView) findViewById(R.id.success_register_text);

        this.errorMailMessage = (TextView) findViewById(R.id.error_of_email);
        this.errorPasswordMessage = (TextView) findViewById(R.id.error_of_passwords);
        this.errorBirthdayMessage = (TextView) findViewById(R.id.error_of_birthday_year);
        this.errorRegisterEmptyMessage = (TextView) findViewById(R.id.error_of_register_info_empty);

        this.registerButton = (Button) findViewById(R.id.register_button);
        this.emailText = (EditText) findViewById(R.id.email);
        this.realName = (EditText) findViewById(R.id.firstname);
        this.sourName = (EditText) findViewById(R.id.surname);
        this.username = (EditText) findViewById(R.id.username);
        this.phoneNumber = (EditText) findViewById(R.id.phonenumber);
        this.birthday = (EditText) findViewById(R.id.birthday);
        this.password = (EditText) findViewById(R.id.password);
        this.confirmPassword = (EditText) findViewById(R.id.confirm_password);
        this.tickManager = new ApplicationBackgroundTick(this);
        tickManager.runSyncSchedulers(1000L);

        onActionEvents();

    }

    public boolean isOverloadCooldownData(long nowDate, long beforeDate) {
        boolean result = false;
        if (nowDate > beforeDate) {
            result = true;
        }
        return result;
    }

    protected void onActionEvents() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!tickManager.getSyncCooldownManager().getBackgroundSyncCooldowns().isEmpty()) {
                    tickManager.getSyncCooldownManager().getBackgroundSyncCooldowns().clear();

                    getErrorBirthdayMessage().setVisibility(View.INVISIBLE);
                    getErrorMailMessage().setVisibility(View.INVISIBLE);
                    getErrorPasswordMessage().setVisibility(View.INVISIBLE);
                    getErrorRegisterEmptyMessage().setVisibility(View.INVISIBLE);
                    getSuccessRegisteredMessage().setVisibility(View.INVISIBLE);
                    getSuccessContainer().setVisibility(View.INVISIBLE);
                    getErrorContainer().setVisibility(View.INVISIBLE);

                }

                String emailTextString = emailText.getText().toString();
                String realNameString = realName.getText().toString();
                String sourNameString = sourName.getText().toString();
                String usernameString = username.getText().toString();
                String phoneNumberString = phoneNumber.getText().toString();
                String birthdayString = birthday.getText().toString();
                String passwordString = password.getText().toString();
                String confirmPasswordString = confirmPassword.getText().toString();

                if (isRegisterUserAboutsEmpty(emailTextString,realNameString,sourNameString,usernameString,phoneNumberString,birthdayString,passwordString,confirmPasswordString)) {

                    

                } else {

                    tickManager.getSyncCooldownManager().setErrorTypeInfoEmpty(errorContainer,errorRegisterEmptyMessage,true,5L);

                }

            }
        });

    }

    public boolean isRegisterUserAboutsEmpty(String emailTextString,String realNameString,String sourNameString,String usernameString,String phoneNumberString,String birthdayString,String passwordString,String confirmPasswordString) {
        return !emailTextString.isEmpty() && !realNameString.isEmpty() && !sourNameString.isEmpty() && !usernameString.isEmpty() && !phoneNumberString.isEmpty() && !birthdayString.isEmpty() && !passwordString.isEmpty() && !confirmPasswordString.isEmpty()?true:false;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public EditText getEmailText() {
        return emailText;
    }

    public EditText getRealName() {
        return realName;
    }

    public EditText getSourName() {
        return sourName;
    }

    public EditText getUsername() {
        return username;
    }

    public EditText getPhoneNumber() {
        return phoneNumber;
    }

    public EditText getBirthday() {
        return birthday;
    }

    public EditText getPassword() {
        return password;
    }

    public EditText getConfirmPassword() {
        return confirmPassword;
    }

    public CardView getErrorContainer() {
        return errorContainer;
    }

    public CardView getSuccessContainer() {
        return successContainer;
    }

    public TextView getSuccessRegisteredMessage() {
        return successRegisteredMessage;
    }

    public TextView getErrorMailMessage() {
        return errorMailMessage;
    }

    public TextView getErrorPasswordMessage() {
        return errorPasswordMessage;
    }

    public TextView getErrorRegisterEmptyMessage() {
        return errorRegisterEmptyMessage;
    }

    public TextView getErrorBirthdayMessage() {
        return errorBirthdayMessage;
    }
}
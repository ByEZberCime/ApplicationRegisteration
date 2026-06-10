package com.applicationregisteration.fx.byezbercime;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPageActivity extends AppCompatActivity {

    private Thread backgroundSync;
    private Button registerButton;

    private EditText emailText;
    private EditText realName;
    private EditText sourName;
    private EditText username;
    private EditText phoneNumber;
    private EditText birthday;
    private EditText password;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);
        this.registerButton = (Button) findViewById(R.id.register_button);
        this.emailText = (EditText) findViewById(R.id.email);
        this.realName = (EditText) findViewById(R.id.firstname);
        this.sourName = (EditText) findViewById(R.id.surname);
        this.username = (EditText) findViewById(R.id.username);
        this.phoneNumber = (EditText) findViewById(R.id.phonenumber);
        this.birthday = (EditText) findViewById(R.id.birthday);
        this.password = (EditText) findViewById(R.id.password);
        this.confirmPassword = (EditText) findViewById(R.id.confirm_password);

        onBackgroundScreen();
        onActionEvents();

    }

    protected void onBackgroundScreen() {
        this.backgroundSync = new Thread(()->{
           while (true) {



               try {
                   Thread.sleep(1000L);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
        });
    }

    protected void onActionEvents() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailTextString = emailText.getText().toString();
                String realNameString = realName.getText().toString();
                String sourNameString = sourName.getText().toString();
                String usernameString = username.getText().toString();
                String phoneNumberString = phoneNumber.getText().toString();
                String birthdayString = birthday.getText().toString();
                String passwordString = password.getText().toString();
                String confirmPasswordString = confirmPassword.getText().toString();

            }
        });

    }

    public boolean isRegisterUserAboutsEmpty() {

        String emailTextString = emailText.getText().toString();
        String realNameString = realName.getText().toString();
        String sourNameString = sourName.getText().toString();
        String usernameString = username.getText().toString();
        String phoneNumberString = phoneNumber.getText().toString();
        String birthdayString = birthday.getText().toString();
        String passwordString = password.getText().toString();
        String confirmPasswordString = confirmPassword.getText().toString();

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

}
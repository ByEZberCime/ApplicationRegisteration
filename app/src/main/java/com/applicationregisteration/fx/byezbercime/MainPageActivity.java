package com.applicationregisteration.fx.byezbercime;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.applicationregisteration.fx.byezbercime.managers.AuthenticationManager;
import com.applicationregisteration.fx.byezbercime.schedules.ApplicationBackgroundTick;
import com.applicationregisteration.fx.byezbercime.util.CountryPhoneCode;

public class MainPageActivity extends AppCompatActivity {

    private static final String DEBUG_EMAIL = "testmail@gmail.com";
    private static final String DEBUG_REALNAME = "Emir";
    private static final String DEBUG_SOURNAME = "Tasmaz";
    private static final String DEBUG_USERNAME = "byezbercime";
    private static final String DEBUG_PHONENUMBER = "+905313122909";
    private static final String DEBUG_BIRTHDAY = "04/01/2007";
    private static final String DEBUG_PASSWORD = " aD7sbc58CbBN5am4M1BK9.";
    private static final String DEBUG_CONFIRMPASSWORD = " aD7sbc58CbBN5am4M1BK9.";


    private ApplicationBackgroundTick tickManager;
    private AuthenticationManager authenticationManager;

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
    private TextView errorPasswordCharacterNotEnoughMessage;
    private TextView errorRegisterEmptyMessage;
    private TextView errorBirthdayMessage;
    private TextView errorNameWrongMessage;
    private TextView errorUsernameWrongMessage;
    private TextView errorUsernameUppercaseInvalidMessage;
    private TextView errorPhonenumberInvalidMessage;
    private TextView errorCountryIsNotSupportedMessage;
    private Animation errorCardAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);

        this.errorCardAnimation = AnimationUtils.loadAnimation(this,R.anim.error_cards_animation);

        this.successContainer = (CardView) findViewById(R.id.register_success_container);
        this.errorContainer = (CardView) findViewById(R.id.register_error_container);

        this.successRegisteredMessage = (TextView) findViewById(R.id.success_register_text);

        this.errorMailMessage = (TextView) findViewById(R.id.error_of_email);
        this.errorPasswordMessage = (TextView) findViewById(R.id.error_of_passwords);
        this.errorBirthdayMessage = (TextView) findViewById(R.id.error_of_birthday_year);
        this.errorRegisterEmptyMessage = (TextView) findViewById(R.id.error_of_register_info_empty);
        this.errorNameWrongMessage = (TextView) findViewById(R.id.error_of_name);
        this.errorUsernameWrongMessage = (TextView) findViewById(R.id.error_of_username);
        this.errorUsernameUppercaseInvalidMessage = (TextView) findViewById(R.id.error_of_username_uppercase);
        this.errorPhonenumberInvalidMessage = (TextView) findViewById(R.id.error_of_phone_invalid);
        this.errorCountryIsNotSupportedMessage = (TextView) findViewById(R.id.error_of_country_not_support);
        this.errorPasswordCharacterNotEnoughMessage = (TextView) findViewById(R.id.error_of_passwrod_character_not_enough);

        this.registerButton = (Button) findViewById(R.id.register_button);
        this.emailText = (EditText) findViewById(R.id.email);
        this.realName = (EditText) findViewById(R.id.firstname);
        this.sourName = (EditText) findViewById(R.id.surname);
        this.username = (EditText) findViewById(R.id.username);
        this.phoneNumber = (EditText) findViewById(R.id.phonenumber);
        this.birthday = (EditText) findViewById(R.id.birthday);
        this.password = (EditText) findViewById(R.id.password);
        this.confirmPassword = (EditText) findViewById(R.id.confirm_password);

        this.authenticationManager = new AuthenticationManager();
        this.tickManager = new ApplicationBackgroundTick(this);
        tickManager.runSyncSchedulers(1000L);

//        debugTest();

        onActionEvents();

    }

    private void debugTest() {
        emailText.setText(DEBUG_EMAIL);
        realName.setText(DEBUG_REALNAME);
        sourName.setText(DEBUG_SOURNAME);
        username.setText(DEBUG_USERNAME);
        phoneNumber.setText(DEBUG_PHONENUMBER);
        birthday.setText(DEBUG_BIRTHDAY);
        password.setText(DEBUG_PASSWORD);
        confirmPassword.setText(DEBUG_CONFIRMPASSWORD);
    }

    protected void onActionEvents() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!tickManager.getSyncCooldownManager().getBackgroundSyncCooldowns().isEmpty()) {
                    tickManager.getSyncCooldownManager().getBackgroundSyncCooldowns().clear();

                    getErrorBirthdayMessage().setVisibility(View.GONE);
                    getErrorNameWrongMessage().setVisibility(View.GONE);
                    getErrorUsernameWrongMessage().setVisibility(View.GONE);
                    getErrorMailMessage().setVisibility(View.GONE);
                    getErrorCountryIsNotSupportedMessage().setVisibility(View.GONE);
                    getErrorUsernameUppercaseInvalidMessage().setVisibility(View.GONE);
                    getErrorPhonenumberInvalidMessage().setVisibility(View.GONE);
                    getErrorPasswordMessage().setVisibility(View.GONE);
                    getErrorRegisterEmptyMessage().setVisibility(View.GONE);
                    getSuccessRegisteredMessage().setVisibility(View.GONE);

                    getSuccessContainer().setVisibility(View.GONE);
                    getErrorContainer().setVisibility(View.GONE);

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
                    if (authenticationManager.isEmailAuthentication(emailTextString)) {
                        if (authenticationManager.isTextLength(realNameString,30) && authenticationManager.isIllegalCharacter(realNameString) &&
                                authenticationManager.isIllegalCharacter(sourNameString) && authenticationManager.isTextLength(sourNameString,30)) {

                            if (authenticationManager.isIllegalCharacter(usernameString) && authenticationManager.isTextLength(usernameString,30)) {
                                if(!authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.UPPERCASE,1,usernameString)) {
                                    if (!phoneNumberString.isEmpty() && authenticationManager.isTextMinLength(phoneNumberString,12)) {

                                        int p = phoneNumberString.length() - 3;
                                        String numString = phoneNumberString.substring(0,phoneNumberString.length() - p);
                                        String countryPhoneCode = CountryPhoneCode.getByPhoneCode(numString).name();

                                        if (countryPhoneCode.equals(CountryPhoneCode.TURKEY.name())) {

                                            String phone = authenticationManager.getCountryPhoneNumberFormat(countryPhoneCode,phoneNumberString);
                                            if (!phone.isEmpty()) {
                                                if (authenticationManager.isBirthdayDateAuthentication(birthdayString) && authenticationManager.isOldLimit(birthdayString,18)) {

                                                    boolean passwordResult =
                                                            authenticationManager.isTextMinLength(passwordString,6) &&
                                                                    authenticationManager.isTextLength(passwordString,149) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.UPPERCASE,6,passwordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.NUMBERS,6,passwordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.LOWERCASE,6,passwordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.KEYCASE,1,passwordString);

                                                    boolean confirmPasswordResult =
                                                            authenticationManager.isTextMinLength(confirmPasswordString,6) &&
                                                                    authenticationManager.isTextLength(confirmPasswordString,149) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.UPPERCASE,6,confirmPasswordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.NUMBERS,6,confirmPasswordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.LOWERCASE,6,confirmPasswordString) &&
                                                                    authenticationManager.isCharacterAuthenticate(AuthenticationManager.AuthenticationPasswordInformation.KEYCASE,1,confirmPasswordString);

                                                    if (passwordResult ) {
                                                        if (confirmPasswordResult) {
                                                            if (authenticationManager.isAuthenticationPasswordConfirm(passwordString,confirmPasswordString) && passwordString.equals(confirmPasswordString)) {

                                                                tickManager.getSyncCooldownManager().setSuccessRegisteredMessage(successContainer,successRegisteredMessage,true,20L);
                                                                successContainer.startAnimation(errorCardAnimation);

                                                            } else {
                                                                tickManager.getSyncCooldownManager().setErrorTypePasswordWrong(errorContainer,errorPasswordMessage,true,5L);
                                                                errorContainer.setAnimation(errorCardAnimation);
                                                            }
                                                        } else {
                                                            tickManager.getSyncCooldownManager().setErrorTypePasswordCharacterWrong(errorContainer,errorPasswordCharacterNotEnoughMessage,true,5L);
                                                            errorContainer.setAnimation(errorCardAnimation);
                                                        }
                                                    } else {
                                                        tickManager.getSyncCooldownManager().setErrorTypePasswordCharacterWrong(errorContainer,errorPasswordCharacterNotEnoughMessage,true,5L);
                                                        errorContainer.setAnimation(errorCardAnimation);
                                                    }
                                                } else {
                                                    tickManager.getSyncCooldownManager().setErrorTypeBirthday(errorContainer,errorBirthdayMessage,true,5L);
                                                    errorContainer.setAnimation(errorCardAnimation);
                                                }
                                            } else {
                                                tickManager.getSyncCooldownManager().setErrorTypePhoneNumberInvalid(errorContainer,errorPhonenumberInvalidMessage,true,5L);
                                                errorContainer.setAnimation(errorCardAnimation);
                                            }
                                        } else {
                                            tickManager.getSyncCooldownManager().setErrorTypeCountryNotSupport(errorContainer,errorCountryIsNotSupportedMessage,true,5L);
                                            errorContainer.setAnimation(errorCardAnimation);
                                        }
                                    } else {
                                        tickManager.getSyncCooldownManager().setErrorTypePhoneNumberInvalid(errorContainer,errorPhonenumberInvalidMessage,true,5L);
                                        errorContainer.setAnimation(errorCardAnimation);
                                    }
                                } else {
                                    tickManager.getSyncCooldownManager().setErrorTypeUsernameUppercaseWrong(errorContainer,errorUsernameUppercaseInvalidMessage,true,5L);
                                    errorContainer.setAnimation(errorCardAnimation);
                                }
                            } else {
                                tickManager.getSyncCooldownManager().setErrorTypeUsernameWrong(errorContainer,errorUsernameWrongMessage,true,5L);
                                errorContainer.setAnimation(errorCardAnimation);
                            }

                        } else {
                            tickManager.getSyncCooldownManager().setErrorTypeNameWrong(errorContainer,errorNameWrongMessage,true,5L);
                            errorContainer.setAnimation(errorCardAnimation);
                        }
                    } else {
                        tickManager.getSyncCooldownManager().setErrorTypeEmailWrong(errorContainer,errorMailMessage,true,5L);
                        errorContainer.setAnimation(errorCardAnimation);
                    }
                } else {
                    tickManager.getSyncCooldownManager().setErrorTypeInfoEmpty(errorContainer,errorRegisterEmptyMessage,true,5L);
                    errorContainer.setAnimation(errorCardAnimation);
                }

            }
        });

    }

    public boolean isRegisterUserAboutsEmpty(String emailTextString,String realNameString,String sourNameString,String usernameString,String phoneNumberString,String birthdayString,String passwordString,String confirmPasswordString) {
        return !emailTextString.isEmpty() && !realNameString.isEmpty() && !sourNameString.isEmpty() && !usernameString.isEmpty() && !phoneNumberString.isEmpty() && !birthdayString.isEmpty() && !passwordString.isEmpty() && !confirmPasswordString.isEmpty()?true:false;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public TextView getErrorPhonenumberInvalidMessage() {
        return errorPhonenumberInvalidMessage;
    }

    public TextView getErrorPasswordCharacterNotEnoughMessage() {
        return errorPasswordCharacterNotEnoughMessage;
    }

    public TextView getErrorUsernameUppercaseInvalidMessage() {
        return errorUsernameUppercaseInvalidMessage;
    }

    public TextView getErrorNameWrongMessage() {
        return errorNameWrongMessage;
    }

    public TextView getErrorCountryIsNotSupportedMessage() {
        return errorCountryIsNotSupportedMessage;
    }

    public TextView getErrorUsernameWrongMessage() {
        return errorUsernameWrongMessage;
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
package com.applicationregisteration.fx.byezbercime.managers;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.HashMap;

public class BackgroundSyncCooldownManager {
    public void setErrorTypeUsernameWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_of_username",remainingSeconds);

        }
    }

    public void setNextIntant(Long value) {

        long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
        getBackgroundSyncCooldowns().put("register_and_next_intant",remainingSeconds);

    }

    public void setSuccessRegisteredMessage(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_success_registered_content",remainingSeconds);

        }
    }

    private HashMap<String,Long> backgroundSyncCooldowns;

    public BackgroundSyncCooldownManager() {
        this.backgroundSyncCooldowns = new HashMap<>();

    }

    public void setErrorTypePhoneNumberInvalid(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_phonenumber_invalid",remainingSeconds);

        }
    }

    public void setErrorTypeCountryNotSupport(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_country_not_support",remainingSeconds);

        }
    }

    public void setErrorTypeInfoEmpty(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_empty",remainingSeconds);

        }
    }

    public void setErrorTypeUsernameUppercaseWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_of_username_uppercase",remainingSeconds);

        }
    }

    public void setErrorTypePasswordWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_password_wrong",remainingSeconds);

        }
    }

    public void setErrorTypePasswordCharacterWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_password_character_not_enough_wrong",remainingSeconds);

        }
    }

    public void setErrorTypeEmailWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_email",remainingSeconds);

        }
    }

    public void setErrorTypeNameWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());
            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_of_name",remainingSeconds);

        }
    }

    public void setErrorTypeBirthday(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());

            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("register_error_is_birthday",remainingSeconds);

        }
    }

    public HashMap<String, Long> getBackgroundSyncCooldowns() {
        return backgroundSyncCooldowns;
    }

}

package com.applicationregisteration.fx.byezbercime.managers;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.HashMap;

public class BackgroundSyncCooldownManager {

    private HashMap<String,Long> backgroundSyncCooldowns;

    public BackgroundSyncCooldownManager() {
        this.backgroundSyncCooldowns = new HashMap<>();

    }

    public void setErrorTypeInfoEmpty(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());

            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("error_is_empty",remainingSeconds);

        } else {



        }
    }

    public void setErrorTypePasswordWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());

            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("error_is_password_wrong",remainingSeconds);

        } else {



        }
    }

    public void setErrorTypeEmailWrong(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());

            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("error_is_email",remainingSeconds);

        } else {



        }
    }

    public void setErrorTypeBirthday(CardView errorContainer, TextView errorMessage, boolean result, Long value) {
        if (result && errorContainer != null && errorMessage != null) {

            long remainingSeconds = ((value * 1000) + System.currentTimeMillis());

            errorMessage.setVisibility(CardView.VISIBLE);
            errorContainer.setVisibility(View.VISIBLE);

            getBackgroundSyncCooldowns().put("error_is_birthday",remainingSeconds);

        } else {



        }
    }

    public HashMap<String, Long> getBackgroundSyncCooldowns() {
        return backgroundSyncCooldowns;
    }

}

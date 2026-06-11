package com.applicationregisteration.fx.byezbercime;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationManager {

    public boolean isTextLength(String text,int length) {
        boolean result = false;
        if (!text.isEmpty() && text.length() < length) {
            result = true;
        }
        return result;
    }

    public boolean isBirthdayDateAuthentication(String birthdayDateText) {
        boolean result = false;
        if (!birthdayDateText.isEmpty()) {

            String[] birthdayDateTextSplits = birthdayDateText.split("/");

            String day = birthdayDateTextSplits[0];
            String month = birthdayDateTextSplits[1];
            String year = birthdayDateTextSplits[2];

            if (!day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
                result = true;
            }
        }
        return result;
    }

    public boolean isOldLimit(String birthdayDateText,int oldLimit) {
        boolean result = false;

        if (!String.valueOf(oldLimit).isEmpty() && isBirthdayDateAuthentication(birthdayDateText)) {

            Date dt = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String nowYear = simpleDateFormat.format(dt);
            String[] birthdayDateTextSplits = birthdayDateText.split("/");
            int year = Integer.parseInt(birthdayDateTextSplits[2]);

            int oldYear = Integer.parseInt(nowYear) - year;

            if (oldLimit <= oldYear) {
                result = true;
            }

        }
        return result;
    }

    public boolean isCharacterAuthenticate(String type,int typeLength,String value) {
        boolean result = false;

        int characters = 0;



        if (characters == typeLength) {
            result = true;
        }

        return result;
    }

    public boolean isEmailAuthentication(String email) {
        boolean result = false;

        if (!email.isEmpty()) {
            String[] emailAdressSplits = email.split("@");
            String emailName = emailAdressSplits[0];
            String mailsLinks = emailAdressSplits[1];

            if (isIllegalCharacter(emailName) && mailsLinks.equals("gmail.com")) {
                result = true;
            }
        }
        return result;
    }

    public boolean isIllegalCharacter(String infoValue) {
        boolean result = false;

        StringBuilder textInfo = new StringBuilder();
        String legalCharacters = "zxcvbnmilkjhgfdsaqwertyuop0_987654321ZXCVBNMLKJHGFDSAQWERTYUIOP";
        String[] legalCharactersSplits = legalCharacters.split("");
        List<String> illegals = Arrays.stream(legalCharactersSplits).collect(Collectors.toList());

        String[] textSplits = infoValue.split("");

        for (int s = 0; s < textSplits.length; s++) {
            String value =  textSplits[s];
            if (isCharacter(illegals,value)) {
                textInfo.append(value);
            } else {
                break;
            }
        }

        String infoStr =  textInfo.toString();

        if (infoStr.equals(infoValue)) {
            result = true;
        }
        return result;
    }

    private boolean isCharacter(List<String> s,String value) {
        boolean result = false;

        if (!s.isEmpty() && !value.isEmpty()) {
            for (String v : s) {
                if (v.equals(value)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean isOverloadCooldownData(long nowDate, long beforeDate) {
        boolean result = false;
        if (nowDate > beforeDate) {
            result = true;
        }
        return result;
    }

}

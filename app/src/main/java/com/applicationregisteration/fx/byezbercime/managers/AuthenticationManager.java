package com.applicationregisteration.fx.byezbercime.managers;

import com.applicationregisteration.fx.byezbercime.util.CountryPhoneCode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationManager {

    public enum AuthenticationPasswordInformation {

        UPPERCASE(List.of("Z","X","C","V","B","N","M","L","K","J","H","G","F","D","S","A","Q","W","E","R","T","Y","U","I","O","P")),
        LOWERCASE(List.of("z","x","c","v","b","n","m","l","k","h","g","f","d","s","a","q","w","e","r","t","y","u","i","o","p")),
        KEYCASE(List.of("*","_",".","=","+","-",",")),
        NUMBERS(List.of("0","1","2","3","4","5","6","7","8","9"));

        List<String> data;

        AuthenticationPasswordInformation(List<String> data) {
            this.data = data;
        }

        public List<String> getInfo() {
            return data;
        }

    }

    public boolean isTextLength(String text,int length) {
        boolean result = false;
        if (!text.isEmpty() && text.length() < length) {
            result = true;
        }
        return result;
    }

    public boolean isTextMinLength(String text,int length) {
        boolean result = false;
        if (!text.isEmpty() && text.length() > length) {
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

    boolean isTypeTextAuthentication(List<String> d,String value) {
        boolean result = false;

        if (!d.isEmpty() && !value.isEmpty()) {

            for (String s : d) {
                if (value.equals(s)) {
                    result = true;
                }
            }

        }

        return result;
    }

    public String getCountryPhoneNumberFormat(String lang,String number) {
        int p = number.length() - 3;
        String phoneNumber = "Invalid phone number";
        String numString = number.substring(0,number.length() - p);

        if (CountryPhoneCode.getByPhoneCode(numString) != null) {
            String language = CountryPhoneCode.getByPhoneCode(numString).name();

            if (language.equals(lang)) {

                String a = number.substring(3,number.length() - 7);
                String b = number.substring(6,number.length() - 4);
                String c = number.substring(9,number.length() - 2);
                String d = number.substring(11);
                phoneNumber = "0"+a+ " "+b+" "+c+ " "+d;

            }
        }

        return phoneNumber;
    }

    public boolean isAuthenticationPasswordConfirm(String password,String confirmPassword) {

        boolean result = false;
        String[] passwordSplits = password.split("");
        String[] confirmPasswordsSplits = confirmPassword.split("");
        List<String> passwords = Arrays.stream(passwordSplits).collect(Collectors.toList());

        int passwordLength = password.length();
        int confirmPasswordLength = confirmPassword.length();
        int length = 0;

        if (!password.isEmpty() && !passwords.isEmpty() && !confirmPassword.isEmpty()) {
            for (int i = 0; i < confirmPasswordsSplits.length; i++) {
                String confirmPasswordValue = confirmPasswordsSplits[0];
                if (isTypeTextAuthentication(passwords,confirmPasswordValue)) {
                    length++;
                }
            }
        }

        if (passwordLength == length && confirmPasswordLength == length) {
            result = true;
        }

        return result;
    }

    public boolean isCharacterAuthenticate(AuthenticationPasswordInformation information,int typeLength,String value) {
        boolean result = false;

        int characters = 0;
        String[] values = value.split("");

        for (int i = 0; i < values.length; i++) {
            String v = values[i];
            if (isTypeTextAuthentication(information.getInfo(),v)) {
                characters++;
            }
        }

        if (characters >= typeLength) {
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

            if (isIllegalCharacter(emailName) && isTextLength(emailName,244) && mailsLinks.equals("gmail.com")) {
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

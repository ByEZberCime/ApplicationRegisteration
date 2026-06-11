package com.applicationregisteration.fx.byezbercime.util;

import java.util.Date;

@Deprecated
public class GuessAuthentication {

    private String country;
    private String email;
    private String realName;
    private String sourtName;

    private String profileName;
    private String username;
    private String birthday;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private boolean isRegister;
    private Date registeredDate;
    private Date loginDate;

    public GuessAuthentication(String country,String email, String realName, String sourtName, String username, String birthday, String phoneNumber, String password, String confirmPassword, boolean isRegister, Date registeredDate) {
        this.country = country;
        this.email = email;
        this.realName = realName;
        this.sourtName = sourtName;
        this.username = username;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isRegister = isRegister;
        this.registeredDate = registeredDate;
    }

    public GuessAuthentication(String country,String email, String password, String phoneNumber, Date loginDate, boolean isRegister) {
        this.country = country;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.loginDate = loginDate;
        this.isRegister = isRegister;
    }

    public String getCountry() {
        return country;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getEmail() {
        return email;
    }

    public String getRealName() {
        return realName;
    }

    public String getSourtName() {
        return sourtName;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isRegister() {
        return isRegister;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }
}

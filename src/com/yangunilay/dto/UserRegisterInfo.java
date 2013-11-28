package com.yangunilay.dto;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/1/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRegisterInfo {
    private String username;
    private String loginPassword;
    private String loginPasswordConfirm;
    private int mobile;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginPasswordConfirm() {
        return loginPasswordConfirm;
    }

    public void setLoginPasswordConfirm(String loginPasswordConfirm) {
        this.loginPasswordConfirm = loginPasswordConfirm;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

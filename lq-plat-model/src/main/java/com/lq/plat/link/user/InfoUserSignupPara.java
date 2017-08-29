package com.lq.plat.link.user;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class InfoUserSignupPara {

    private String username;

    private String password;

    public InfoUserSignupPara() {
    }

    public InfoUserSignupPara(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.wya.env.bean.login;

/**
 * @date: 2018/5/31 13:50
 * @author: Chunjiang Mao
 * @classname: LoginInfo
 * @describe: LoginInfo
 */

public class LoginInfo {
    private String token;
    private String msg;
    private String username;
    private String realname;
    private String organization;
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getRealname() {
        return realname;
    }
    
    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
}

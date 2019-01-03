package com.wya.env.data.local.sp;

public class LoginSP extends BaseSP {
    
    private static final String KEY_LOGIN = "SP_LOGIN";
    
    private static LoginSP INSTANCE;
    
    private LoginSP() {
        super(KEY_LOGIN);
    }
    
    public static LoginSP get() {
        if (null == INSTANCE) {
            INSTANCE = new LoginSP();
        }
        return INSTANCE;
    }
    
    /**
     * 是否登录成功
     */
    private static final String KEY_LOGIN_IS_LOGIN = "LOGIN_IS_LOGIN";
    
    public boolean isLogin() {
        return getBoolean(KEY_LOGIN_IS_LOGIN, false);
    }
    
    public void setLogin(boolean isLogin) {
        putBoolean(KEY_LOGIN_IS_LOGIN, isLogin);
    }
    
}

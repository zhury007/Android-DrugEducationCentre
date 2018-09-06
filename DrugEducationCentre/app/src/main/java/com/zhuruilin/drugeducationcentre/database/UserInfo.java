package com.zhuruilin.drugeducationcentre.database;

public class UserInfo {
    private static final UserInfo instance = new UserInfo();

    private UserInfo() {
        name = "";
        isLogin = false;
    }

    public static UserInfo getInstance() {
        return instance;
    }

    private String name = "";
    private String email = "";
    private Boolean isLogin = false;

    public Boolean IsLogin() {
        return isLogin;
    }


}

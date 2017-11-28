package com.syh.diablo.appframe.net;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public enum ServerType {
    HOME("Home"),
    ACCOUNT("Account");

    private String value;


    private ServerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}

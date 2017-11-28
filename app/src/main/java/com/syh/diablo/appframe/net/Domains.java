package com.syh.diablo.appframe.net;

import com.syh.diablo.appframe.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public class Domains {

    private final static Map<ServerType, String> PRODUCT = new HashMap<ServerType, String>() {
        {
            put(ServerType.HOME, "http://node-future-app-service.ingress.98.cn/");
        }
    };

    private final static Map<ServerType, String> TEST = new HashMap<ServerType, String>() {
        {
            put(ServerType.HOME, "http://node-future-app-service.ingress.98.cn/");
        }
    };

    public static Map<ServerType, String> getDomain() {
        if (BuildConfig.ENV.equals("test")) {
            return PRODUCT;
        } else {
            return TEST;
        }
    }
}

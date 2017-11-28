package com.syh.diablo.appframe.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public class ApiFactory {
    private volatile static ApiFactory instance;

    public static ApiFactory getInstance() {
        if (instance == null) {
            synchronized (ApiFactory.class) {
                if (instance == null) {
                    instance = new ApiFactory();
                }
            }
        }
        return instance;
    }

    private Map<String, Object> apis;

    private ApiFactory() {
        apis = new HashMap<>();
    }

    public <T> T create(ServerType serverType, Class<T> tClass) {
        T api = (T) apis.get(serverType.getValue() + tClass.getName());
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Domains.getDomain().get(serverType))
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            api = retrofit.create(tClass);
            apis.put(serverType.getValue() + tClass.getName(), api);
        }
        return api;
    }

}

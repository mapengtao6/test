package com.bw.month.utils;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Time:2019.03.07--14:18
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OkHttpShopUtils {

    private static OkHttpShopUtils okHttpShopUtils = null;

    private OkHttpShopUtils(){

    }

    public static OkHttpShopUtils getInstance(){

//        同步锁
        if (okHttpShopUtils == null){
            synchronized (OkHttpShopUtils.class){
                if (okHttpShopUtils == null){
                    okHttpShopUtils = new OkHttpShopUtils();
                }
            }
        }

        return okHttpShopUtils;
    }

    public Interceptor getInterceptor(){

//        拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("mm",message);
            }
        });

        return interceptor;
    }

//    gget
    public void doGet(String url, Callback callback){

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .build();

        Request request = new Request
                .Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}

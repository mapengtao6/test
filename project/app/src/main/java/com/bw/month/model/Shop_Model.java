package com.bw.month.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.month.utils.OkHttpShopUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019.03.07--14:16
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Shop_Model {

    String url = "http://172.17.8.100/ks/product/getCarts?uid=51";

    public interface OnShopLisenter{
        void onResult(String json);
    }

    public OnShopLisenter shopLisenter;

    public void setShopLisenter(OnShopLisenter onShopLisenter) {
        this.shopLisenter = onShopLisenter;
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:

                    String json = (String) msg.obj;
                    if (shopLisenter != null){
                        shopLisenter.onResult(json);
                    }

                    break;
            }
        }
    };

    public void shop() {

        OkHttpShopUtils.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}

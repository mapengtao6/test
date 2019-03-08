package com.bw.month.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.month.utils.OkHttpUtils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019.03.07--10:49
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:M层
 */
public class Fen_Model {

    String url = "http://172.17.8.100/ks/product/getCatagory";


    //    接口
    public interface onFenClickLisenter {

        void onResult(String json);
    }

    public onFenClickLisenter fenClickLisenter;

    public void setFenClickLisenter(onFenClickLisenter onFenClickLisenter) {
        this.fenClickLisenter = onFenClickLisenter;
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;

                    if (fenClickLisenter != null) {
                        fenClickLisenter.onResult(json);
                    }

                    break;
            }
        }
    };

    public void show() {

        OkHttpUtils.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

//                Log.i("json", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }

    public void showtwo(int cid) {

        String urltwo = "http://172.17.8.100/ks/product/getProductCatagory?cid=";

        OkHttpUtils.getInstance().doGet(urltwo + cid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json1 = response.body().string();

//                Log.i("json1",json1);
                Message message = new Message();
                message.what = 0;
                message.obj = json1;
                handler.sendMessage(message);
            }
        });
    }
}

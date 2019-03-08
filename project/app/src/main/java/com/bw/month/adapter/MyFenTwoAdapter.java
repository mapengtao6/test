package com.bw.month.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.month.R;
import com.bw.month.fenselectbean.JsonBean;
import com.bw.month.fentwobean.Data;
import com.bw.month.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019.03.07--11:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyFenTwoAdapter extends RecyclerView.Adapter<MyFenTwoAdapter.MyViewHolder> {

    private String url = "http://172.17.8.100/ks/product/getProducts?pscid=";
    private Handler handler = new Handler();

    Context context;
    ArrayList<Data> data;

    public MyFenTwoAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.fentwo_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        Data data = this.data.get(i);
        myViewHolder.fentwo_title.setText(data.getName());

        myViewHolder.rlv3.setLayoutManager(new GridLayoutManager(context, 3));

        String pcid = data.getPcid();

        OkHttpUtils.getInstance().doGet(url + pcid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String json = response.body().string();

                            Gson gson = new Gson();
                            JsonBean fromJson = gson.fromJson(json, JsonBean.class);

                            ArrayList<com.bw.month.fenselectbean.Data> data1 = fromJson.getData();

//                            Toast.makeText(context, ""+data1.toString(), Toast.LENGTH_SHORT).show();
                            if (data1.size() != 0) {

                                MySelectAdapter mySelectAdapter = new MySelectAdapter(context, data1);
                                myViewHolder.rlv3.setAdapter(mySelectAdapter);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView fentwo_title;
        private final RecyclerView rlv3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fentwo_title = itemView.findViewById(R.id.fentwo_title);
            rlv3 = itemView.findViewById(R.id.fentwo_rlv3);
        }
    }
}

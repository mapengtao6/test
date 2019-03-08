package com.bw.month.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.month.R;
import com.bw.month.fenselectbean.Data;

import java.util.ArrayList;

/**
 * Time:2019.03.07--12:06
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MySelectAdapter extends RecyclerView.Adapter<MySelectAdapter.MyViewHolder> {

    Context context ;
    ArrayList<Data> data;

    public MySelectAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.select_layout,null,false);

        MyViewHolder myViewHolder  = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Data data = this.data.get(i);
//        Glide.with(context).load(data.getImages()).into(myViewHolder.select_image);
//        Glide.with(context).load(data.getImages().split("\\|")[0].replace("https","http")).into(myViewHolder.select_image);

        myViewHolder.select_title.setText(data.getTitle());


//        data.get(i).getImages().split("\\|")[0].replace("https", "http");

        String[] imgs = data.getImages().split("\\|");

            Glide.with(context).load(imgs[0]).into(myViewHolder.select_image);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView select_image;
        private final TextView select_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            select_image = itemView.findViewById(R.id.select_image);
            select_title = itemView.findViewById(R.id.select_title);
        }
    }
}

package com.bw.month.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.month.R;
import com.bw.month.shopbean.List;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

/**
 * Time:2019.03.07--15:10
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyShopTwoAdapter extends RecyclerView.Adapter<MyShopTwoAdapter.MyViewHolder> {

    Context context;
    ArrayList<List> list;

    public MyShopTwoAdapter(Context context, ArrayList<List> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.shoptwo_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final List list = this.list.get(i);
//        图片
        String[] imgs = list.getImages().split("\\|");
        if (imgs != null && imgs.length > 0) {
            Glide.with(context).load(imgs[0]).into(myViewHolder.shoptwo_image);
        }

        myViewHolder.shoptwo_title.setText(list.getTitle());
        myViewHolder.shoptwo_price.setText("¥:" + list.getPrice());


//        选择
        myViewHolder.checkBox.setChecked(list.isChildCheck());
        myViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.setChildCheck(isChecked);
                if (childCheckListener != null) {
                    childCheckListener.oncheck();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    全选
    public void setCheck(boolean checked) {

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChildCheck(checked);
            notifyDataSetChanged();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;
        private final ImageView shoptwo_image;
        private final TextView shoptwo_title;
        private final TextView shoptwo_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.shoptwo_checkbox);
            shoptwo_image = itemView.findViewById(R.id.shoptwo_image);
            shoptwo_title = itemView.findViewById(R.id.shoptwo_title);
            shoptwo_price = itemView.findViewById(R.id.shoptwo_price);
        }
    }


    //    点击事件
    public interface OnChildCheckListener {
        void oncheck();
    }

    public OnChildCheckListener childCheckListener;

    public void setChildCheckListener(OnChildCheckListener childCheckListener) {
        this.childCheckListener = childCheckListener;
    }
}

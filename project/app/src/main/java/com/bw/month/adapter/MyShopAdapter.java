package com.bw.month.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.month.R;
import com.bw.month.shopbean.Data;
import com.bw.month.shopbean.List;

import java.util.ArrayList;

/**
 * Time:2019.03.07--15:01
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyShopAdapter extends RecyclerView.Adapter<MyShopAdapter.MyViewHolder> {

    Context context;
    ArrayList<Data> data;

    public MyShopAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.shop_layout,null,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final Data data = this.data.get(i);
        myViewHolder.shop_title.setText(data.getSellerName());

        myViewHolder.rlv2.setLayoutManager(new LinearLayoutManager(context));

        final ArrayList<List> list = data.getList();

        final MyShopTwoAdapter myShopTwoAdapter = new MyShopTwoAdapter(context,list);
        myViewHolder.rlv2.setAdapter(myShopTwoAdapter);

        //////////////////////////子控父
        myShopTwoAdapter.setChildCheckListener(new MyShopTwoAdapter.OnChildCheckListener() {
            @Override
            public void oncheck() {
                if (parentCheckListener != null){

                    parentCheckListener.onCheck(data);//----------------

                }
                boolean value = true;
                for (int j = 0;j<list.size();j++){
                    boolean childCheck = list.get(j).isChildCheck();
                    if (!childCheck){
                        value = false;
                        break;
                    }
                }

                data.setParentCheck(value);
                myViewHolder.parent_checkBox.setChecked(value);
            }
        });

        ///////////////////父控子
        myViewHolder.parent_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setParentCheck(myViewHolder.parent_checkBox.isChecked());
                myShopTwoAdapter.setCheck(myViewHolder.parent_checkBox.isChecked());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView shop_title;
        private final RecyclerView rlv2;
        private final CheckBox parent_checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shop_title = itemView.findViewById(R.id.shop_title);
            rlv2 = itemView.findViewById(R.id.shop_rlv2);
            parent_checkBox = itemView.findViewById(R.id.parent_checkBox);
        }
    }

//    接口
    public interface OnParentCheckListener{
        void onCheck(Data data);
    }

    private OnParentCheckListener parentCheckListener;

    public void setParentCheckListener(OnParentCheckListener parentCheckListener) {
        this.parentCheckListener = parentCheckListener;
    }
}

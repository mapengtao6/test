package com.bw.month.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.month.R;
import com.bw.month.bean.FenJsonBean;

import java.util.ArrayList;

/**
 * Time:2019.03.07--11:10
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MyFenAdapter extends RecyclerView.Adapter<MyFenAdapter.MyViewHolder> {

    Context context;
    ArrayList<FenJsonBean.DataBean> data;

    public MyFenAdapter(Context context, ArrayList<FenJsonBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.fen_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final FenJsonBean.DataBean dataBean = data.get(i);
        myViewHolder.fen_title.setText(dataBean.getName());

//        条目点击事件
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cid = dataBean.getCid();
                if (clickLisenter != null){
                        clickLisenter.onItemClick(cid);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView fen_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fen_title = itemView.findViewById(R.id.fen_title);
        }
    }

    //    点击事件
    public interface onItemClickLisenter {

        void onItemClick(int id);
    }

    public onItemClickLisenter clickLisenter;

    public void setClickLisenter(onItemClickLisenter onItemClickLisenter) {
        this.clickLisenter = onItemClickLisenter;
    }
}

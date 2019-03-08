package com.bw.month.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.month.R;
import com.bw.month.adapter.MyFenAdapter;
import com.bw.month.adapter.MyFenTwoAdapter;
import com.bw.month.bean.FenJsonBean;
import com.bw.month.fentwobean.Data;
import com.bw.month.fentwobean.FenTwoJsonBean;
import com.bw.month.presenter.Fen_Presenter;
import com.bw.month.view.Fen_View;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:2019.03.07--10:43
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Fen_Fragment extends Fragment implements Fen_View {

    private View view;
    private RecyclerView rlv;
    private Fen_Presenter presenter;
    private RecyclerView rlv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fen_fragment, null, false);

//        找控件
        initID();


        return view;
    }

    private void initID() {

        rlv = view.findViewById(R.id.fen_rlv);
        rlv2 = view.findViewById(R.id.fen_rlv2);
//        管理器1
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(linearLayoutManager);

        //        管理器2
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        rlv2.setLayoutManager(linearLayoutManager2);

        presenter = new Fen_Presenter(this);

        presenter.attachView(getActivity());

        presenter.show();

    }

    @Override
    public void getViewData(String json) {

        Gson gson = new Gson();
        FenJsonBean fromJson = gson.fromJson(json, FenJsonBean.class);

        final List<FenJsonBean.DataBean> data = fromJson.getData();

//        Toast.makeText(getActivity(), ""+data.toString(), Toast.LENGTH_SHORT).show();

        MyFenAdapter myFenAdapter = new MyFenAdapter(getActivity(), (ArrayList<FenJsonBean.DataBean>) data);

        rlv.setAdapter(myFenAdapter);

        myFenAdapter.setClickLisenter(new MyFenAdapter.onItemClickLisenter() {
            @Override
            public void onItemClick(int cid) {

                presenter.showtwo(cid);
            }
        });
    }

    @Override
    public void getViewTwoData(String json) {

        Gson gson = new Gson();
        FenTwoJsonBean fromJson = gson.fromJson(json, FenTwoJsonBean.class);
        ArrayList<Data> datas = fromJson.getData();

//        Toast.makeText(getActivity(), ""+datas.toString(), Toast.LENGTH_SHORT).show();

        MyFenTwoAdapter myFenTwoAdapter = new MyFenTwoAdapter(getActivity(),datas);
        rlv2.setAdapter(myFenTwoAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }
}

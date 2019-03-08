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
import android.widget.CheckBox;
import android.widget.Toast;

import com.bw.month.R;
import com.bw.month.adapter.MyShopAdapter;
import com.bw.month.presenter.Shop_Presenter;
import com.bw.month.shopbean.Data;
import com.bw.month.shopbean.JsonBean;
import com.bw.month.shopbean.List;
import com.bw.month.view.Shop_View;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Time:2019.03.07--10:43
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Shop_Fragment extends Fragment implements Shop_View {

    private View view;
    private RecyclerView rlv;
    private Shop_Presenter presenter;
    private CheckBox show_checkbox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.shop_fragment, null, false);

        initID();

        return view;
    }

    private void initID() {

        rlv = view.findViewById(R.id.shop_rlv);
        show_checkbox = view.findViewById(R.id.show_checkbox);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rlv.setLayoutManager(linearLayoutManager);

        presenter = new Shop_Presenter(this);

        presenter.shop();
    }

    @Override
    public void getViewData(String json) {

        Gson gson = new Gson();
        JsonBean fromJson = gson.fromJson(json, JsonBean.class);

        final ArrayList<Data> data = fromJson.getData();
//        Toast.makeText(getActivity(), ""+data.toString(), Toast.LENGTH_SHORT).show();

        final MyShopAdapter myShopAdapter = new MyShopAdapter(getActivity(), data);
        rlv.setAdapter(myShopAdapter);

        show_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show_checkbox.isChecked()) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setParentCheck(true);
                        ArrayList<List> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setChildCheck(true);
                        }
                    }
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setParentCheck(false);
                        ArrayList<List> list = data.get(i).getList();
                        for (int j = 0; j < list.size(); j++) {
                            list.get(j).setChildCheck(false);
                        }
                    }
                }

                myShopAdapter.notifyDataSetChanged();
            }
        });

        myShopAdapter.setParentCheckListener(new MyShopAdapter.OnParentCheckListener() {
            @Override
            public void onCheck(Data data) {
                int value = 0;
                for (int i = 0; i < data.getList().size(); i++) {
                    for (int j = 0; j < data.getList().size(); j++) {
                        value++;
                    }
                }
                if (data.getList().size() == value) {
                    show_checkbox.setChecked(true);
                } else {
                    show_checkbox.setChecked(false);
                }
            }
        });
    }
}

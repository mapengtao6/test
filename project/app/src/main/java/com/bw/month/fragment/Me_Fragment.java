package com.bw.month.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.month.R;

/**
 * Time:2019.03.07--10:43
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Me_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.me_fragment,null,false);

        return view;
    }
}

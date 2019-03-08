package com.bw.month.presenter;

import com.bw.month.fragment.Fen_Fragment;
import com.bw.month.model.Fen_Model;
import com.bw.month.view.Fen_View;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019.03.07--10:49
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:p层
 */
public class Fen_Presenter<T> {


    private Reference<T> tReference;
    private final Fen_Model fen_model;
    private final Fen_View fen_view;


    //    使用软引用控制外部类对象
    public void attachView(T t){
        tReference = new WeakReference<T>(t);
    }


    //    销毁内存方法
    public void deatchView(){
        if (tReference!= null){
            tReference.clear();
            tReference = null;
        }
    }

    //    实例化
    public Fen_Presenter(Fen_View view) {
        fen_model = new Fen_Model();

        fen_view = view;
    }

    public void show() {

        fen_model.show();
        fen_model.setFenClickLisenter(new Fen_Model.onFenClickLisenter() {
            @Override
            public void onResult(String json) {
                fen_view.getViewData(json);
            }
        });
    }

    public void showtwo(int cid) {
        fen_model.showtwo(cid);
        fen_model.setFenClickLisenter(new Fen_Model.onFenClickLisenter() {
            @Override
            public void onResult(String json) {
                fen_view.getViewTwoData(json);
            }
        });
    }
}

package com.bw.month.presenter;

import android.support.v4.app.FragmentActivity;

import com.bw.month.model.Shop_Model;
import com.bw.month.view.Shop_View;

/**
 * Time:2019.03.07--14:16
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Shop_Presenter {


    private final Shop_Model shop_model;
    private final Shop_View shop_view;

    //    实例化
    public Shop_Presenter(Shop_View view) {
        shop_model = new Shop_Model();
        shop_view = view;
    }

    public void shop() {

        shop_model.shop();
        shop_model.setShopLisenter(new Shop_Model.OnShopLisenter() {
            @Override
            public void onResult(String json) {
                shop_view.getViewData(json);
            }
        });
    }
}

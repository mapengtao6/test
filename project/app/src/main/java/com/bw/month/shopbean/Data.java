package com.bw.month.shopbean;

import java.util.ArrayList;

/**
 * Time:2019.03.07--14:42
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Data {

    private ArrayList<List> list;
    private String sellerName;
    private boolean parentCheck = false;

    public boolean isParentCheck() {
        return parentCheck;
    }

    public void setParentCheck(boolean parentCheck) {
        this.parentCheck = parentCheck;
    }

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Data() {
    }

    public Data(ArrayList<List> list, String sellerName) {
        this.list = list;
        this.sellerName = sellerName;
    }
}

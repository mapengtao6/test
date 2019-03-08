package com.bw.month.fentwobean;

import java.util.ArrayList;

/**
 * Time:2019.03.07--11:37
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class FenTwoJsonBean {
    private String code;
    private ArrayList<Data> data;
    private String msg;

    @Override
    public String toString() {
        return "FenTwoJsonBean{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FenTwoJsonBean() {
    }

    public FenTwoJsonBean(String code, ArrayList<Data> data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}

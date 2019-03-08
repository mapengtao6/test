package com.bw.month.fenselectbean;

import java.util.ArrayList;

/**
 * Time:2019.03.07--11:59
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class JsonBean {
    private String code;
    private ArrayList<Data> data;
    private String msg;
    private String page;

    @Override
    public String toString() {
        return "JsonBean{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", page='" + page + '\'' +
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public JsonBean() {
    }

    public JsonBean(String code, ArrayList<Data> data, String msg, String page) {

        this.code = code;
        this.data = data;
        this.msg = msg;
        this.page = page;
    }
}

package com.bw.month.fentwobean;

/**
 * Time:2019.03.07--11:35
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Data {
       /*      "cid": "2",
             "name": "服饰奢品",
             "pcid": "8"*/

    private String cid;
    private String name;
    private String pcid;

    @Override
    public String toString() {
        return "Data{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", pcid='" + pcid + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPcid() {
        return pcid;
    }

    public void setPcid(String pcid) {
        this.pcid = pcid;
    }

    public Data() {
    }

    public Data(String cid, String name, String pcid) {
        this.cid = cid;
        this.name = name;
        this.pcid = pcid;
    }
}

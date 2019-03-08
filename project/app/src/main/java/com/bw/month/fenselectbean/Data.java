package com.bw.month.fenselectbean;

/**
 * Time:2019.03.07--11:58
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Data {

          /*  "bargainPrice": 2999.0,
             "createtime": "2017-10-14T21:48:08",
             "detailUrl": "https://item.m.jd.com/product/2385655.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends",
             "images": "https://m.360buyimg.com/n0/jfs/t2068/298/2448145915/157953/7be197df/56d51a42Nd86f1c8e.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2437/128/1687178395/117431/bcc190c1/56d3fcbaNb2963d21.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2467/222/2263160610/95597/927b8a2f/56d3eafeNdecebeb6.jpg!q70.jpg",
             "itemtype": 2,
             "pid": 53,
             "price": 777.0,
             "pscid": 39,
             "salenum": 0,
             "sellerid": 9,
             "subhead": "Super AMOLED三星双曲面2K 屏，支持无线充电！",
             "title": "三星 Galaxy S7 edge（G9350）4G*/

    private String bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private String itemtype;
    private String pid;
    private String price;
    private String pscid;
    private String salenum;
    private String sellerid;
    private String subhead;
    private String title;

    @Override
    public String toString() {
        return "Data{" +
                "bargainPrice='" + bargainPrice + '\'' +
                ", createtime='" + createtime + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", itemtype='" + itemtype + '\'' +
                ", pid='" + pid + '\'' +
                ", price='" + price + '\'' +
                ", pscid='" + pscid + '\'' +
                ", salenum='" + salenum + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", subhead='" + subhead + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(String bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPscid() {
        return pscid;
    }

    public void setPscid(String pscid) {
        this.pscid = pscid;
    }

    public String getSalenum() {
        return salenum;
    }

    public void setSalenum(String salenum) {
        this.salenum = salenum;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data() {
    }

    public Data(String bargainPrice, String createtime, String detailUrl, String images, String itemtype, String pid, String price, String pscid, String salenum, String sellerid, String subhead, String title) {
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.itemtype = itemtype;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.salenum = salenum;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }
}

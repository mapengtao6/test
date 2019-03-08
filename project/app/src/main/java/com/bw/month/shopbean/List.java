package com.bw.month.shopbean;

/**
 * Time:2019.03.07--14:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class List {

          /*    bargainPrice": 99.0,
            "createtime": "2017-10-14T21:38:26",
            "detailUrl": "https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends",
            "images": "https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg",
            "num": 1,
            "pid": 45,
            "price": 2999.0,
            "pscid": 39,
            "selected": 0,
            "sellerid": 1,
            "subhead": "高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！",
            "title":*/

    private String bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private String num;
    private String pid;
    private String price;
    private String pscid;
    private String selected;
    private String sellerid;
    private String subhead;
    private String title;
    private boolean childCheck = false;

    public boolean isChildCheck() {
        return childCheck;
    }

    public void setChildCheck(boolean childCheck) {
        this.childCheck = childCheck;
    }

    @Override
    public String toString() {
        return "List{" +
                "bargainPrice='" + bargainPrice + '\'' +
                ", createtime='" + createtime + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", num='" + num + '\'' +
                ", pid='" + pid + '\'' +
                ", price='" + price + '\'' +
                ", pscid='" + pscid + '\'' +
                ", selected='" + selected + '\'' +
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
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

    public List() {
    }

    public List(String bargainPrice, String createtime, String detailUrl, String images, String num, String pid, String price, String pscid, String selected, String sellerid, String subhead, String title) {
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.num = num;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.selected = selected;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }
}

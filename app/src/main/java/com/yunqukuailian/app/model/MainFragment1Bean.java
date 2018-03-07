package com.yunqukuailian.app.model;

import java.util.List;

/**
 * Created by android on 2018/3/7.
 */

public class MainFragment1Bean {
    private String pic;
    private String bname;
    private String bprice;
    private String pricedoll;
    private String priceren;
    private String priceupdown;
    private List<MyPrice> list;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    public String getPricedoll() {
        return pricedoll;
    }

    public void setPricedoll(String pricedoll) {
        this.pricedoll = pricedoll;
    }

    public String getPriceren() {
        return priceren;
    }

    public void setPriceren(String priceren) {
        this.priceren = priceren;
    }

    public String getPriceupdown() {
        return priceupdown;
    }

    public void setPriceupdown(String priceupdown) {
        this.priceupdown = priceupdown;
    }

    public List<MyPrice> getList() {
        return list;
    }

    public void setList(List<MyPrice> list) {
        this.list = list;
    }

    class MyPrice{
        private String pricehigh;
        private String pricelow;
        private String volume;

        public String getPricehigh() {
            return pricehigh;
        }

        public void setPricehigh(String pricehigh) {
            this.pricehigh = pricehigh;
        }

        public String getPricelow() {
            return pricelow;
        }

        public void setPricelow(String pricelow) {
            this.pricelow = pricelow;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }
    }
}

package commen;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum OrderStatus {
    PLAYING(1,"待支付"),OK(2,"支付完成");
    private int flg;//标记

    public int getFlg() {
        return flg;
    }

    public void setFlg(int flg) {
        this.flg = flg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;//描述

    OrderStatus(int flg,String desc){
        this.flg = flg;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "flg=" + flg +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static OrderStatus valueOf(int flg){
        for (OrderStatus orderStatus : values()){
            if (orderStatus.flg == flg){
                return orderStatus;
            }
        }
        throw new RuntimeException("orderStatus flg"
                + flg + "not fount!");
    }
}

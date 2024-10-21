package com.liangquan.pay.pojo;


import lombok.Data;

@Data
public class OrderInfo {
    private String oid;
    private String subject;
    private Double total;
    private String desc;
    private String productNo;
    //set/get
}
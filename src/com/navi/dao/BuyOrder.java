package com.navi.dao;

import java.time.LocalTime;

public class BuyOrder{
    private Double buyPrice;
    private String orderId;
    private LocalTime time;
    private String stockName;
    private Integer quantity;

    public BuyOrder(String orderId, LocalTime time, String stockName, Integer quantity,Double buyPrice) {
        this.orderId = orderId;
        this.time = time;
        this.stockName = stockName;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStockName() {
        return stockName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

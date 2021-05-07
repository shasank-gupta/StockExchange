package com.navi.dao;

import java.time.LocalTime;

public class SellOrder {
    private Double sellPrice;
    private String orderId;
    private LocalTime time;
    private String stockName;
    private Integer quantity;

    public SellOrder(String orderId, LocalTime time, String stockName, Integer quantity, Double sellPrice) {
        this.orderId = orderId;
        this.time = time;
        this.stockName = stockName;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
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

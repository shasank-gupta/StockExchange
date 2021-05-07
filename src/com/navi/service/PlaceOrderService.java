package com.navi.service;

import com.navi.dao.BuyOrder;
import com.navi.dao.SellOrder;
import com.navi.matchingstrategy.MatchingStrategy;
import com.navi.order.Orders;

public class PlaceOrderService {
    private Orders orders;
    private MatchingStrategy matchingStrategy;

    public PlaceOrderService(MatchingStrategy strategy) {
        orders = Orders.getOrdersInstance();
        matchingStrategy = strategy;
    }

    public void placeBOrder(BuyOrder order) {
        orders.placeBuyOrder(order);
        matchingStrategy.matchOrders(order.getStockName(), orders);
    }

    public void placeSOrder(SellOrder order) {
        orders.placeSellOrder(order);
        matchingStrategy.matchOrders(order.getStockName(), orders);
    }
}

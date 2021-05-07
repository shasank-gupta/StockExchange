package com.navi.matchingstrategy;

import com.navi.dao.BuyOrder;
import com.navi.dao.SellOrder;
import com.navi.order.Orders;

import java.util.HashMap;
import java.util.PriorityQueue;

public interface MatchingStrategy {
    void matchOrders(String stockName, Orders orders);
}

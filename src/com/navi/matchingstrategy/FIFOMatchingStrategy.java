package com.navi.matchingstrategy;

import com.navi.dao.BuyOrder;
import com.navi.dao.SellOrder;
import com.navi.order.Orders;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FIFOMatchingStrategy implements MatchingStrategy {
    @Override
    public void matchOrders(String stockName, Orders orders) {
        PriorityQueue<SellOrder> sOrder = orders.getSellOrders().get(stockName);
        PriorityQueue<BuyOrder> bOrder = orders.getBuyOrders().get(stockName);
        while (sOrder != null && bOrder != null && !sOrder.isEmpty() && !bOrder.isEmpty()) {
            BuyOrder buy = bOrder.poll();
            SellOrder sell = sOrder.poll();
            if (buy.getBuyPrice().compareTo(sell.getSellPrice()) < 0) {
                bOrder.add(buy);
                sOrder.add(sell);
                break;
            }
            int saleQuantity = 0;
            if (buy.getQuantity() <= sell.getQuantity()) {
                saleQuantity = buy.getQuantity();
                int remaining = sell.getQuantity() - buy.getQuantity();
                sell.setQuantity(remaining);
                if (remaining > 0) {
                    sOrder.add(sell);
                }
            } else {
                saleQuantity = sell.getQuantity();
                int remaining = buy.getQuantity() - sell.getQuantity();
                buy.setQuantity(remaining);
                if (remaining > 0) {
                    bOrder.add(buy);
                }
            }
            System.out.println(String.format("%s %f %d %s", buy.getOrderId(), sell.getSellPrice(), saleQuantity, sell.getOrderId()));
        }

    }

}

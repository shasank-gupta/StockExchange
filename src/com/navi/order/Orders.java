package com.navi.order;

import com.navi.dao.BuyOrder;
import com.navi.dao.SellOrder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Orders {
    private HashMap<String, PriorityQueue<BuyOrder>> buyOrders;
    private HashMap<String, PriorityQueue<SellOrder>> sellOrders;

    private static Orders orders = null;

    private Orders() {
        buyOrders = new HashMap<>();
        sellOrders = new HashMap<>();
    }

    ;

    public static Orders getOrdersInstance() {
        if (orders == null) {
            orders = new Orders();
        }
        return orders;
    }

    public void placeBuyOrder(BuyOrder order) {
        PriorityQueue<BuyOrder> orders = buyOrders.getOrDefault(order.getStockName(), new PriorityQueue<BuyOrder>(new Comparator<BuyOrder>() {
            @Override
            public int compare(BuyOrder o1, BuyOrder o2) {
                int priceComparison = o2.getBuyPrice().compareTo(o1.getBuyPrice());
                if (priceComparison != 0) {
                    return priceComparison;
                }
                return o1.getTime().compareTo(o2.getTime());
            }
        }));
        orders.add(order);
        buyOrders.put(order.getStockName(), orders);
    }

    public void placeSellOrder(SellOrder order) {
        PriorityQueue<SellOrder> orders = sellOrders.getOrDefault(order.getStockName(), new PriorityQueue<SellOrder>(new Comparator<SellOrder>() {
            @Override
            public int compare(SellOrder o1, SellOrder o2) {
                int priceComparison = o1.getSellPrice().compareTo(o2.getSellPrice());
                if (priceComparison != 0) {
                    return priceComparison;
                }
                return o1.getTime().compareTo(o2.getTime());
            }
        }));
        orders.add(order);
        sellOrders.put(order.getStockName(), orders);
    }

    public HashMap<String, PriorityQueue<BuyOrder>> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(HashMap<String, PriorityQueue<BuyOrder>> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public HashMap<String, PriorityQueue<SellOrder>> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(HashMap<String, PriorityQueue<SellOrder>> sellOrders) {
        this.sellOrders = sellOrders;
    }
}

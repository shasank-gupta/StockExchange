package com.navi;

import com.navi.dao.BuyOrder;
import com.navi.dao.SellOrder;
import com.navi.matchingstrategy.FIFOMatchingStrategy;
import com.navi.order.Orders;
import com.navi.service.PlaceOrderService;

import java.io.*;
import java.time.LocalTime;

public class Geektrust {

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        PlaceOrderService service = new PlaceOrderService(new FIFOMatchingStrategy());
        processInput(filePath, service);
    }


    public static void processInput(String filePath, PlaceOrderService orderService) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            System.out.println("please provide a valid file path");
            throw ex;
        }
        String st;
        while ((st = bufferedReader.readLine()) != null) {
            String[] param = st.trim().split("\\s+");
            LocalTime time = LocalTime.parse(param[1]);
            Double price = Double.parseDouble(param[4]);
            Integer quantity = Integer.parseInt(param[5]);
            if (param[3].equalsIgnoreCase("buy")) {
                BuyOrder order = new BuyOrder(param[0], time, param[2], quantity, price);
                orderService.placeBOrder(order);
            } else {
                SellOrder order = new SellOrder(param[0], time, param[2], quantity, price);
                orderService.placeSOrder(order);
            }
        }

    }
}

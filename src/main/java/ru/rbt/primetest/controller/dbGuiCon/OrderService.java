package ru.rbt.primetest.controller.dbGuiCon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "orderService")
@ApplicationScoped
public class OrderService {

    private final static String[] dateOfs;

    private final static String[] customerIds;
    
    private final static String[] idPks;

    static {
        idPks = new String[10];
        idPks[0] = "1";
        idPks[1] = "2";
        idPks[2] = "3";
        idPks[3] = "4";
        idPks[4] = "5";
        idPks[5] = "6";
        idPks[6] = "7";
        idPks[7] = "8";
        idPks[8] = "9";
        idPks[9] = "10";
        
        dateOfs = new String[10];
        dateOfs[0] = "Black";
        dateOfs[1] = "White";
        dateOfs[2] = "Green";
        dateOfs[3] = "Red";
        dateOfs[4] = "Blue";
        dateOfs[5] = "Orange";
        dateOfs[6] = "Silver";
        dateOfs[7] = "Yellow";
        dateOfs[8] = "Brown";
        dateOfs[9] = "Maroon";

        customerIds = new String[10];
        customerIds[0] = "BMW";
        customerIds[1] = "Mercedes";
        customerIds[2] = "Volvo";
        customerIds[3] = "Audi";
        customerIds[4] = "Renault";
        customerIds[5] = "Fiat";
        customerIds[6] = "Volkswagen";
        customerIds[7] = "Honda";
        customerIds[8] = "Jaguar";
        customerIds[9] = "Ford";
    }

    public List<Order> createOrders(int size) {
        List<Order> list = new ArrayList<Order>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Order(getRandomIdPk(), getRandomDateOf(), getRandomCustomerId()));
        }
        return list;
    }

    private String getRandomIdPk() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String getRandomDateOf() {
        return dateOfs[(int) (Math.random() * 10)];
    }

    private String getRandomCustomerId() {
        return customerIds[(int) (Math.random() * 10)];
    }
}
package ru.rbt.primetest.controller.dbGuiCon;

import java.io.Serializable;

public class Order implements Serializable{
    private int id;
    private String date;
    private int customer;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
}

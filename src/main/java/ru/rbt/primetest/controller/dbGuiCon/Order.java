package ru.rbt.primetest.controller.dbGuiCon;

import java.io.Serializable;

public class Order implements Serializable{
    public static String id_pk;
    public String date_of;
    public String customer_Id;

    public Order() {}

    public static void setId_pk(String id_pk) {
        Order.id_pk = id_pk;
    }

    public void setDate_of(String date_of) {
        this.date_of = date_of;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public Order(String id_pk, String date_of, String customer_Id){
        this.id_pk = id_pk;

        this.date_of = date_of;
        this.customer_Id = customer_Id;
    };

    public static String getId_pk() {
        return id_pk;
    }

    public String getDate_of() {
        return date_of;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

}

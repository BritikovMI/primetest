package ru.rbt.primetest.controller.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "BRM_ORDER")
@SessionScoped
public class OrderBean {
    public String getID_PK() {
        return ID_PK;
    }

    public void setID_PK(String ID_PK) {
        this.ID_PK = ID_PK;
    }

    public String getDATE_OF() {
        return DATE_OF;
    }

    public void setDATE_OF(String DATE_OF) {
        this.DATE_OF = DATE_OF;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    private String ID_PK, DATE_OF, CUSTOMER_ID;

    // insert getter setter here
    public ArrayList<OrderBean> getMessages() {
        return OrderDao.getOrder();
    }

}
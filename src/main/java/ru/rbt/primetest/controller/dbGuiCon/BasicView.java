package ru.rbt.primetest.controller.dbGuiCon;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Order> orders;

    @ManagedProperty("#{orderService}")
    private OrderService service;

    @PostConstruct
    public void init() {
        orders = service.createOrders(10);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setService(OrderService service) {
        this.service = service;
    }
}

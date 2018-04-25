package ru.rbt.primetest.controller.dbGuiCon;

import java.util.*;
import javax.annotation.PostConstruct;
import org.fluttercode.datafactory.impl.DataFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class OrderService {
    private List<String> selectedColumns = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private Map<String, String> columnMap = new LinkedHashMap<>();

    @PostConstruct
    private void postConstruct() {
        initColumnProperties();
        initorderList();
    }

    private void initColumnProperties() {
        addColumn("id", "ID_PK");
        addColumn("date", "DATE_OF");
        addColumn("customer", "CUSTOMER_ID");
        selectedColumns.addAll(columnMap.keySet());
    }

    private void addColumn(String propertyName, String displayName) {
        columnMap.put(propertyName, displayName);
    }

    public List<String> getSelectedColumns() {
        return selectedColumns;
    }

    public void setSelectedColumns(List<String> selectedColumns) {
        this.selectedColumns = selectedColumns;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Map<String, String> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, String> columnMap) {
        this.columnMap = columnMap;
    }

    private void initorderList() {
        DataFactory dataFactory = new DataFactory();
        for (int i = 1; i < 5; i++) {
            Order order = new Order();
            order.setId(i);

            order.setDate(dataFactory.getDATE_OF());
            order.setCustomer(dataFactory.getCUSTOMMER_ID());
            orderList.add(order);
        }
    }

}
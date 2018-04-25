package ru.rbt.primetest.controller.testService;

import ru.rbt.primetest.model.jdbc.QueryManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.*;
import java.util.List;

import static ru.rbt.primetest.model.jdbc.Main.getDBInf;

@ManagedBean(name="dstBasicView")
@ViewScoped
public class BasicView implements Serializable {
    Connection con;
    private String roleDesc;
    private ResultSet rs;
    private List<Car> cars;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() throws SQLException {
        cars = service.createCars(5);
        displayTableRecords();
    }
    
    public List<Car> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public static List getDBInf(String query){
        String s1;
//        String query = args[0];
        QueryManager queryManager = new QueryManager();
        List s = queryManager.runQuery(query);

        return s;
    }
    private void displayTableRecords()throws SQLException {
        Statement state = con.createStatement();
        state.executeQuery("SELECT * FROM BRM_ORDER");
        rs = state.getResultSet();
        while(rs.next()){
            roleDesc = rs.getString(2);
        }

    }
}

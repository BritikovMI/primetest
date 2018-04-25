package ru.rbt.primetest.controller.testService;

import ru.rbt.primetest.model.jdbc.QueryManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ru.rbt.primetest.model.jdbc.Main.getDBInf;

@ManagedBean(name="dstBasicView")
@ViewScoped
public class BasicView implements Serializable {
    Connection con;
    private ResultSet rs;
    List context;
    private List<Car> cars;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(5);
        getDBInf("SHOW_TABLE");
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
        String query = "SELECT * FROM USERS";
        PreparedStatement state = con.prepareStatement(query);
        state.execute();
        rs = state.getResultSet();
        while(rs.next()){
            cars = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3);

        }

    }
}

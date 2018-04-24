package ru.rbt.primetest.controller.testService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

import static ru.rbt.primetest.model.jdbc.Main.getDBInf;

@ManagedBean(name="dstBasicView")
@ViewScoped
public class BasicView implements Serializable {
    String[][] context;
    private List<Car> cars;
    
    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(5);
        context = getDBInf("SHOW_TABLE");
    }
    
    public List<Car> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}

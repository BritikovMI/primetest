package ru.rbt.primetest.controller.testService;

import java.io.Serializable;

public class Car implements Serializable {
    public int id;
    public String brand;
    public int year;

    public Car() {}
    
    public Car(int id, String brand, int year) {
        this.id = id;
        this.brand = brand;
        this.year = year;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


}

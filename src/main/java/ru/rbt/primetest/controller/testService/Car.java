package ru.rbt.primetest.controller.testService;

import java.io.Serializable;

public class Car implements Serializable {
    public String id;
    public String brand;
    public int year;

    public Car() {}
    
    public Car(String id, String brand, int year) {
        this.id = id;
        this.brand = brand;
        this.year = year;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
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


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

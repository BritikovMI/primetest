package ru.rbt.primetest.controller;

import ru.rbt.primetest.model.JParser;
import ru.rbt.primetest.model.ParseForCharts;

import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.math.BigDecimal;


@ManagedBean
public class CourseDView {
    public static double[] valSeries;
    JParser parser = new JParser();
    ParseForCharts ps = new ParseForCharts();

    public static double[] getValSeries() {
        return valSeries;
    }

    public static void setValSeries(double[] valSeries) {
        CourseDView.valSeries = valSeries;
    }


    public void getCourse(){
        try {
            valSeries = ps.siteParser(val);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    private String val = "USD";

    public BigDecimal getdCourse() {
        return dCourse;
    }

    public void setdCourse(BigDecimal dCourse) {
        this.dCourse = dCourse;
    }

    private BigDecimal dCourse;

    {
        try {
            dCourse = parser.siteParser(val);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigDecimal updCourse(){
        try {
            dCourse = parser.siteParser(val);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getCourse();
        return dCourse;
    }

//    private String selectRes;

//    public String getSelectRes() {
//        return selectRes;
//    }
//
//    public void setSelectRes(String selectRes) {
//        this.selectRes = selectRes;
//    }
//
//    public BigDecimal getdCourse() {
//        return dCourse;
//    }
//
//    public void setdCourse(BigDecimal dCourse) {
//        this.dCourse = dCourse;
//    }
//
//    public BigDecimal getCourse() {
//        try {
//            dCourse = parser.siteParser();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return dCourse;
//    }
}

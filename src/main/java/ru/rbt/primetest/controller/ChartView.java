package ru.rbt.primetest.controller;

import org.primefaces.model.chart.*;
import ru.rbt.primetest.model.ParseForCharts;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
public class ChartView implements Serializable {
    ParseForCharts ps = new ParseForCharts();
    CourseDView cv = new CourseDView();
    public static double[] valSeries;

    public static void setValSeries(double[] valSeries) {
        CourseDView.valSeries = valSeries;
    }

    private LineChartModel animatedModel1;

    @PostConstruct
    public void init() {
        createAnimatedModels();
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("ValGraphs");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
    }


    private LineChartModel initLinearModel() {
        try {
            valSeries = ps.siteParser("USD");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel(cv.getVal());

        series1.set(1, valSeries[8]);
        series1.set(2, valSeries[7]);
        series1.set(3, valSeries[6]);
        series1.set(4, valSeries[5]);
        series1.set(5, valSeries[4]);
        series1.set(6, valSeries[3]);
        series1.set(7, valSeries[2]);
        series1.set(8, valSeries[1]);
        series1.set(9, valSeries[0]);

        model.addSeries(series1);

        return model;
    }

}

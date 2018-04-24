package ru.rbt.primetest.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParseForCharts {
    static BigDecimal currentElem;
    static LinkedList<BigDecimal> courseElements = new LinkedList<>();
    volatile static Queue<BigDecimal> queue = new PriorityQueue<>();
    //For queue analyze Thread threadRead

    static String[] courseSplit;
    static double[] coursBD = new double[9];

    public static void main(String[] args) {
       /* try {
            valSeries = siteParser("USD");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 9; i++)
            System.out.println(valSeries[i]);*/

    }

    public static String siteLoader(StringBuilder sb, String val) throws IOException {
        URLConnection connection;
        if (val.equals("USD")) {
            connection = new URL("https://finance.rambler.ru/currencies/USD/").openConnection();
        } else {
            connection = new URL("https://finance.rambler.ru/currencies/EUR/").openConnection();
        }
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;


        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);

        reader.close();
        String newSb = sb.toString();

        return newSb;
    }

    public static double[] siteParser(String val) throws IOException {
        StringBuilder sb = new StringBuilder();
        String HTMLSTring = siteLoader(sb, val);
        Document html = Jsoup.parse(HTMLSTring);

//        do {
            String h1 = html.body().getElementsByClass("exr-quote__data-val").text();

            h1 = h1.replaceAll(",", ".");
            courseSplit = h1.split(" ");

//            finalSCourse = courseD[3];

//            finalCourse = BigDecimal.valueOf(Double.parseDouble(finalSCourse));
//        } while (finalCourse == BigDecimal.valueOf(0));

        for (int i = 0; i < 9; i++) {
            try {
                coursBD[i] = Double.parseDouble(courseSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return coursBD;
    }
}

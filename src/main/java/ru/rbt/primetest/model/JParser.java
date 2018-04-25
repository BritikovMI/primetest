package ru.rbt.primetest.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class JParser {
    static BigDecimal currentElem;
    static LinkedList<BigDecimal> courseElements = new LinkedList<>();
    volatile static Queue<BigDecimal> queue = new PriorityQueue<>();
    //For queue analyze Thread threadRead

    static String[] courseD;

    public static void main(String[] args) {
        BigDecimal course = BigDecimal.valueOf(0);
       /* threadWrite.start();
        threadRead.start();
        try {
            threadWrite.join();
            threadRead.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            course = siteParser("USD");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(course);
    }

    static Thread threadWrite = new Thread(() -> {
        BigDecimal finalCourse = BigDecimal.valueOf(0);
        Integer i = Integer.valueOf(0);
        do {
            try {
                finalCourse = siteParser("USD");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            queue.add(finalCourse);
            i++;
        } while (i < 24);
        Thread.interrupted();
    });

    static Thread threadRead = new Thread(() -> {
        int compare;
        BigDecimal first, last;
        courseElements.clear();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
            currentElem = queue.poll();
            if (currentElem != null)
                courseElements.add(currentElem);
        } while (currentElem != null);
        first = courseElements.getFirst();
        last = courseElements.getLast();
        compare = first.compareTo(last);
        if (compare == -1) {
            System.out.println("The rate fell by: " + (first.subtract(last)) + " and amounted to " + last);
        } else if (compare == 1) {
            System.out.println("The rate increased by: " + (last.subtract(first)) + " and amounted to " + last);
        } else {
            System.out.println("The rate has not changed and is equal to: " + first);
        }
        Thread.interrupted();
    });


    public static String siteLoader(StringBuilder sb, String val) throws IOException {
        URLConnection connection;
        if (val.equals("USD")) {
            connection = new URL("https://www.calc.ru/forex-USD-RUB.html").openConnection();
        } else {
            connection = new URL("https://www.calc.ru/forex-EUR-RUB.html").openConnection();
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

    public static BigDecimal siteParser(String val) throws IOException {
        StringBuilder sb = new StringBuilder();
        String finalSCourse;
        BigDecimal finalCourse;

        String HTMLSTring = siteLoader(sb, val);
        Document html = Jsoup.parse(HTMLSTring);

        do {
            String h1 = html.body().getElementsByClass("t18").text();

            courseD = h1.split(" ");
            finalSCourse = courseD[3];

            finalCourse = BigDecimal.valueOf(Double.parseDouble(finalSCourse));
        } while (finalCourse == BigDecimal.valueOf(0));

        return finalCourse;
    }
}


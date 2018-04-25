package ru.rbt.primetest.model.jdbc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by er23887 on 26.07.2017.
 */
public class JdbcProperties {

    private Map<String, String> cashed = new HashMap<String, String>();

    private static JdbcProperties ourInstance = new JdbcProperties();

    public static JdbcProperties getInstance() {
        return ourInstance;
    }

    private JdbcProperties() {
        cashed.put("driver", "oracle.jdbc.driver.OracleDriver");
        cashed.put("host", "rb-devel01.rbtechnologies.ru");
        cashed.put("port", "1521");
        cashed.put("sid", "IRBISRB");
        cashed.put("user", "irbisrb_test");
        cashed.put("pwd", "irbisrb_test");
    }

    public String getDriver() {
        return cashed.get("driver");
    }

    public String getUrl() {
        return String.format("jdbc:oracle:thin:@rb-devel01.rbtechnologies.ru:1521:IRBISRB",
                cashed.get("host"), cashed.get("port"), cashed.get("sid"));
    }

    public String getUsername() {
        return cashed.get("user");
    }

    public String getPassword() {
        return cashed.get("pwd");
    }
}
package ru.rbt.primetest.model.jdbc;

/**
 * Created by er23887 on 25.07.2017.
 */
public class AlternateSelector {

    public static Cmd selector(String name) {//daoselector
        try {
            return Cmd.valueOf(name);
        } catch (Exception e) {
            System.out.println("Please enter valid command! Error :   " +  e.getMessage());
            return null;
        }
    }
}
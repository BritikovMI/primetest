package ru.rbt.primetest.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ListenerView {

    private String text;
    private Object listenerController;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public void handleKeyEvent() {
        text = text.toUpperCase();
    }

    public void setListenerController(Object listenerController) {
        this.listenerController = listenerController;
    }

    public Object getListenerController() {
        return listenerController;
    }
}
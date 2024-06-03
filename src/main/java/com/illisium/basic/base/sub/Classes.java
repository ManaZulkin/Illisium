package com.illisium.basic.base.sub;

import java.io.Serializable;
import java.util.ArrayList;

public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String className;

    private ArrayList<String> classes =  new ArrayList<>();
    public Classes() {
    }

    public void learnClass(String name){

        if(className.isEmpty()){
            className = name;
        }
        classes.add(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

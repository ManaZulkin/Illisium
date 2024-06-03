package com.illisium.basic.base;

import com.illisium.resources.utilit.DataUtility;

import java.io.Serial;
import java.io.Serializable;

public class InfoChar implements Serializable {
    String  element;
    @Serial
    private static final  long serialVersionUID = DataUtility.getSerialForClass(new InfoChar());


    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

}

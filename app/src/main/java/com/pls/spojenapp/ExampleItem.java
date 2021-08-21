package com.pls.spojenapp;

import java.io.Serializable;

public class ExampleItem implements Serializable {
    private String name;
    private String priezvisko;



    public ExampleItem(String name, String priezvisko ) {
        this.name = name;
        this.priezvisko = priezvisko;
    }

    public String getText1() {
        return name;
    }

    public String getText2() {
        return priezvisko;
    }

    public void setText1(String text1) {
        name = text1;
    }

}

//    public void setText2(String text2) {
//        mText2 = text2;
//    }
//}





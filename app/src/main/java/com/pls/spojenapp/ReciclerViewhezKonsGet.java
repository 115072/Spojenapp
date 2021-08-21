package com.pls.spojenapp;

public class ReciclerViewhezKonsGet {
    private String nev;
    private int pontok;

    public ReciclerViewhezKonsGet() {

    }

    public ReciclerViewhezKonsGet(String nev, int pontok) {
        this.nev = nev;
        this.pontok = pontok;
    }

    public String getNev() {
        return nev;
    }

    public int getPontok() {
        return pontok;
    }
}

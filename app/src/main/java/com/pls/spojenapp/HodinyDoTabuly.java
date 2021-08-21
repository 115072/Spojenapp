package com.pls.spojenapp;

public class HodinyDoTabuly {


    String nulta,prva,druha,tretia="3",stvrta="4",piata="5",siesta="6",siedma="7",osma="8";


public HodinyDoTabuly(){

}

public HodinyDoTabuly(String nulta , String prva, String druha,String tretia,String stvrta,String piata,String siesta,String siedma,String osma){
    this.nulta = nulta;
    this.prva = prva;
    this.druha = druha;
    this.tretia = tretia;
    this.stvrta = stvrta;
    this.piata = piata;
    this.siesta = siesta;
    this.siedma = siedma;
    this.osma = osma;

}

    public String getNulta() {
        return nulta;
    }

    public String getPrva() {
        return prva;
    }

    public String getDruha() {
        return druha;
    }

    public String getTretia() {
        return tretia;
    }

    public String getStvrta() {
        return stvrta;
    }

    public String getPiata() {
        return piata;
    }

    public String getSiesta() {
        return siesta;
    }

    public String getSiedma() {
        return siedma;
    }

    public String getOsma() {
        return osma;
    }
}







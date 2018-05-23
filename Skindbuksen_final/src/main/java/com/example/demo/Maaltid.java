package com.example.demo;

//klasse til retter
public class Maaltid {
    private int id;
    private String navn;
    private int pris;

    public Maaltid(int id, String navn, int pris) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
    }

    public Maaltid() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}

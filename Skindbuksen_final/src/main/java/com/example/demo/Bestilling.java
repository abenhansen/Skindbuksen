package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bestilling {
    private int id;
    private String retter;
    private int totalpris;
    private int bord;

    public Bestilling() {
    }

    public Bestilling(int id, String retter, int totalpris, int bord, String tidspunkt, String dato) {
        this.id = id;
        this.retter = retter;
        this.totalpris = totalpris;
        this.bord = bord;
    }

    @Override
    public String toString() {
        return "Bestilling{" +
                "id=" + id +
                ", retter='" + retter + '\'' +
                ", totalpris=" + totalpris +
                ", bord=" + bord +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRetter() {
        return retter;
    }

    public void setRetter(String retter) {
        this.retter = retter;
    }

    public int getTotalpris() { return totalpris; }

    public void setTotalpris(int totalpris) {
        this.totalpris = totalpris;
    }

    public int getBord() {
        return bord;
    }

    public void setBord(int bord) {
        this.bord = bord;
    }

}

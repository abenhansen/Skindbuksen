package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


//En klasse for reservation i systemet, her sætter reservationRepository alt sin data ind
public class Reservation implements Comparable<Reservation> {
    private int reservationID;
    private int bordNr;
    private int antal;
    private String tidspunkt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dato;
    private String fornavn;
    private String efternavn;

    public Reservation(int reservationID, int bordNr, int antal, String tidspunkt, Date dato, String fornavn, String efternavn) {
        this.reservationID = reservationID;
        this.bordNr = bordNr;
        this.antal = antal;
        this.tidspunkt = tidspunkt;
        this.dato = dato;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    public Reservation(){

    }


    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getBordNr() {
        return bordNr;
    }

    public void setBordNr(int bordNr) {
        this.bordNr = bordNr;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", bordNr=" + bordNr +
                ", antal=" + antal +
                ", tidspunkt='" + tidspunkt + '\'' +
                ", dato=" + dato +
                ", fornavn='" + fornavn + '\'' +
                ", efternavn='" + efternavn + '\'' +
                '}';
    }
    //Overrider compareTo fra comparable interfacen som er en metode der sortere objekter med deres dato fields
    @Override
    public int compareTo(Reservation o) {
        return getDato().compareTo(o.getDato());
    }
}

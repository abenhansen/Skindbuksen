package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reservation {
    private Long bordNr;
    private int antal;
    private String tidspunkt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dato;
    private String kunde;





}

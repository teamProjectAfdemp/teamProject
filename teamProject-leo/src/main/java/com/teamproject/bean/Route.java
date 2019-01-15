package com.teamproject.bean;

import java.sql.Timestamp;
import java.util.Date;


public class Route {
    private int id;
    private int creator_id;
    private String departure;
    private String destination;
    private Timestamp dep_time;
    private Timestamp ar_time;
    private String description;
    
    public Route(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDep_time() {
        return dep_time;
    }

    public void setDep_time(Timestamp dep_time) {
        this.dep_time = dep_time;
    }

    public Timestamp getAr_time() {
        return ar_time;
    }

    public void setAr_time(Timestamp ar_time) {
        this.ar_time = ar_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

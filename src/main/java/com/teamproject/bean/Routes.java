package com.teamproject.bean;

import java.util.Date;


public class Routes {
    private int id;
    private int creator_id;
    private String departure;
    private String destination;
    private Date dep_time;
    private Date ar_time;
    private String description;
    
    public Routes(){
        
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

    public Date getDep_time() {
        return dep_time;
    }

    public void setDep_time(Date dep_time) {
        this.dep_time = dep_time;
    }

    public Date getAr_time() {
        return ar_time;
    }

    public void setAr_time(Date ar_time) {
        this.ar_time = ar_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

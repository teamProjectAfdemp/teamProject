package com.teamproject.bean;


public class Route {
    private int id;
    private int creator_id;
    private String title;
    private String shortdesc;
    private String description;
    private int seats;
    private String dep_time;
    private String ar_time;
    private String created;
    private String image;
    
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getAr_time() {
        return ar_time;
    }

    public void setAr_time(String ar_time) {
        this.ar_time = ar_time;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
package com.shawn.roverproject.DTO;

import java.util.Date;


public class RoverDTO {


    private int roverid;
    private int x;
    private int y;
    private String direction;
    private String path;
    private Date LastUpdate;
    private String destination;



    public RoverDTO(int roverid, int x, int y, String direction, String path, Date LastUpdate, String destination) {
        this.roverid = roverid;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.path = path;
        this.LastUpdate = LastUpdate;
        this.destination = destination;
    }





    public RoverDTO(int x, int y, String direction, String path, String destination) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.path = path;
        this.destination = destination;
    }


    public RoverDTO(int roverid, int x, int y, String direction, Date lastUpdate, String destination) {
        this.roverid = roverid;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.LastUpdate = lastUpdate;
        this.destination = destination;
    }





    public RoverDTO() {
        super();
    }

    public int getRoverid() {
        return roverid;
    }

    public void setRoverid(int roverid) {
        this.roverid = roverid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public Date getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        LastUpdate = lastUpdate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "RoverDTO [roverid=" + roverid + ", x=" + x + ", y=" + y + ", direction=" + direction + ", path="
                + path + ", LastUpdate=" + LastUpdate + ", destination=" + destination + "]";
    }







}

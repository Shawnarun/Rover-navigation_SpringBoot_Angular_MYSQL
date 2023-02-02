package com.shawn.roverproject.DTO;

import com.shawn.roverproject.entity.Calculation;

import java.util.Date;

public class RoverSaveDTO {
    private int x;
    private int y;
    private String direction;
    private String path;
    private Date LastUpdate;
    private String destination;



    public RoverSaveDTO(int x,int y, String direction, String path, String destination) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.path = path;
        this.destination = destination;
    }


    public RoverSaveDTO() {
        super();
    }




    public int getX() {
        return x;
    }

    public void setX() {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY() {
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


    public String getDestination() {
        Calculation rover =new Calculation();
        rover.setPosition(getX(),getY(),getDirection());
        System.out.println(getDirection()+ "checkone");
        rover.process(getPath());
        return rover.printPosition();
    }

    public void setDestination() {
        this.destination = getDestination();
    }




    public void setLastUpdate(Date lastUpdate) {
        LastUpdate = lastUpdate;
    }


    @Override
    public String toString() {
        return "RoverSaveDTO [x=" + x + ", y=" + y + ", direction=" + direction + ", path=" + path + ", LastUpdate="
                + LastUpdate + ", destination=" + destination + "]";
    }


}

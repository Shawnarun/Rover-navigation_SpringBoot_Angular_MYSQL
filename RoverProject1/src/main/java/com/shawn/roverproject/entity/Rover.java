package com.shawn.roverproject.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
    @Table(name="rover")
    public class Rover {

        @Id
        @Column(name="rover_id",length=50)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int roverid;

        @Column(name="x",length=50)
        private int x;

        @Column(name="y",length=50)
        private int y;

        @Column(name="direction",length=50)
        private String direction;

        @Column(name="path",length=80)
        private String path;

        @CreationTimestamp
        @Column(name="LastUpdate",nullable =false,updatable=false)
        private Date LastUpdate;



        @Column(name="destination",length=50)
        private String destination;



        public Rover(int roverid, int x, int y, String direction, String path) {
            this.roverid = roverid;
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.path = path;
            this.LastUpdate = LastUpdate;
            this.destination = destination;
        }



        public Rover(int x,int y, String direction, String path, String destination) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.path = path;
            this.destination = destination;
        }





        public Rover() {
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


        public String getDestination() {
            Calculation rover =new Calculation();
            rover.setPosition(getX(),getY(),getDirection());
            System.out.println(getDirection()+ "check two");
            rover.process(getPath());
            return rover.printPosition();
        }

        public void setDestination(String destination) {
            this.destination = getDestination();
        }




        public Date getLastUpdate() {
            return LastUpdate;
        }



        public void setLastUpdate(Date lastUpdate) {
            LastUpdate = lastUpdate;
        }











    }

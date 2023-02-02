package com.shawn.roverproject.entity;

public class Calculation {
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    int facing;;

    public Calculation() {
    }


    public void setPosition(Integer x, Integer y, String facing) {
        this.x = x;
        this.y = y;

        switch(facing) {
            //Case statements
            case "N":
                this.facing=1;
                break;
            case "E":
                this.facing=2;
                break;
            case "W":
                this.facing=3;
                break;
            case "S":
                this.facing=4;
                break;
            default:
                System.out.println("Invalid Direction");

        }
    }


    public String printPosition() {
        System.out.println(facing+ " check four");
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        return (x +  " "  + y +  " "  + dir);
    }


    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++  ) {
            process(commands.charAt(idx));
        }
    }



    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "");
        }
    }
    private void move() {
        if (facing == N) {
            this.y++ ;
        } else if (facing == E) {
            this.x++ ;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    private void turnRight() {
        facing = (facing + 1) > W ? N : facing   +1;
    }


}

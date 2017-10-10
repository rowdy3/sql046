package com.luxoft.sql;

public class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p1){
        double distanceX = (x - p1.x);
        double distanceY = (y-p1.y);
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

}

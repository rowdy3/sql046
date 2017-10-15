package com.luxoft.sql;

public class Equation {
    double a;
    double b;
    double c;
    String rootsCount;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public String getCountRoots() {
        double discriminant = Math.pow(b, 2) - 4*a*c;
        if (discriminant < 0){
            return rootsCount = "В уравнении нет корня";
        }
        if (discriminant == 0){
            return rootsCount = "В уравнении 1 корень";
        }else
            return rootsCount = "В уравнении 2 корня";
    }
}

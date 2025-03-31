package com.mceserani;

public class Posizione {

    int x;
    int y;

    Posizione(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Posizione{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}

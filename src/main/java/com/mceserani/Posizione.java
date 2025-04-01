package com.mceserani;

public class Posizione {

    private int x;
    private int y;

    public Posizione(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    // Getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        return "Posizione{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return x == posizione.x && y == posizione.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

}

package com.mceserani;

public class Cibo {

    String nome;
    int energia;
    Posizione posizione;

    Cibo(String n, int e, Posizione p){
        nome = n;
        energia = e;
        posizione = p;
    }

    @Override
    public String toString() {
        return "Cibo{" +
                "nome='" + nome + '\'' +
                ", energia=" + energia +
                ", posizione=" + posizione +
                '}';
    }

}

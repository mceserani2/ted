package com.mceserani;

public class Personaggio {

    String nome;
    String provenienza;
    int età;
    Skin skin;
    int vita = 100;
    Posizione p;

    Personaggio(String n, String pr, int e, Skin s, Posizione pos){
        nome = n;
        provenienza = pr;
        età = e;
        skin = s;
        p = pos;
    }

    void siMuove(Posizione dest){
        p = dest;
    }

    void mangia(Cibo c){
        vita = vita + c.energia;
        if (vita > 100)
            vita = 100;
    }

}

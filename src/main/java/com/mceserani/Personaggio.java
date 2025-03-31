package com.mceserani;

public class Personaggio {

    private String nome;
    private String provenienza;
    private int età;
    private Skin skin;
    private int vita = 100;
    private Posizione p;

    Personaggio(String n, String pr, int e, Skin s, Posizione pos){
        nome = n;
        provenienza = pr;
        età = e;
        skin = s;
        p = pos;
    }

    String getNome(){
        return nome;
    }

    int getVita(){
        return vita;
    }

    void setVita(int v){
        vita = v;
    }   

    void siMuove(Posizione dest){
        p = dest;
    }

    void mangia(Cibo c){
        vita = vita + c.energia;
        if (vita > 100)
            vita = 100;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nProvenienza: " + provenienza + "\nEtà: " + età + "\nVita: " + vita + "\nPosizione: " + p + "\nSkin: " + skin;
    } 

}

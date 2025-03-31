package com.mceserani;

import java.util.Random;

public class Mago extends Personaggio{

    int mana = 100;

    Mago(String n, String pr, int e,Skin s, Posizione pos){
        super(n,pr,e,s,pos);
    }

    Mago(String n, String pr, int e,Skin s, Posizione pos, int m){
        super(n,pr,e,s,pos);
		mana = m;
    }

    void lanciaMagia(Magia m, Personaggio p){
        Random r = new Random();
        if (mana >= m.mana)
            mana -= m.mana;
        if (r.nextInt(10) + 1 > 3)
            p.setVita(p.getVita() - m.danno);
        if (p.getVita() < 0)
            p.setVita(0);
    }

    void bevePozione(Pozione p){
        mana += p.mana;
        if (mana > 100)
            mana = 100;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nProvenienza: " + provenienza + "\nEtà: " + età + "\nVita: " + vita + "\nmana: " + mana;
    }

}

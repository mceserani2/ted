package com.mceserani;

import java.util.Random;

public class Mago extends Personaggio{

    private int mana = 100;

    public Mago(String n, String pr, int e,Skin s, Posizione pos){
        super(n,pr,e,s,pos);
    }

    public Mago(String n, String pr, int e,Skin s, Posizione pos, int m){
        super(n,pr,e,s,pos);
		mana = m;
    }

    // Setters
    public void setMana(int m){
        if (m >= 0 && m <= 100)
            mana = m;
        else if (m < 0)
            mana = 0;
        else
            mana = 100;
    }

    // Getters
    public int getMana(){
        return mana;
    }

    public boolean lanciaMagia(Magia m, Personaggio p){
        Random r = new Random();
        boolean hit = false;
        if (mana >= m.getMana())
            mana -= m.getMana();
        else
            return hit;
        if (r.nextInt(10) + 1 > 3){
            p.setVita(p.getVita() - m.getDanno());
            hit = true;
        }
        if (p.getVita() < 0)
            p.setVita(0);
        return hit;
    }

    public void bevePozione(Pozione p){
        mana += p.getMana();
        if (mana > 100)
            mana = 100;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() + "\nProvenienza: " + this.getProvenienza() + "\nEtà: " + this.getEtà() + "\nVita: " + this.getVita() + "\nmana: " + mana;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode() + 31 * mana;
    }

}

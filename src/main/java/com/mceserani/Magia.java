package com.mceserani;

public class Magia {

    private String nome;
    private int mana;
    private int danno;

    public Magia(String n, int m, int d){
        nome = n;
        mana = m;
        danno = d;
    }

    // Setters
    public void setNome(String n){
        if (n != null && n.length() > 0)
            nome = n;
        else
            System.out.println("Nome non valido");
    }

    public void setMana(int m){
        if (m >= 0 && m <= 100)
            mana = m;
        else if (m < 0)
            mana = 0;
        else
            mana = 100;
    }

    public void setDanno(int d){
        if (d >= 0 && d <= 100)
            danno = d;
        else if (d < 0)
            danno = 0;
        else
            danno = 100;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public int getMana(){
        return mana;
    }

    public int getDanno(){
        return danno;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nMana: " + mana + "\nDanno: " + danno;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magia magia = (Magia) o;
        return nome.equals(magia.nome);
    }

    @Override
    public int hashCode(){
        return nome.hashCode() + 31 * mana + 31 * danno;
    }

}

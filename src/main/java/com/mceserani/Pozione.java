package com.mceserani;

public class Pozione {

    private String nome;
    private int mana;
    private Posizione posizione;

    public Pozione(String n, int m, Posizione p){
        posizione = p;
        nome = n;
        mana = m;
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

    public void setPosizione(Posizione p){
        posizione = p;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public int getMana(){
        return mana;
    }

    public Posizione getPosizione(){
        return posizione;
    }

    @Override
    public String toString() {
        return "Pozione{" +
                "nome='" + nome + '\'' +
                ", mana=" + mana +
                ", posizione=" + posizione +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozione pozione = (Pozione) o;
        return nome.equals(pozione.nome) && posizione.equals(pozione.posizione);
    }

    @Override
    public int hashCode() {
        return 31 * nome.hashCode() + posizione.hashCode();
    }

}

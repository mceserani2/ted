package com.mceserani;

public class Cibo {

    private String nome;
    private int energia;
    private Posizione posizione;

    public Cibo(String n, int e, Posizione p){
        nome = n;
        energia = e;
        posizione = p;
    }

    // Setters
    public void setNome(String n){
        if (n != null && n.length() > 0)
            nome = n;
        else
            System.out.println("Nome non valido");
    }

    public void setEnergia(int e){
        if (e >= 0 && e <= 100)
            energia = e;
        else if (e < 0)
            energia = 0;
        else
            energia = 100;
    }

    public void setPosizione(Posizione p){
        posizione = p;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public int getEnergia(){
        return energia;
    }

    public Posizione getPosizione(){
        return posizione;
    }

    @Override
    public String toString() {
        return "Cibo{" +
                "nome='" + nome + '\'' +
                ", energia=" + energia +
                ", posizione=" + posizione +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cibo cibo = (Cibo) o;
        return nome.equals(cibo.nome) && posizione.equals(cibo.posizione);
    }

    @Override
    public int hashCode() {
        return 31 * nome.hashCode() + posizione.hashCode();
    }

}

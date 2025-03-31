package com.mceserani;

public class Ted {
	
	private Ted(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author Matteo Ceserani
	 * @version 0.9
	 */
    public static void main(String[] args){

		Mago m1 = null;
		Mago m2 = null;

		System.out.print("Inserisci il nome del primo mago: ");
		String nome = System.console().readLine();
		System.out.print("Inserisci la provenienza del primo mago: ");
		String provenienza = System.console().readLine();
		System.out.print("Inserisci l'età del primo mago: ");
		int età = Integer.parseInt(System.console().readLine());

		if (nome.length() > 0 && provenienza.length() > 0 && età >= 0){
			m1 = new Mago(nome,provenienza,età,null,new Posizione(0,0));

			System.out.println("Nome: " + m1.getNome());
			System.out.println("Provenienza: " + m1.provenienza);
			System.out.println("Età: " + m1.età);
			System.out.println("Vita: " + m1.vita);
			System.out.println("Posizione: " + m1.p);
			System.out.println("Skin: " + m1.skin);
			System.out.println("mana: " + m1.mana);

		} else {
			System.out.println("Parametri non validi: non ho creato il personaggio.");
		}

		System.out.print("Inserisci il nome del secondo mago: ");
		nome = System.console().readLine();
		System.out.print("Inserisci la provenienza del secondo mago: ");
		provenienza = System.console().readLine();
		System.out.print("Inserisci l'età del secondo mago: ");
		età = Integer.parseInt(System.console().readLine());

		if (nome.length() > 0 && provenienza.length() > 0 && età >= 0){
			m2 = new Mago(nome,provenienza,età,null,new Posizione(0,0));

			System.out.println("Nome: " + m2.nome);
			System.out.println("Provenienza: " + m2.provenienza);
			System.out.println("Età: " + m2.età);
			System.out.println("Vita: " + m2.vita);
			System.out.println("Posizione: " + m2.p);
			System.out.println("Skin: " + m2.skin);
			System.out.println("mana: " + m2.mana);

		} else {
			System.out.println("Parametri non validi: non ho creato il personaggio.");
		}
		
		Magia m = new Magia("Abracadabra",10,15);
		Pozione p = new Pozione("Blue Pot", 25, new Posizione(0,0));

		System.out.println("Il mago " + m1.nome + " lancia la magia " + m.nome);

		m1.lanciaMagia(m,m2);

		System.out.println(m1.toString());
		System.out.println(m2.toString());

		System.out.print("Premi invio per continuare...");
		System.console().readLine();

		System.out.println("Il mago " + m2.nome + " lancia la magia " + m.nome);

		m2.lanciaMagia(m,m1);

		System.out.println(m1.toString());
		System.out.println(m2.toString());

		System.out.print("Premi invio per continuare...");
		System.console().readLine();

		System.out.println("Il mago " + m1.nome + " beve la pozione " + p.nome);

		m1.bevePozione(p);

		System.out.println(m1.toString());
		System.out.println(m2.toString());

		System.out.print("Premi invio per continuare...");
		System.console().readLine();

		System.out.println("Il mago " + m2.nome + " beve la pozione " + p.nome);

		m2.bevePozione(p);

		System.out.println(m1.toString());
		System.out.println(m2.toString());

		System.out.print("Premi invio per continuare...");
		System.console().readLine();

    }

}
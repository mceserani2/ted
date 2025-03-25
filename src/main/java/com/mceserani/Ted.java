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

		System.out.print("Inserisci il nome del personaggio: ");
		String nome = System.console().readLine();
		System.out.print("Inserisci la provenienza del personaggio: ");
		String provenienza = System.console().readLine();
		System.out.print("Inserisci l'età del personaggio: ");
		int età = Integer.parseInt(System.console().readLine());

		if (nome.length() > 0 && provenienza.length() > 0 && età >= 0){
			Personaggio p = new Personaggio(nome,provenienza,età,null,null);

			System.out.println("Nome: " + p.nome);
			System.out.println("Provenienza: " + p.provenienza);
			System.out.println("Età: " + p.età);
			System.out.println("Vita: " + p.vita);
			System.out.println("Posizione: " + p.p);
			System.out.println("Skin: " + p.skin);

		} else {
			System.out.println("Parametri non validi: non ho creato il personaggio.");
		}
		

    }

}
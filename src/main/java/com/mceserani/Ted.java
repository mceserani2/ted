package com.mceserani;

import java.util.Random;

public class Ted {

	static final int MX = 15;
	static final int MY = 15;

	static Cibo cibi [];
	static Pozione pozioni [];
	static Mago nemici [];
	static Magia magie [];
	
	static Mago M;

	private Ted(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author Matteo Ceserani
	 * @version 0.9
	 */
    public static void main(String[] args){

		System.out.println("Benvenuto nel gioco di ruolo Ted!");
		System.out.println("Iniziamo a creare il tuo personaggio.");

		do {
			System.out.print("Inserisci il nome del tuo personaggio: ");
			String nome = System.console().readLine();
			System.out.print("Inserisci la provenienza del tuo personaggio: ");
			String provenienza = System.console().readLine();
			System.out.print("Inserisci l'età del tuo personaggio: ");
			int età = Integer.parseInt(System.console().readLine());

			if (nome.length() > 0 && provenienza.length() > 0 && età >= 0){
				M = new Mago(nome,provenienza,età,null,new Posizione(0,0));
			} else {
				System.out.println("Parametri non validi: non ho creato il personaggio.");
			}
		} while (M == null);

		System.out.println("Hai creato il tuo personaggio: " + M.getNome());

		Random r = new Random();
		
		cibi = new Cibo[5];
		for (int i = 0; i < 3; i++){
			cibi[i] = new Cibo("Mela",10,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		}
		for (int i = 3; i < 5; i++){
			cibi[i] = new Cibo("Bistecca",25,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		}

		pozioni = new Pozione[5];
		for (int i = 0; i < 3; i++){
			pozioni[i] = new Pozione("BluePot",15,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		}
		for (int i = 3; i < 5; i++){
			pozioni[i] = new Pozione("PurplePot",10,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		}

		nemici = new Mago[3];
		nemici[0] = new Mago("Casanova","Isengard",100,null,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		nemici[1] = new Mago("Mago di Segrate","Segrate",100,null,new Posizione(r.nextInt(MX),r.nextInt(MY)));
		nemici[2] = new Mago("Divino Otelma","Genova",100,null,new Posizione(r.nextInt(MX),r.nextInt(MY)),25);

		magie = new Magia[2];
		magie[0] = new Magia("Fulmine",10,20);
		magie[1] = new Magia("Palla di Fuoco",20,30);

		char command;

		// Turno di gioco
		while(true){
			System.out.print("\033[H\033[2J");
			System.out.flush();
			disegnaMappa();
			System.out.print(":>");
			command = System.console().readLine().charAt(0);
			M.siMuove(command, Ted.MX, Ted.MY);
			for (int i = 0; i < nemici.length; i++){
				if (nemici[i].getPosizione().equals(M.getPosizione())){
					System.out.println("Hai incontrato il nemico " + nemici[i].getNome());
					System.out.println("Quale magia vuoi lanciare?");
					for (int j = 0; j < magie.length; j++){
						System.out.println(j + " - " + magie[j].getNome());
					}
					System.out.print(":>");
					int m = Integer.parseInt(System.console().readLine());
					boolean hit = M.lanciaMagia(magie[m],nemici[i]);
					if (hit) {
						System.out.println("Hai colpito il nemico.");
						if (nemici[i].getVita() <= 0){
							System.out.println("Il nemico è morto!");
							nemici[i].setPosizione(new Posizione(-1,-1));
							if (haiVinto()){
								System.out.println("Hai vinto! Congrats!");
								return;
							}
						}
					}
					if (nemici[i].getVita() > 0){
						hit = nemici[i].lanciaMagia(magie[r.nextInt(magie.length)], M);
						if (hit) {
							System.out.println("Il nemico ti ha colpito");
							System.out.println("Vita residua: " + M.getVita());
							if (M.getVita() <= 0){
								System.out.println("Sei morto!");
								return;
							}
						}
					}
					System.out.println("Premi invio per continuare...");
					System.console().readLine();
				}
			}
		}
		
    } // End main()

	static void disegnaMappa(){
		// Matrice strutturata in righe e colonne
		// MY righe e MX colonne
		// Per ogni casella disegnamo:
		// - M per il mago protagonista
		// - c per un cibo
		// - p per una pozione
		// - N per un nemico
		// - . se la casella è vuota
		// La gerarchia è: M, N, p, c, .

		char c = '.';
		for (int y = 0; y < MY; y++){
			for (int x = 0; x < MX; x++){
				for (int i = 0; i < cibi.length; i++){
					if (cibi[i].getPosizione().equals(new Posizione(x,y)))
						c = 'c';
				}
				for (int i = 0; i < pozioni.length; i++){
					if (pozioni[i].getPosizione().equals(new Posizione(x,y)))
						c = 'p';
				}
				for (int i = 0; i < nemici.length; i++){
					if (nemici[i].getPosizione().equals(new Posizione(x,y)))
						c = 'N';
				}
				if (M.getPosizione().equals(new Posizione(x,y)))
					c = 'M';
				System.out.print(c);
				System.out.print(" ");
				c = '.';
			}
			System.out.println("");
		}

	} // End disegnaMappa

	public static boolean haiVinto(){
		boolean vittoria = true;
		for (int i = 0; i < nemici.length; i++){
			if (!nemici[i].getPosizione().equals(new Posizione(-1,-1)))
				vittoria = false;
		}
		return vittoria;
	}

} // End class Ted
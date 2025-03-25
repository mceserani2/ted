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
       
		Personaggio p = new Personaggio("Pippo","Topolinia",45,null,null);

		System.out.println("Nome: " + p.nome);
		System.out.println("Provenienza: " + p.provenienza);
		System.out.println("Età: " + p.età);
		System.out.println("Vita: " + p.vita);
		System.out.println("Posizione: " + p.p);
		System.out.println("Skin: " + p.skin);
		

    }

}
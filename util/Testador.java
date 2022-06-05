package util;

import java.io.IOException;
import java.util.LinkedList;

import game.engine;
import model.CartaTeste;


public class Testador {
	public static void main(String[] args) throws IOException {

		

		engine bar = new engine();
		CartaTeste carta  =new CartaTeste();
		LinkedList<CartaTeste> baralho;
		LinkedList<CartaTeste> embaralhado;


		baralho = carta.ler("view/assets/baralhoNaruto.txt");
	
		embaralhado = bar.embaralhar(baralho, 16);
		
		for (int i = 0; i < embaralhado.size(); i++) {
			System.out.println(embaralhado.get(i));
		}
		
	}
}

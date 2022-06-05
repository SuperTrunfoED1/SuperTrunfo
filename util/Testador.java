package util;

import java.io.IOException;
import model.CartaTeste;


public class Testador {
	public static void main(String[] args) throws IOException {

		

		ListaInterface<CartaTeste> baralho = new Lista<CartaTeste>();

		CartaTeste card = new CartaTeste();
		
		card.setId(149);
		card.setNomeCarta("Sakura");
		card.setAtaque(800);
		card.setDefesa(750);
		card.setPoder(400);
		
		baralho.add(card);

		EscritorCSV escrito = new EscritorCSV();
		escrito.escrever("view/assets/baralhoNaruto.txt", baralho);

		escrito.ler("view/assets/baralhoNaruto.txt");
	
	}
}

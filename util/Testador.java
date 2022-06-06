package util;

import java.io.IOException;

import game.Engine;
import model.Carta;

public class Testador {
	public static void main(String[] args) throws IOException {
		Engine partida = new Engine();
        Carta cartas = new Carta();
        Lista<Carta> listaCartas = new Lista<>();
        try {
            listaCartas = cartas.ler("view/assets/baralhoFutebol.txt");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        partida.iniciar(listaCartas);

        listaCartas = partida.getCartasPlayer();

		for (int i = 0; i < listaCartas.size(); i++) {
			System.out.println(listaCartas.search(i));
		}
	}
}

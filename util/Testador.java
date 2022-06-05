package util;

import java.io.IOException;

public class Testador {
	public static void main(String[] args) throws IOException {
		Lista<Double> lista = new Lista<Double>();
		
		lista.add(22.3);
		lista.add(109.3);
		lista.add(6.78);
		lista.add(11.5);
		lista.add(33.9);

		System.out.println("Elemento: " + lista.search(3));
	}
}

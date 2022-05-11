package util;

import java.io.IOException;

public class Testador {
    public static void main(String[] args) {
        ListaInterface<String> lista = new Lista<String>();
        ListaInterface<String> lista2;
        EscritorCSV escritor = new EscritorCSV();
        
        lista.add("primeiro");
        lista.add("segundo");
        lista.add("terceiro");
        lista.add("kkk");

        try {
			escritor.escrever("util/texto.txt", lista);
		} catch (IOException e) {
			System.out.println("Erro na escrita");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Pane geral!");
			e.printStackTrace();
		}

        try {
			lista2 = escritor.ler("util/texto.txt");
			lista2.show();
		} catch (IOException e) {
			System.out.println("Erro na leitura");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Pane geral!");
			e.printStackTrace();
		}
    }
}

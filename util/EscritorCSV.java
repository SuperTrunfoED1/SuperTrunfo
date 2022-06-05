package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorCSV {

    public <T> void escrever(String path, ListaInterface<T> lista) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        String texto = "";

        while (lista.peekLast() != null) {
            texto += lista.shift() + "\n";
        }
        bufferedWriter.append(texto);
        bufferedWriter.close();
    }
}

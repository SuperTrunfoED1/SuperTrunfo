package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorCSV {
    
    public void escrever(String path, ListaInterface<String> lista) throws IOException{
        
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
		String texto = "";

        while(lista.peekLast() != null){
           texto = texto.concat(lista.shift()).concat("\n");    
        }
        
        bufferedWriter.append(texto);
		bufferedWriter.close();
    }

    public ListaInterface<String> ler(String path) throws IOException{

        BufferedReader bufferedReader = new BufferedReader( new FileReader(path) );
		ListaInterface<String> texto = new Lista<String>();
		String linha = "";
		
		while (linha != null) 
		{
			linha = bufferedReader.readLine();
            if(linha != null){
                texto.add(linha);
            }
		}
		bufferedReader.close();
		
		return texto;
    }
}

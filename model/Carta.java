package model;

import util.Lista;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Carta {
    
    //----------------------------
    //atributos
    
    String nomeCarta;   
    //usei esse nome na variavel para não confundir com o "name" em Atributos.

    String imgPath;//caminho da imagem do personagem ou objeto da carta
    
    String [] nomeAtributo = new String[3];

    Double [] valoresAtributo = new Double[3];
    
    //----------------------------
    //construtores

    public Carta(String nomeCarta, String imgPath){  
        setNome(nomeCarta);
        setImgPath(imgPath);       
    }

    public Carta(String nomeCarta){  
        setNome(nomeCarta);  
    }

    public Carta(){  

    }

    //----------------------------
    //getters-setters

    public String getNome() {
        return nomeCarta;
    }

    public void setNome(String nomeCarta) {
        if(nomeCarta == null){
            System.out.println("Digita algo!");
        }else if(nomeCarta.isBlank()){
            System.out.println("O nome não pode ser apenas um espaço vazio!");
        }else{
            this.nomeCarta = nomeCarta;
        }
    }

    public String getImgPath() {
        return imgPath;
    }
    
    public void setImgPath(String imgPath) {
        if(imgPath == null){
            System.out.println("Digita algo!");
        }else if(imgPath.isBlank()){
            System.out.println("O path não pode ser apenas um espaço vazio!");
        }else{
            this.imgPath = imgPath;
        }
    }

    //----------------------------
    //metodos
    
    public Lista<Carta> ler(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Lista<Carta> ListaCartas = new Lista<Carta>();
        String linha = "";

        while (linha != null) {
            linha = bufferedReader.readLine();
            Carta carta = new Carta();
            if (linha != null) {

                String[] armazena = linha.split(",");
                carta.setNome(armazena[0]);
                carta.setImgPath(armazena[1]);
                carta.nomeAtributo[0] = armazena[2];
                carta.valoresAtributo[0] = Double.valueOf(armazena[3]);

                carta.nomeAtributo[1] = armazena[4];
                carta.valoresAtributo[1] = Double.valueOf(armazena[5]);

                carta.nomeAtributo[2] = armazena[6];
                carta.valoresAtributo[2] = Double.valueOf(armazena[7]);

                ListaCartas.add(carta);
            }
        }
        bufferedReader.close();

        return ListaCartas;
    }

    //----------------------------
}

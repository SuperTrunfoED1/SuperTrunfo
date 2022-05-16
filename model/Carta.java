package model;

import util.Lista;
import util.ListaInterface;

public class Carta {
    
    //----------------------------
    //classe interna
    
    class Atributo{
        String nome;
        Double valor;

        public Atributo(String nome, Double valor){
            setNome(nome);
            setValor(valor);    
        }

        public Atributo(String nome){
            setNome(nome);
            setValor(0.0);    
        }

        public void setNome(String nome) {
            if(nome == null){
                System.out.println("Digita algo!");
            }else if(nome.isBlank()){
                System.out.println("O nome não pode ser apenas um espaço vazio!");
            }else{
                this.nome = nome;
            }
        }
        public void setValor(Double valor) {
            if(valor < 0){
                System.out.println("Valor precisa ser zero ou maior!");
            }else{
                this.valor = valor;
            }
        }
    }

    //----------------------------
    //atributos
    
    String nomeCarta;   
    //usei esse nome na variavel para não confundir com o "name" em Atributos.

    String imgPath;//caminho da imagem do personagem ou objeto da carta
    
    String bgPath;//caminho da imagem de fundo da carta

    String bgColor;//código hexadecimal da cor de fundo da carta

    ListaInterface<Atributo> atributos = new Lista<Atributo>();
    
    //----------------------------
    //construtores

    public Carta(String nomeCarta, String imgPath){  
        setNome(nomeCarta);
        setImgPath(imgPath);       
    }

    public Carta(String nomeCarta){  
        setNome(nomeCarta);  
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

    public String getBgPath() {
        return bgPath;
    }
    
    public void setBgPath(String bgPath) {
        if(bgPath == null){
            System.out.println("Digita algo!");
        }else if(bgPath.isBlank()){
            System.out.println("O path não pode ser apenas um espaço vazio!");
        }else{
            this.bgPath = bgPath;
        }
    }

    public String getBgColor() {
        return bgColor;
    }
    
    public void setBgColor(String bgColor) {
        if(bgColor == null){
            System.out.println("Digita algo!");
        }else if(bgColor.isBlank()){
            System.out.println("O código da cor não pode ser apenas um espaço vazio!");
        }else{
            this.bgColor = bgColor;
        }
    }

    //----------------------------
    //metodos
    
    //----------------------------
}

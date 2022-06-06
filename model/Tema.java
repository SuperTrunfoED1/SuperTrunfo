package model;

import java.io.IOException;

import util.EscritorCSV;
import util.Lista;

public class Tema {

    String nome;
    Long id;
    Lista<Carta> baralho;

    public Tema(String nome, Long id) {
        setNome(nome);
        this.id = id;
        baralho = new Lista<Carta>();
    }

    public Tema(String nome) {
        setNome(nome);
        baralho = new Lista<Carta>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null){
            System.out.println("Digite o nome do tema");
        }else if(nome.isBlank()){
            System.out.println("O nome não pode ser vazio");
        }else{
            this.nome = nome;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id == null){
            System.out.println("E necessário um ID");
        }else if(id < 0){
            System.out.println("deve ser maior que zero");
        }else{
            this.id = id;
        }
    } 
    
    public void adicionarCarta(Carta carta){
        baralho.add(carta);
    }

    public void salvarBaralho() throws IOException{
        EscritorCSV escritor = new EscritorCSV();
        String path = "view/assets/";
        path = path.concat(nome);
        path = path.concat(".txt");
        
        escritor.escrever(path, baralho);
    }
}
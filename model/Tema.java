package model;

import util.Lista;

public class Tema {

    String nome;
    Long id;
    Lista<Carta> baralho;

    public Tema(String nome, Long id) {
        this.nome = nome;
        this.id = id;
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
}
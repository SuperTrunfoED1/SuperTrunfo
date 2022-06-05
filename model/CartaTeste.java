package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CartaTeste {

    // ----------------------------
    // atributos

    String nomeCarta;
    int id;
    int ataque;
    int defesa;
    int poder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public String getNome() {
        return nomeCarta;
    }

    @Override
    public String toString() {
        return id + "," + nomeCarta + "," + ataque + "," + defesa + "," + poder;
    }

    // ----------------------------
    // metodos

    public LinkedList<CartaTeste> ler(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        LinkedList<CartaTeste> ListaCartas = new LinkedList<CartaTeste>();
        String linha = "";

        while (linha != null) {
            linha = bufferedReader.readLine();
            CartaTeste carta = new CartaTeste();
            if (linha != null) {

                String[] armazena = linha.split(",");
                carta.setId(Integer.valueOf(armazena[0]));
                carta.setNomeCarta(armazena[1]);
                carta.setAtaque(Integer.valueOf(armazena[2]));
                carta.setDefesa(Integer.valueOf(armazena[3]));
                carta.setPoder(Integer.valueOf(armazena[4]));

                ListaCartas.add(carta);
            }
        }
        bufferedReader.close();

        return ListaCartas;
    }

    // ----------------------------
}

package model;

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

    // ----------------------------
}

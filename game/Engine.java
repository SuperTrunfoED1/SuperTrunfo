package game;

import java.util.Random;
import model.Carta;
import model.Tema;
import util.Lista;

public class Engine {

    static int fasePontPC0;
    static int fasePontPlayer;
    static int roundWinnedPC;
    static int roundWinnedPlayer;
    static Lista<Carta> baralho;
    static Lista<Carta> cartasPC = null;
    static Lista<Carta> cartasPlayer = null;
    static Tema cenario;
    static boolean[] turnos;

    // ---------------------------
    // Metodos

    public static void iniciar(Lista<Carta> cartas) {

        fasePontPC0 = 0;
        fasePontPlayer = 0;
        roundWinnedPC = 0;
        roundWinnedPlayer = 0;
        cartasPC = new Lista<>();
        cartasPlayer = new Lista<>();

        baralho = cartas;
        Random gerador = new Random();
        int index;

        for (int i = 0; i < 5; i++) {
            index = gerador.nextInt(baralho.size());
            cartasPC.add(baralho.remove(index));

            index = gerador.nextInt(baralho.size());
            cartasPlayer.add(baralho.remove(index));

        }
    }

    public static void escolherAtributo(Carta cartas) {

    }

    public static void escolherCarta(Lista<Carta> cartas) {

    }

    public static boolean comparar(Carta jogador, Carta IA, int atributo) {

        if (jogador.getValoresAtributo()[atributo] > IA.getValoresAtributo()[atributo] ) {
            
            roundWinnedPlayer++;
            fasePontPlayer +=10;
            return true;
        }

        roundWinnedPC++;
        fasePontPC0 +=10;

        return false;
    }

    public static void eliminarCartaDaRodada(Carta cartas) {

    }

    public static void sorteioDeTurnos(Boolean[] carta) {

    }

    // ---------------------------

    public int getFasePontPC0() {
        return fasePontPC0;
    }

    public void setFasePontPC0(int fasePontPC0) {
        this.fasePontPC0 = fasePontPC0;
    }

    public int getFasePontPlayer() {
        return fasePontPlayer;
    }

    public void setFasePontPlayer(int fasePontPlayer) {
        this.fasePontPlayer = fasePontPlayer;
    }

    public int getRoundWinnedPC() {
        return roundWinnedPC;
    }

    public void setRoundWinnedPC(int roundWinnedPC) {
        this.roundWinnedPC = roundWinnedPC;
    }

    public int getRoundWinnedPlayer() {
        return roundWinnedPlayer;
    }

    public void setRoundWinnedPlayer(int roundWinnedPlayer) {
        this.roundWinnedPlayer = roundWinnedPlayer;
    }

    public Lista<Carta> getCartasPC() {
        return cartasPC;
    }

    public void setCartasPC(Lista<Carta> cartasPC) {
        this.cartasPC = cartasPC;
    }

    public Lista<Carta> getCartasPlayer() {
        return cartasPlayer;
    }

    public void setCartasPlayer(Lista<Carta> cartasPlayer) {
        this.cartasPlayer = cartasPlayer;
    }

    public Tema getCenario() {
        return cenario;
    }

    public void setCenario(Tema cenario) {
        this.cenario = cenario;
    }

    public boolean[] getTurnos() {
        return turnos;
    }

    public void setTurnos(boolean[] turnos) {
        this.turnos = turnos;
    }

}
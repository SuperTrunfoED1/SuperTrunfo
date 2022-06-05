package game;

import java.util.List;

import model.Carta;
import model.Tema;

public class engine {

    int fasePontPC0;
    int fasePontPlayer;
    int roundWinnedPC;
    int roundWinnedPlayer;
    List<Carta> cartasPC;
    List<Carta> cartasPlayer;
    Tema cenario;
    boolean[] turnos;

    // ---------------------------
    // Metodos

    public static List<Carta> embaralhar(List<Carta> cartas) {
        return cartas;
    }

    public static void escolherAtributo(Carta cartas) {

    }

    public static void escolherCarta(List<Carta> cartas) {

    }

    public static boolean comparar(Carta jogador, Carta IA) {
        return false;
    }

    public static void eliminarCartaDaRodada(Carta cartas) {

    }

    public static void sorteioDeTurnos(Boolean[] carta){

    }

    //---------------------------

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

    public List<Carta> getCartasPC() {
        return cartasPC;
    }

    public void setCartasPC(List<Carta> cartasPC) {
        this.cartasPC = cartasPC;
    }

    public List<Carta> getCartasPlayer() {
        return cartasPlayer;
    }

    public void setCartasPlayer(List<Carta> cartasPlayer) {
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

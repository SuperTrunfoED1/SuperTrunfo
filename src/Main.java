package src;

import java.io.IOException;

import game.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // classe de teste para os arquivos .fxml
    public static void main(String[] args) {
        launch(args);
    }

    private static Stage pS;

    private static String retorno;

    private static User hanking1;
    private static User hanking2;
    private static User hanking3;


    public static User getHanking1() {
        return hanking1;
    }

    public static void setHanking1(User hanking1) {
        Main.hanking1 = hanking1;
    }

    public static User getHanking2() {
        return hanking2;
    }

    public static void setHanking2(User hanking2) {
        Main.hanking2 = hanking2;
    }

    public static User getHanking3() {
        return hanking3;
    }

    public static void setHanking3(User hanking3) {
        Main.hanking3 = hanking3;
    }

    public static String getRetorno() {
        return retorno;
    }

    public static void setRetorno(String retorno) {
        Main.retorno = retorno;
    }


    public static Stage getpS() {
        return pS;
    }

    public static void setpS(Stage pS) {
        Main.pS = pS;
    }

    @Override
    public void start(Stage pS) throws Exception {
        setpS(pS);
        pS.show();
        telaLogin();
    }

    public static void telaLogin() throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("/view/Login.fxml"));
        Scene cena = new Scene(root);
        pS.setTitle("login");
        pS.setScene(cena);
    }

    public static void telaMainMenu() throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("/view/MainMenu.fxml"));
        Scene cena = new Scene(root);
        pS.setTitle("Menu");
        pS.setScene(cena);
    }

    public static void telaGerador() throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("/view/Gerador.fxml"));
        Scene cena = new Scene(root);
        pS.setTitle("Gerador");
        pS.setScene(cena);
    }

    public static void telaCriarCarta() throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("/view/CriarCartas.fxml"));
        Scene cena = new Scene(root);
        pS.setTitle("Criar Carta");
        pS.setScene(cena);
    }

    public static void telaPartida() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/view/Partida.fxml"));
        Scene cena = new Scene(root);
        pS.setTitle("Partida");
        pS.setScene(cena);
    }

}

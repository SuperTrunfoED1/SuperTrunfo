package controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.User;
import util.Lista;
import view.src.Main;

public class mainMenu implements Initializable {

    @FXML
    private Label NomeJogador;

    @FXML
    private Label NomePrimeiro;

    @FXML
    private Label NomeSegundo;

    @FXML
    private Label NomeTerceiro;

    @FXML
    private Label primeiro;

    @FXML
    private Label segundo;

    @FXML
    private Label terceiro;

    @FXML
    private VBox caixaRanking1;

    @FXML
    private VBox caixaRanking2;

    @FXML
    private VBox caixaRanking3;

    @FXML
    public void receberLogin(String nomeUser) {
        NomeJogador.setText(nomeUser);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());

        User usuario = new User();
        Lista<User> ListaUsuarios;
        ListaUsuarios = usuario.buscarTodos();

        ListaUsuarios = shellSort(ListaUsuarios);
    
        // 1º colocado
        Main.setRanking1(ListaUsuarios.search(0));
        NomePrimeiro.setText(ListaUsuarios.search(0).getNickname());
        primeiro.setText(ListaUsuarios.search(0).getScore().toString() + " Pt");

        // 2º colocado
        Main.setRanking2(ListaUsuarios.size() > 1 ? ListaUsuarios.search(1) : null);
        caixaRanking2.setVisible(ListaUsuarios.size() > 1 ? true : false);
        NomeSegundo.setText(ListaUsuarios.size() > 1 ? ListaUsuarios.search(1).getNickname() : "");
        segundo.setText(ListaUsuarios.size() > 1 ? ListaUsuarios.search(1).getScore().toString() + " Pt" : "");

        // 3º colocado
        Main.setRanking3(ListaUsuarios.size() > 2 ? ListaUsuarios.search(2) : null);
        caixaRanking3.setVisible(ListaUsuarios.size() > 2 ? true : false);
        NomeTerceiro.setText(ListaUsuarios.size() > 2 ? ListaUsuarios.search(2).getNickname() : "");
        terceiro.setText(ListaUsuarios.size() > 2 ? ListaUsuarios.search(2).getScore().toString() + " Pt" : "");

    }

    public static Lista<User> shellSort(Lista<User> usuarios) {

        User usu = new User();
        int h = 1;
        int j = 0;

        while (h < usuarios.size() - 1) {
            h = 3 * h + 1;
        }

        while (h > 1) {
            h = h / 3;
        }

        for (int i = h; i < usuarios.size(); i++) {
            usu = usuarios.search(i);
            j = i - h;

            while ((j >= 0) && (usu.getScore() > usuarios.search(j).getScore())) {

                usuarios.set(j + h, usuarios.search(j));

                j = j - h;

            }
            usuarios.set(j + h, usu);

        }

        return usuarios;

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Main.telaLogin();

    }

    @FXML
    void ComecarPartida(ActionEvent event) throws IOException {
        Main.telaPartida();
    }

    @FXML
    void gerarCartas(ActionEvent event) throws IOException {
        Main.telaGerador();
    }

}

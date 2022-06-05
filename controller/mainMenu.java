package controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    public void receberLogin(String nomeUser) {
        NomeJogador.setText(nomeUser);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());

        User usuario = new User();
        Lista<User> ListaUsuarios = new Lista<User>();
        ListaUsuarios = usuario.buscarTodos();

        int sizeCorreto = ListaUsuarios.size;
        LinkedList<User> listaParaHanking = new LinkedList<>();

        for (int i = 0; i < sizeCorreto; i++) {
            listaParaHanking.add(ListaUsuarios.shift());
        }

        listaParaHanking = shellSort(listaParaHanking);

        // 1º colocado
        Main.setRanking1(listaParaHanking.get(0));

        NomePrimeiro.setText(listaParaHanking.get(0).getNickname());
        primeiro.setText(listaParaHanking.get(0).getScore().toString() + " Pt");

        // 2º colocado
        /*Main.setRanking2(listaParaHanking.get(1));

        NomeSegundo.setText(listaParaHanking.get(1).getNickname());
        segundo.setText(listaParaHanking.get(1).getScore().toString() + " Pt");

        // 3º colocado
        Main.setRanking3(listaParaHanking.get(2));

        NomeTerceiro.setText(listaParaHanking.get(2).getNickname());
        terceiro.setText(listaParaHanking.get(2).getScore().toString() + " Pt");*/

    }

    public static LinkedList<User> shellSort(LinkedList<User> usuarios) {

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
            usu = usuarios.get(i);
            j = i - h;

            while ((j >= 0) && (usu.getScore() > usuarios.get(j).getScore())) {

                usuarios.set(j + h, usuarios.get(j));

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

package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import game.User;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import src.Main;
import util.Lista;
import util.ListaInterface;

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
        this.NomeJogador.setText(nomeUser);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User usuario = new User();
        Lista<User> ListaUsuarios = new Lista<User>();
        
        try {
            ListaUsuarios = usuario.buscarTodos();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int scoreTemp = 0;
        for (int i = 0; i < ListaUsuarios.size; i++) {
        
            if (ListaUsuarios.peekFirst().getScore() > scoreTemp ) {
                usuario = ListaUsuarios.shift();
                scoreTemp = usuario.getScore();
                
            }
        }
         
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

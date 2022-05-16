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
        NomeJogador.setText(nomeUser);
    }

    @Override // 
    public void initialize(URL location, ResourceBundle resources) {
        User usuario = new User();
        Lista<User> ListaUsuarios = new Lista<User>();
        
        
        try {
            ListaUsuarios = usuario.buscarTodos();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Integer scoreTemp = 0;
        Integer scoreTemp2 = 0;
        Integer scoreTemp3 = 0;
        // jeito de ler do arquivo e comparar ?
        for (int i = 0; i < ListaUsuarios.size; i++) {
        
            if (ListaUsuarios.peekFirst().getScore() > scoreTemp ) {
                usuario = ListaUsuarios.shift();
                scoreTemp = usuario.getScore();
                
                NomePrimeiro.setText(usuario.getNickname().toString());
                primeiro.setText(scoreTemp.toString());  // colcoando valor que foi lido                
            }

            if (ListaUsuarios.peekFirst().getScore() > scoreTemp ) {
                usuario = ListaUsuarios.shift();
                scoreTemp = usuario.getScore();
        
                NomeSegundo.setText(usuario.getNickname().toString());
                segundo.setText(scoreTemp.toString());                
            }

            if (ListaUsuarios.peekFirst().getScore() > scoreTemp ) {
                usuario = ListaUsuarios.shift();
                scoreTemp = usuario.getScore();

                NomeTerceiro.setText(usuario.getNickname().toString());
                terceiro.setText(scoreTemp.toString());                
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

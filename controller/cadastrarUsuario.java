package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;
import util.EscritorCSV;
import util.Lista;
import util.ListaInterface;
import view.src.Main;

public class cadastrarUsuario {

    @FXML
    private Label msgIncorreto;

    @FXML
    private PasswordField repitaSenha;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField usuario;

    @FXML
    void cadastrar(ActionEvent event) throws IOException {

        EscritorCSV escritor = new EscritorCSV();
        ListaInterface<User> lista = new Lista<User>();
        ListaInterface<User> jaExiste = new Lista<User>();

        User user = new User();

        if (!usuario.getText().isBlank()) {

            User testeIgual = new User();
            user.setNickname(usuario.getText());

            jaExiste = user.ler("view/assets/Usuarios.txt");
            testeIgual = jaExiste.search(user);

            if (testeIgual == null) {

                if (senha.getText().equals(repitaSenha.getText())) {

                    user.setSenha(senha.getText());

                    lista.add(user);

                    escritor.escrever("view/assets/Usuarios.txt", lista);

                    Main.setRetorno(user.getNickname());
                    Main.telaMainMenu();

                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erro");
                    alert.setHeaderText("SENHAS DIFERENTES");
                    alert.setContentText("Senha e Repita Senha devem ser iguais");
                    alert.show();

                }

            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("ESSE NICKNAME JA EXISTE");
                alert.setContentText("Tente novamente com um nome de usuario diferente");
                alert.show();

                usuario.requestFocus();
                usuario.clear();
                senha.clear();
                repitaSenha.clear();
            }

        }
    }

}
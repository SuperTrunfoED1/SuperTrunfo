package controller;

import java.io.IOException;

import game.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.EscritorCSV;
import util.Lista;
import util.ListaInterface;

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

            jaExiste = user.ler("Usuarios.txt");
            testeIgual = jaExiste.search(user);

            if (testeIgual == null) {

                if (senha.getText().equals(repitaSenha.getText())) {

                    System.out.println("erro aqui");
                    user.setSenha(senha.getText());

                    lista.add(user);

                    escritor.escrever("Usuarios.txt", lista);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText("CADASTRADO");
                    alert.setContentText("Agora é so logar");
                    alert.show();

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
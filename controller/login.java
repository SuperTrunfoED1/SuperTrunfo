package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.User;
import view.src.Main;

public class login {

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonEntrar;

    @FXML
    private Label msgIncorreto;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField usuario;

    private int testEntrada;

    @FXML
    void autenticar(ActionEvent event) throws IOException {

        Main.setRetorno(usuario.getText());

        User user = new User();
        user.setNickname(usuario.getText());
        user.setSenha(senha.getText());

        if (user.autenticar(user)) {

            Main.telaMainMenu();

        } else {
            msgIncorreto.setVisible(true);

            usuario.requestFocus();
            usuario.clear();
            senha.clear();

            testEntrada++;

            if (testEntrada > 2) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("Erros consecutivos");
                alert.setContentText("Se for novo usuario, clique em cadastrar-se");
                alert.show();
            }

        }
    }

    @FXML
    void cadastrar(ActionEvent event) throws IOException {

        Stage stg = new Stage();
        Parent cadastro = FXMLLoader.load(getClass().getResource("/view/CadastrarUsuario.fxml"));
        Scene cena = new Scene(cadastro);
        stg.setScene(cena);
        stg.setTitle("Cadastrar");
        stg.show();

    }

    @FXML
    void usuarioKey(KeyEvent event) {
        usuario.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    senha.requestFocus();

                }
            }
        });
    }

}

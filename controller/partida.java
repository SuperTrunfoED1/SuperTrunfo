package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.src.Main;

public class partida implements Initializable {

    @FXML
    private Label NomeJogador;

    @FXML
    private Label SelectAtributo1;

    @FXML
    private Label SelectAtributo2;

    @FXML
    private Label SelectAtributo3;

    @FXML
    private Label SelectIA1;

    @FXML
    private Label SelectIA2;

    @FXML
    private Label SelectIA3;

    @FXML
    private Label VS;

    @FXML
    private Label card1Atributo1;

    @FXML
    private Label card1Atributo2;

    @FXML
    private Label card1Atributo3;

    @FXML
    private Label card2Atributo1;

    @FXML
    private Label card2Atributo2;

    @FXML
    private Label card2Atributo3;

    @FXML
    private Label card3Atributo1;

    @FXML
    private Label card3Atributo2;

    @FXML
    private Label card3Atributo3;

    @FXML
    private Label card4Atributo1;

    @FXML
    private Label card4Atributo2;

    @FXML
    private Label card4Atributo3;

    @FXML
    private ImageView imgCard1;

    @FXML
    private ImageView imgCard2;

    @FXML
    private ImageView imgCard3;

    @FXML
    private ImageView imgCard4;

    @FXML
    private Label pontos_ia;

    @FXML
    private Label pontos_jogador;

    @FXML
    private Label rodada;

    @FXML
    private ImageView selectimgCard;

    @FXML
    private ImageView selectimgCardIA;

    @FXML
    private Label turno;

    @FXML
    void sair(ActionEvent event) throws IOException {
        Main.telaMainMenu();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());
        pontos_ia.setText("0");
        pontos_jogador.setText("0"); 

        Image im = new Image("view/assets/ImagensCards/Naruto.png");
        Image im2 = new Image("view/assets/ImagensCards/Kakashi.png");
        Image im3 = new Image("view/assets/ImagensCards/Jiraya.png");
        Image im4 = new Image("view/assets/ImagensCards/Zabusa.png");

        imgCard1.setImage(im);
        imgCard2.setImage(im2);
        imgCard3.setImage(im3);
        imgCard4.setImage(im4);

           

    }
}

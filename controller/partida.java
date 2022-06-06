package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import game.Engine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Carta;
import util.Lista;
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

        Engine partida = new Engine();
        Carta cartas = new Carta();
        Lista<Carta> listaCartas = new Lista<>();
        try {
            listaCartas = cartas.ler("view/assets/baralhoNaruto.txt");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        partida.iniciar(listaCartas);

        listaCartas = partida.getCartasPlayer();
       
        //1º Carta
        imgCard1.setImage(pathImg(listaCartas.search(0).getImgPath(), listaCartas.search(0).getNome()));
        card1Atributo1.setText(listaCartas.search(0).getNomeAtributo()[0]+": "+listaCartas.search(0).getValoresAtributo()[0]);
        card1Atributo2.setText(listaCartas.search(0).getNomeAtributo()[1]+": "+listaCartas.search(0).getValoresAtributo()[1]);
        card1Atributo3.setText(listaCartas.search(0).getNomeAtributo()[2]+": "+listaCartas.search(0).getValoresAtributo()[2]);

        //2º Carta
        imgCard2.setImage(pathImg(listaCartas.search(1).getImgPath(), listaCartas.search(1).getNome()));
        card2Atributo1.setText(listaCartas.search(1).getNomeAtributo()[0]+": "+listaCartas.search(1).getValoresAtributo()[0]);
        card2Atributo2.setText(listaCartas.search(1).getNomeAtributo()[1]+": "+listaCartas.search(1).getValoresAtributo()[1]);
        card2Atributo3.setText(listaCartas.search(1).getNomeAtributo()[2]+": "+listaCartas.search(1).getValoresAtributo()[2]);

        //3º Carta
        imgCard3.setImage(pathImg(listaCartas.search(2).getImgPath(), listaCartas.search(2).getNome()));
        card3Atributo1.setText(listaCartas.search(2).getNomeAtributo()[0]+": "+listaCartas.search(2).getValoresAtributo()[0]);
        card3Atributo2.setText(listaCartas.search(2).getNomeAtributo()[1]+": "+listaCartas.search(2).getValoresAtributo()[1]);
        card3Atributo3.setText(listaCartas.search(2).getNomeAtributo()[2]+": "+listaCartas.search(2).getValoresAtributo()[2]);
        
        //4º Carta
        imgCard4.setImage(pathImg(listaCartas.search(3).getImgPath(), listaCartas.search(3).getNome()));
        card4Atributo1.setText(listaCartas.search(3).getNomeAtributo()[0]+": "+listaCartas.search(3).getValoresAtributo()[0]);
        card4Atributo2.setText(listaCartas.search(3).getNomeAtributo()[1]+": "+listaCartas.search(3).getValoresAtributo()[1]);
        card4Atributo3.setText(listaCartas.search(3).getNomeAtributo()[2]+": "+listaCartas.search(3).getValoresAtributo()[2]);

        

        

    }

    public static Image pathImg(String path,String nome) {
        String png = ".png";
        Image im = new Image(path + nome + png);

        return im;
    }
}

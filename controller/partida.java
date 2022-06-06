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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private Label winIA;

    @FXML
    private Label winJogador;

    @FXML
    private Pane paneSeletorAtributo;

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

        // cartas sortiadas para o Usuario
        Lista<Carta> maoIA = partida.getCartasPlayer();

        // cartas sortiadas para o Usuario
        Lista<Carta> maoJogador = partida.getCartasPlayer();
       
        //1º Carta
        imgCard1.setImage(pathImg(maoJogador.search(0).getImgPath(), maoJogador.search(0).getNome()));
        card1Atributo1.setText(maoJogador.search(0).getNomeAtributo()[0]+": "+maoJogador.search(0).getValoresAtributo()[0]);
        card1Atributo2.setText(maoJogador.search(0).getNomeAtributo()[1]+": "+maoJogador.search(0).getValoresAtributo()[1]);
        card1Atributo3.setText(maoJogador.search(0).getNomeAtributo()[2]+": "+maoJogador.search(0).getValoresAtributo()[2]);

        //2º Carta
        imgCard2.setImage(pathImg(maoJogador.search(1).getImgPath(), maoJogador.search(1).getNome()));
        card2Atributo1.setText(maoJogador.search(1).getNomeAtributo()[0]+": "+maoJogador.search(1).getValoresAtributo()[0]);
        card2Atributo2.setText(maoJogador.search(1).getNomeAtributo()[1]+": "+maoJogador.search(1).getValoresAtributo()[1]);
        card2Atributo3.setText(maoJogador.search(1).getNomeAtributo()[2]+": "+maoJogador.search(1).getValoresAtributo()[2]);

        //3º Carta
        imgCard3.setImage(pathImg(maoJogador.search(2).getImgPath(), maoJogador.search(2).getNome()));
        card3Atributo1.setText(maoJogador.search(2).getNomeAtributo()[0]+": "+maoJogador.search(2).getValoresAtributo()[0]);
        card3Atributo2.setText(maoJogador.search(2).getNomeAtributo()[1]+": "+maoJogador.search(2).getValoresAtributo()[1]);
        card3Atributo3.setText(maoJogador.search(2).getNomeAtributo()[2]+": "+maoJogador.search(2).getValoresAtributo()[2]);
        
        //4º Carta
        imgCard4.setImage(pathImg(maoJogador.search(3).getImgPath(), maoJogador.search(3).getNome()));
        card4Atributo1.setText(maoJogador.search(3).getNomeAtributo()[0]+": "+maoJogador.search(3).getValoresAtributo()[0]);
        card4Atributo2.setText(maoJogador.search(3).getNomeAtributo()[1]+": "+maoJogador.search(3).getValoresAtributo()[1]);
        card4Atributo3.setText(maoJogador.search(3).getNomeAtributo()[2]+": "+maoJogador.search(3).getValoresAtributo()[2]);

        //Total de rodadas ganhas pelo Usuario
        winJogador.setText( String.valueOf(partida.getRoundWinnedPlayer()));
        //Total de rodadas ganhas pelo IA
        winIA.setText( String.valueOf(partida.getRoundWinnedPC()));

        //Total de pontos ganhos nas rodadas pelo Usuario
        pontos_jogador.setText( String.valueOf(partida.getFasePontPlayer()));

        //Total de pontos ganhos nas rodadas pelo PC
        pontos_ia.setText( String.valueOf(partida.getFasePontPC0()));





    }

    public static Image pathImg(String path,String nome) {
        String png = ".png";
        Image im = new Image(path + nome + png);

        return im;
    }


    @FXML
    void clickCard1(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);
    }

    @FXML
    void clickCard2(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);

    }

    @FXML
    void clickCard3(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);

    }

    @FXML
    void clickCard4(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);

    }

}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import game.Engine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label nomeCardSelect;

    @FXML
    private Label nomeCardSelectIA;

    @FXML
    private Pane paneCardIA;

    @FXML
    private Pane paneSeletorAtributo;

    @FXML
    private Label pontos_ia;

    @FXML
    private Label pontos_jogador;

    @FXML
    private Button proximaPart;

    @FXML
    private Label rodada;

    @FXML
    private ImageView selectimgCard;

    @FXML
    private ImageView selectimgCardIA;

    @FXML
    private Label winIA;

    @FXML
    private Label winJogador;

    @FXML
    private Pane disibleCard1;

    @FXML
    private Pane disibleCard2;

    @FXML
    private Pane disibleCard3;

    @FXML
    private Pane disibleCard4;

    @FXML
    private Label nomeVencedor;
    
    @FXML
    private Label WIN;


    @FXML
    void sair(ActionEvent event) throws IOException {
        Main.telaMainMenu();
    }

    @FXML
    void proximaPartida(ActionEvent event) throws IOException {
        
        paneSeletorAtributo.setVisible(false);
        paneCardIA.setVisible(false);
        
        VS.setVisible(false);
        
        proximaPart.setVisible(false);

        SelectIA1.setDisable(false);
        SelectIA2.setDisable(false);
        SelectIA3.setDisable(false);

        nomeVencedor.setVisible(false);
        WIN.setVisible(false);

        pontos_ia.setText(String.valueOf(partida.getFasePontPC0()));
        pontos_jogador.setText(String.valueOf(partida.getFasePontPlayer()));

        winIA.setText(String.valueOf(partida.getRoundWinnedPC()));
        winJogador.setText(String.valueOf(partida.getRoundWinnedPlayer()));

        rodada.setText(String.valueOf(partida.getRoundWinnedPC()+partida.getRoundWinnedPlayer()));


        

    }

    static Engine partida = null;
    static Carta cartas = null;
    static Carta cartaSelecionadaUsuario = null;
    static Lista<Carta> listaCartas = null;
    static Lista<Carta> maoJogador = null;
    static Lista<Carta> maoIA = null;
    static int sorteioIA;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partida = new Engine();
        cartas = new Carta();
        cartaSelecionadaUsuario = new Carta();
        listaCartas = new Lista<Carta>();
        maoJogador = new Lista<>();
        maoIA = new Lista<>();
        sorteioIA = 4;

        NomeJogador.setText(Main.getRetorno());

        try {
            listaCartas = cartas.ler("view/assets/baralhoNaruto.txt");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        partida.iniciar(listaCartas);

        // cartas sortiadas para o Usuario
        maoJogador = partida.getCartasPlayer();
        maoIA = partida.getCartasPC();

       
        //1?? Carta
        imgCard1.setImage(pathImg(maoJogador.search(0).getUrl(), maoJogador.search(0).getNome()));
        card1Atributo1.setText(maoJogador.search(0).getNomeAtributo()[0]+": "+maoJogador.search(0).getValoresAtributo()[0]);
        card1Atributo2.setText(maoJogador.search(0).getNomeAtributo()[1]+": "+maoJogador.search(0).getValoresAtributo()[1]);
        card1Atributo3.setText(maoJogador.search(0).getNomeAtributo()[2]+": "+maoJogador.search(0).getValoresAtributo()[2]);

        //2?? Carta
        imgCard2.setImage(pathImg(maoJogador.search(1).getUrl(), maoJogador.search(1).getNome()));
        card2Atributo1.setText(maoJogador.search(1).getNomeAtributo()[0]+": "+maoJogador.search(1).getValoresAtributo()[0]);
        card2Atributo2.setText(maoJogador.search(1).getNomeAtributo()[1]+": "+maoJogador.search(1).getValoresAtributo()[1]);
        card2Atributo3.setText(maoJogador.search(1).getNomeAtributo()[2]+": "+maoJogador.search(1).getValoresAtributo()[2]);

        //3?? Carta
        imgCard3.setImage(pathImg(maoJogador.search(2).getUrl(), maoJogador.search(2).getNome()));
        card3Atributo1.setText(maoJogador.search(2).getNomeAtributo()[0]+": "+maoJogador.search(2).getValoresAtributo()[0]);
        card3Atributo2.setText(maoJogador.search(2).getNomeAtributo()[1]+": "+maoJogador.search(2).getValoresAtributo()[1]);
        card3Atributo3.setText(maoJogador.search(2).getNomeAtributo()[2]+": "+maoJogador.search(2).getValoresAtributo()[2]);
        
        //4?? Carta
        imgCard4.setImage(pathImg(maoJogador.search(3).getUrl(), maoJogador.search(3).getNome()));
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
        disibleCard1.setDisable(true);
        nomeCardSelect.setText(maoJogador.search(0).getNome());
        selectimgCard.setImage(pathImg(maoJogador.search(0).getUrl(), maoJogador.search(0).getNome()));
        SelectAtributo1.setText(maoJogador.search(0).getNomeAtributo()[0]+": "+maoJogador.search(0).getValoresAtributo()[0]);
        SelectAtributo2.setText(maoJogador.search(0).getNomeAtributo()[1]+": "+maoJogador.search(0).getValoresAtributo()[1]);
        SelectAtributo3.setText(maoJogador.search(0).getNomeAtributo()[2]+": "+maoJogador.search(0).getValoresAtributo()[2]);
        cartaSelecionadaUsuario = maoJogador.search(0);
    }

    @FXML
    void clickCard2(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);
        disibleCard2.setDisable(true);
        nomeCardSelect.setText(maoJogador.search(1).getNome());
        selectimgCard.setImage(pathImg(maoJogador.search(1).getUrl(), maoJogador.search(1).getNome()));
        SelectAtributo1.setText(maoJogador.search(1).getNomeAtributo()[0]+": "+maoJogador.search(1).getValoresAtributo()[0]);
        SelectAtributo2.setText(maoJogador.search(1).getNomeAtributo()[1]+": "+maoJogador.search(1).getValoresAtributo()[1]);
        SelectAtributo3.setText(maoJogador.search(1).getNomeAtributo()[2]+": "+maoJogador.search(1).getValoresAtributo()[2]);
        cartaSelecionadaUsuario = maoJogador.search(1);

    }

    @FXML
    void clickCard3(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);
        disibleCard3.setDisable(true);
        nomeCardSelect.setText(maoJogador.search(2).getNome());
        selectimgCard.setImage(pathImg(maoJogador.search(2).getUrl(), maoJogador.search(2).getNome()));
        SelectAtributo1.setText(maoJogador.search(2).getNomeAtributo()[0]+": "+maoJogador.search(2).getValoresAtributo()[0]);
        SelectAtributo2.setText(maoJogador.search(2).getNomeAtributo()[1]+": "+maoJogador.search(2).getValoresAtributo()[1]);
        SelectAtributo3.setText(maoJogador.search(2).getNomeAtributo()[2]+": "+maoJogador.search(2).getValoresAtributo()[2]);
        cartaSelecionadaUsuario = maoJogador.search(2);

    }

    @FXML
    void clickCard4(MouseEvent event) {
        paneSeletorAtributo.setVisible(true);
        disibleCard4.setDisable(true);

        nomeCardSelect.setText(maoJogador.search(3).getNome());
        selectimgCard.setImage(pathImg(maoJogador.search(3).getUrl(), maoJogador.search(3).getNome()));
        SelectAtributo1.setText(maoJogador.search(3).getNomeAtributo()[0]+": "+maoJogador.search(3).getValoresAtributo()[0]);
        SelectAtributo2.setText(maoJogador.search(3).getNomeAtributo()[1]+": "+maoJogador.search(3).getValoresAtributo()[1]);
        SelectAtributo3.setText(maoJogador.search(3).getNomeAtributo()[2]+": "+maoJogador.search(3).getValoresAtributo()[2]);
        cartaSelecionadaUsuario = maoJogador.search(3);

    }

    @FXML
    void clickAtributo1(MouseEvent event) {
        
        paneCardIA.setVisible(true);
        VS.setVisible(true);
        proximaPart.setVisible(true);

        Random sorteio = new Random();
        int sorteado = sorteio.nextInt(sorteioIA);
        sorteioIA--;

        nomeCardSelectIA.setText(maoIA.search(sorteado).getNome());
        selectimgCardIA.setImage(pathImg(maoIA.search(sorteado).getUrl(), maoIA.search(sorteado).getNome()));
        SelectIA1.setText(maoIA.search(sorteado).getNomeAtributo()[0]+": "+maoIA.search(sorteado).getValoresAtributo()[0]);
        SelectIA2.setText(maoIA.search(sorteado).getNomeAtributo()[1]+": "+maoIA.search(sorteado).getValoresAtributo()[1]);
        SelectIA3.setText(maoIA.search(sorteado).getNomeAtributo()[2]+": "+maoIA.search(sorteado).getValoresAtributo()[2]);
        SelectIA2.setDisable(true);
        SelectIA3.setDisable(true);

        boolean compara = partida.comparar(cartaSelecionadaUsuario,maoIA.search(sorteado), 0);

        if (compara) {
            nomeVencedor.setVisible(true);
            nomeVencedor.setText(NomeJogador.getText());
            WIN.setVisible(true);
        }else{
            nomeVencedor.setVisible(true);
            nomeVencedor.setText("I.A.");
            WIN.setVisible(true);
        }
        maoIA.remove(sorteado);

    

    }

    @FXML
    void clickAtributo2(MouseEvent event) {

        paneCardIA.setVisible(true);
        VS.setVisible(true);
        proximaPart.setVisible(true);

        Random sorteio = new Random();
        int sorteado = sorteio.nextInt(sorteioIA);
        sorteioIA--;

        nomeCardSelectIA.setText(maoIA.search(sorteado).getNome());
        selectimgCardIA.setImage(pathImg(maoIA.search(sorteado).getUrl(), maoIA.search(sorteado).getNome()));
        SelectIA1.setText(maoIA.search(sorteado).getNomeAtributo()[0]+": "+maoIA.search(sorteado).getValoresAtributo()[0]);
        SelectIA2.setText(maoIA.search(sorteado).getNomeAtributo()[1]+": "+maoIA.search(sorteado).getValoresAtributo()[1]);
        SelectIA3.setText(maoIA.search(sorteado).getNomeAtributo()[2]+": "+maoIA.search(sorteado).getValoresAtributo()[2]);
        SelectIA1.setDisable(true);
        SelectIA3.setDisable(true);

        boolean compara = partida.comparar(cartaSelecionadaUsuario,maoIA.search(sorteado), 1);

        if (compara) {
            nomeVencedor.setVisible(true);
            nomeVencedor.setText(NomeJogador.getText());
            WIN.setVisible(true);
        }else{
            nomeVencedor.setVisible(true);
            nomeVencedor.setText("I.A.");
            WIN.setVisible(true);
        }
        maoIA.remove(sorteado);
        

    }

    @FXML
    void clickAtributo3(MouseEvent event) {
       
        paneCardIA.setVisible(true);
        VS.setVisible(true);
        proximaPart.setVisible(true);

        Random sorteio = new Random();
        int sorteado = sorteio.nextInt(sorteioIA);
        sorteioIA--;

        nomeCardSelectIA.setText(maoIA.search(sorteado).getNome());
        selectimgCardIA.setImage(pathImg(maoIA.search(sorteado).getUrl(), maoIA.search(sorteado).getNome()));
        SelectIA1.setText(maoIA.search(sorteado).getNomeAtributo()[0]+": "+maoIA.search(sorteado).getValoresAtributo()[0]);
        SelectIA2.setText(maoIA.search(sorteado).getNomeAtributo()[1]+": "+maoIA.search(sorteado).getValoresAtributo()[1]);
        SelectIA3.setText(maoIA.search(sorteado).getNomeAtributo()[2]+": "+maoIA.search(sorteado).getValoresAtributo()[2]);
        SelectIA1.setDisable(true);
        SelectIA2.setDisable(true);

        boolean compara = partida.comparar(cartaSelecionadaUsuario,maoIA.search(sorteado), 2);

        if (compara) {
            nomeVencedor.setVisible(true);
            nomeVencedor.setText(NomeJogador.getText());
            WIN.setVisible(true);
        }else{
            nomeVencedor.setVisible(true);
            nomeVencedor.setText("I.A.");
            WIN.setVisible(true);
        }
        maoIA.remove(sorteado);

    }

}

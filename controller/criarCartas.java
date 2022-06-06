package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Carta;
import model.Tema;
import view.src.Main;

public class criarCartas {

    @FXML
    private ImageView imagemCarta;

    @FXML
    private Label nomeCarta;

    @FXML
    private TextArea valor1;

    @FXML
    private TextField inputNome;

    @FXML
    private TextArea valor3;

    @FXML
    private TextArea valor2;

    @FXML
    private TextArea atributo1;

    @FXML
    private TextField nomeTema;

    @FXML
    private TextArea atributo3;

    @FXML
    private TextArea atributo2;

    private String imgPath;

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.telaGerador();
    }

    @FXML
    public void selectFoto (ActionEvent e) {
    
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setCurrentDirectory(new File("C:\\Users"));
        //int response = filechooser.showOpenDialog(null); //select file to open
        int response = fileChooser.showSaveDialog(null); //select file to save
       
        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);

            imgPath = file.getPath();
            
            try {
                BufferedImage bImage = ImageIO.read(file); 
                Image imagem = SwingFXUtils.toFXImage(bImage, null);

                imagemCarta.setImage(imagem);
            } catch (IOException ea) {
                //TODO: handle exception
                ea.getStackTrace();
            }
        }
    }

    @FXML
    void digitarNome(ActionEvent event) {
        nomeCarta.setText(inputNome.getText());
    }

    @FXML
    public void salvarCarta(ActionEvent event) throws IOException{
        Tema baralho = new Tema(nomeTema.getText());
        Carta carta = new Carta();

        Image imgTMP = new Image(imgPath);
        
        //settando carta. . .
        carta.setNome(inputNome.getText());
        carta.setImgPath(imgTMP);
        
        String [] nomesAtributos = { 
            atributo1.getText(), 
            atributo2.getText(), 
            atributo3.getText() 
        };

        Double [] valoresAtributos = { 
            Double.valueOf(valor1.getText()), 
            Double.valueOf(valor2.getText()), 
            Double.valueOf(valor3.getText()) 
        };

        carta.setNomeAtributo(nomesAtributos);
        carta.setValoresAtributo(valoresAtributos);
        //---------------------------
        
        baralho.adicionarCarta(carta);

        baralho.salvarBaralho();
        Main.telaGerador();
    }
}

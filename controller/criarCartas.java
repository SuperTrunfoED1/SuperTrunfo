package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.src.Main;

public class criarCartas {

    @FXML
    private ImageView imagemCarta;

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
}

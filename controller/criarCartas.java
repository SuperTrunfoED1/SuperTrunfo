package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.src.Main;

public class criarCartas {

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
        }
    }
}

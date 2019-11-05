package br.com.projetoLP.controller;

import br.com.projetoLP.Main;
import br.com.projetoLP.model.enumeration.ScreenType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Main.onChangeScreen {

    @FXML
    private ResourceBundle resources;
=======
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ResultController implements Main.onChangeScreen {

    @FXML private Button btVoltarResult;
    @FXML private Label lblResult;
    @FXML private ImageView imagemSelecionada;

    @FXML
    void initialize()
    {

    }
    @Override
    public void onScreenChanged(ScreenType screen, Object userData) {
>>>>>>> 67072875c978343e73034797716c0a3382272bb7

    @FXML
    private URL location;

    @FXML
    private Button btVoltarResult;

    @FXML
    private ImageView image;

    @FXML
    private Label Resultado;

    private Boolean hasPerson;

    @FXML
    void voltarScreen(ActionEvent event) {
        Main.changeScreen(ScreenType.mainSreen);
    }


    @FXML
    void initialize() {
        assert btVoltarResult != null : "fx:id=\"btVoltarResult\" was not injected: check your FXML file 'resultScreen.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'resultScreen.fxml'.";
        Main.addOnChangeScreenOnListeners(this);
    }


    @Override
    public void onScreenChanged(ScreenType screen, Object... userData) {
        if (ScreenType.resultSreen == screen){
            System.out.println("Foi aqui");
            File img = new File((String)userData[0]);
            image.setImage(new Image(img.toURI().toString()));
            hasPerson = (Boolean)userData[1];
            Resultado.setText(hasPerson.toString());
            Resultado.setAlignment(Pos.CENTER);
        }
    }
}
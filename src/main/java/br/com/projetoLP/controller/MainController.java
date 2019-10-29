package br.com.projetoLP.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.projetoLP.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import br.com.projetoLP.model.ScreenType;
import javafx.scene.input.InputMethodEvent;

public class MainController implements Main.onChangeScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button VerificarButtom;

    @FXML
    private Button CancelarButton;

    @FXML
    private TextField CaminhoDaImagem;

    @FXML
    void initialize() {
        assert VerificarButtom != null : "fx:id=\"VerificarButtom\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CancelarButton != null : "fx:id=\"CancelarButton\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CaminhoDaImagem != null : "fx:id=\"CaminhoDaImagem\" was not injected: check your FXML file 'MainScreen.fxml'.";
    }

    @Override
    public void onScreenChanged(ScreenType screen, Object userData) {

    }

    public void startOperation(ActionEvent event) {
        String str = CaminhoDaImagem.getText();
        System.out.println(str);
    }
}


package br.com.projetoLP.controller;

import br.com.projetoLP.Main;
import br.com.projetoLP.model.enumeration.ScreenType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    }

    public void voltarScreen(ActionEvent event) {
        Main.changeScreen(ScreenType.mainSreen);
    }
}

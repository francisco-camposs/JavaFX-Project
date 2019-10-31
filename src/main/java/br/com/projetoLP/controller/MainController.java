package br.com.projetoLP.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.projetoLP.Main;
import br.com.projetoLP.model.*;
import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.HogExtract;
import br.com.projetoLP.model.image.ProcessedImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * The type Main controller.
 */
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
    private Button SobreButton;

    @FXML
    private TextField CaminhoDaImagem;

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert VerificarButtom != null : "fx:id=\"VerificarButtom\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CancelarButton != null : "fx:id=\"CancelarButton\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CaminhoDaImagem != null : "fx:id=\"CaminhoDaImagem\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert SobreButton != null : "fx:id=\"SobreButton\" was not injected: check your FXML file 'MainScreen.fxml'.";
    }

    @Override
    public void onScreenChanged(ScreenType screen, Object userData) {

    }

    /**
     * Ação do botão 'verificar' ao ser clicado
     *
     * @param event Evento do botão
     */
    public void startOperation(ActionEvent event) {

        // Lê o conteúdo do arquivo.
        CsvReader csv = new CsvReader("data/dataset_2019_1.csv");
        AllImage allImage = new AllImage();
        ProcessedImage image = new ProcessedImage();
        csv.searchFile();
        csv.read(allImage);

        HogExtract hogExtract = new HogExtract();
        try {
            hogExtract.extract(CaminhoDaImagem.getText(), image);
        } catch (NullPointerException ex){
            System.out.println("Caminho não encontrado.");
        }catch (Exception ex){
            return;
        }
        String str = CaminhoDaImagem.getText();
        CaminhoDaImagem.clear();
    }

    /**
     * Ação do botão 'cancelar' ao ser clicado
     *
     * @param event Evento do botão
     */
    public void btCancelarMain(ActionEvent event) {
        System.out.println("Botão cancelar clicado");
    }

    /**
     * Search archive.
     *
     * @param mouseEvent the mouse event
     */
    public void SearchArchive(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files ...","*.png", "*.jpeg","*.jpg");

        fileChooser.getExtensionFilters().add(extFilter);

        File fix = fileChooser.showOpenDialog(Main.getStage());
        try {
            CaminhoDaImagem.setText(fix.getAbsolutePath());
        } catch (NullPointerException ex){
            CaminhoDaImagem.setText("");
        }

    }

    public void btSobreMain(ActionEvent event) {
        Alert dialogSobre = new Alert(Alert.AlertType.INFORMATION);
        dialogSobre.setTitle("Sobre");
        dialogSobre.setHeaderText("TESTE");
        dialogSobre.setContentText("Francisco\nAlexandre");
        dialogSobre.setResizable(false);
        dialogSobre.showAndWait();
        /*SobreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(Main.getStage());
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });

         */
    }
}


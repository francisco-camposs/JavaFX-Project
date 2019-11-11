package br.com.projetoLP.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.projetoLP.Main;
import br.com.projetoLP.model.*;
import br.com.projetoLP.model.enumeration.DistanceType;
import br.com.projetoLP.model.enumeration.ScreenType;
import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.HogExtract;
import br.com.projetoLP.model.image.ProcessedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The type Main controller.
 */
public class MainController implements Main.onChangeScreen {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button VerificarButtom;
    @FXML private Button CancelarButton;
    @FXML private Button SobreButton;
    @FXML private RadioButton chebychev;
    @FXML private RadioButton manhattan;
    @FXML private RadioButton euclidiana;
    @FXML private ImageView imagemCalculo;
    @FXML private Button btOk;
    @FXML private Alert alert;
    @FXML private TextField CaminhoDaImagem;

    private DistanceType TIPO_DISTANCIA = DistanceType.CHEBYCHEV;
    private Stage stageDialog;
    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert VerificarButtom != null : "fx:id=\"VerificarButtom\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CancelarButton != null : "fx:id=\"CancelarButton\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert CaminhoDaImagem != null : "fx:id=\"CaminhoDaImagem\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert SobreButton != null : "fx:id=\"SobreButton\" was not injected: check your FXML file 'MainScreen.fxml'.";
        Main.addOnChangeScreenOnListeners(this);
    }

    @Override
    public void onScreenChanged(ScreenType screen, Object ... userData) {

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

            Alert alertV = new Alert(Alert.AlertType.INFORMATION);
            alertV.setTitle("Erro");
            alertV.setHeaderText("Imagem não encontrada");
            alertV.setContentText("Nenhuma imagem foi encontrada no diretório selecionado");
            alertV.setResizable(false);
            alertV.showAndWait();

        }catch (Exception ex){
            Alert alertV = new Alert(Alert.AlertType.INFORMATION);
            alertV.setTitle("Erro");
            System.out.println("Mas rapaz");
            alertV.setHeaderText("Imagem não encontrada");
            alertV.setContentText("Você precisa escolher alguma imagem");
            alertV.setResizable(false);
            alertV.showAndWait();
            return;
        }

        KNN knn = new KNN(allImage, image, TIPO_DISTANCIA);
        knn.calcularDistancia();
        Boolean tmp = knn.hasPerson();

        String str = CaminhoDaImagem.getText();
        Main.changeScreen(ScreenType.resultSreen, CaminhoDaImagem.getText(),tmp);
        CaminhoDaImagem.clear();
        Main.addOnChangeScreenOnListeners(this);
    }

    /**
     * Ação do botão 'cancelar' ao ser clicado
     *
     * @param event Evento do botão
     */
    public  void btAjuda(ActionEvent event) throws Exception {
        System.out.println("Botão Ajuda");

        stageDialog = new Stage();
        stageDialog.setTitle("Ajuda");
        URL urlAjudaScreen = new File("src/main/java/br/com/projetoLP/view/DialogAboutScreen.fxml").toURI().toURL();
        Parent FXMLAjudaScreen = FXMLLoader.load(urlAjudaScreen);
        Scene AjudaScreen = new Scene(FXMLAjudaScreen, 400, 250);

        stageDialog.setScene(AjudaScreen);
        stageDialog.show();
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

    public void btSobre(ActionEvent event) throws Exception {
        stageDialog = new Stage();
        stageDialog.setTitle("Sobre");
        URL urlSobreScreen = new File("src/main/java/br/com/projetoLP/view/DialogSobreScreen.fxml").toURI().toURL();
        Parent FXMLSobreScreen = FXMLLoader.load(urlSobreScreen);
        Scene sobreScreen = new Scene(FXMLSobreScreen, 400, 350);

        stageDialog.setScene(sobreScreen);
        stageDialog.show();

    }
    public void opcoesCalculo(javafx.event.ActionEvent event) throws MalformedURLException {
        String message = "";
        if(chebychev.isSelected())
        {
            System.out.println("Cheviichenco");
            File file = new File("src/main/java/br/com/projetoLP/img/chebychev.png");
            Image img = new Image(file.toURI().toString());
            imagemCalculo.setImage(img);
            TIPO_DISTANCIA =  DistanceType.CHEBYCHEV;
        }
        if (manhattan.isSelected())
        {
            System.out.println("Manhattan");

            File file = new File("src/main/java/br/com/projetoLP/img/manhattan.png");
            Image img = new Image(file.toURI().toString());

            imagemCalculo.setImage(img);
            TIPO_DISTANCIA =  DistanceType.MANHATHAN;
        }
        if (euclidiana.isSelected())
        {
            System.out.println("Euclidiana");
            File file = new File("src/main/java/br/com/projetoLP/img/euclidiana.png");
            Image img = new Image(file.toURI().toString());
            System.out.println(file.toURI().toString());
            imagemCalculo.setImage(img);
            TIPO_DISTANCIA =  DistanceType.EUCLIDEAN;
        }


    }
    @FXML
    public void btFechar(javafx.event.ActionEvent event) {
        Stage stage = (Stage) btOk.getScene().getWindow();
        stage.close();
    }
}


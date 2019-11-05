package br.com.projetoLP;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import br.com.projetoLP.model.enumeration.ScreenType;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 * The type Main.
 */
public class Main extends Application {

    // Essas variáveis servem como cache para aplicação armazenando as telas que ela tem,
    // permitindo ela possivelmente trocar de tela se necessário.
    private static Stage stage;
    private static Scene main;
    private static Scene result;

    // Essa variável cria a lista de ouvintes, aqui devem ser adicionadas as classes de controle,
    // De modo que elas possam trocar dados entre si já que o  javaFX não tem esse recurso nativamente.
    private static ArrayList<onChangeScreen> listeners = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("Projeto de LP-2");

        // Se adicionar mais algum fxml e classe de controle tem que iniciar a página aqui.

        //Área da nova interface
        URL urlMain = new File("src/main/java/br/com/projetoLP/view/Main.fxml").toURI().toURL();
        Parent FXMLMain = FXMLLoader.load(urlMain);
        main = new Scene(FXMLMain, 600, 400);

        URL urlResultScreen = new File("src/main/java/br/com/projetoLP/view/resultScreen.fxml").toURI().toURL();
        Parent FXMLResultScreen = FXMLLoader.load(urlResultScreen);
        result = new Scene(FXMLResultScreen, 600, 400);

        stage.setResizable(false);
        stage.setScene(main);
        stage.show();
    }

    /**
     * The entry point of application.
     * *
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

<<<<<<< HEAD
=======

>>>>>>> 67072875c978343e73034797716c0a3382272bb7
    /**
     * The interface On change screen.
     */
    public static interface onChangeScreen{
        /**
         * On screen changed.
         *  @param screen   the screen
         * @param userData the user data
         */
        public void onScreenChanged(ScreenType screen, Object ... userData);
    }

    private static void notifyAllListeners(ScreenType screen, Object[] userData){
        for (onChangeScreen value:listeners) {
            value.onScreenChanged(screen, userData);
        }
    }

    /**
     * Add on change screen on listeners.
     *
     * @param listener the listener
     */
    public static void addOnChangeScreenOnListeners(onChangeScreen listener)
    {
        listeners.add(listener);
    }


    /**
     * Change screen, os dados que quiser passar entre as telas será a variável userData.
     *
     * @param str      the str
     * @param userData the user data
     */
    public static void changeScreen(ScreenType str, Object ... userData){
        switch (str){
            case mainSreen:
                notifyAllListeners(str,userData);
                stage.setScene(main);
                break;
            case resultSreen:
                notifyAllListeners(str, userData);
                stage.setScene(result);
                break;
        }
    }


    public static Stage getStage() {
        return stage;
    }
}

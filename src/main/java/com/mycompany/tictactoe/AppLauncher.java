package com.mycompany.tictactoe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.fxml.FXML;

public class AppLauncher extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private GridPane boardPane;
    private GameInformationController gameInformationController;
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public BorderPane getRootLayout() {
        return rootLayout;
    }
    
    public GridPane getBoardPane() {
        return boardPane;
    }
    
    public GameInformationController getGameInformationController() {
        return gameInformationController;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setResizable(false);
        
        initRootLayout();
        initInfoBoard();
        initGameBoard();
    }
    
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppLauncher.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            rootLayout.setMinHeight(400);
            rootLayout.setMaxHeight(400);
            rootLayout.setMinWidth(600);
            rootLayout.setMaxWidth(600);
            
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add("/styles/Styles.css");
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initGameBoard() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AppLauncher.class.getResource("/fxml/Board.fxml"));
        boardPane = (GridPane) loader.load();
        ((BoardController) loader.getController()).setMainApp(this);
        boardPane.setMinHeight(400);
        boardPane.setMinWidth(400);
        boardPane.setMaxHeight(400);
        boardPane.setMaxWidth(400);
        rootLayout.setLeft(boardPane);
    }
    
    private void initInfoBoard() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AppLauncher.class.getResource("/fxml/GameInformation.fxml"));
        AnchorPane gameInfoPane = (AnchorPane) loader.load();
        this.gameInformationController = ((GameInformationController) loader.getController());
        this.gameInformationController.init();
        
        gameInfoPane.setMinHeight(400);
        gameInfoPane.setMinWidth(200);
        gameInfoPane.setMaxHeight(400);
        gameInfoPane.setMaxWidth(200);
        rootLayout.setRight(gameInfoPane);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

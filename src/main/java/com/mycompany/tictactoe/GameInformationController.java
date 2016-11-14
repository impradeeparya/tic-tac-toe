package com.mycompany.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * FXML Controller class
 *
 * @author Pradeep Arya
 */
public class GameInformationController {

    public static List<String> board;

    @FXML
    private Label playerOneInformation;

    @FXML
    private Label playerTwoInformation;

    @FXML
    private Label gameProgressInformation;

    public Label getPlayerOneInformation() {
        return playerOneInformation;
    }

    public Label getPlayerTwoInformation() {
        return playerTwoInformation;
    }

    public Label getGameProgressInformation() {
        return gameProgressInformation;
    }

    void init() {
        if ((this.playerOneInformation != null) && (this.playerTwoInformation != null) && (this.gameProgressInformation != null)) {
            this.playerOneInformation.setText("Player One : X ");
            this.playerTwoInformation.setText("Player Two : O");
            this.gameProgressInformation.setText("Player One Chance");
        }

        if (board == null) {
            board = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", ""));
        }
    }

}

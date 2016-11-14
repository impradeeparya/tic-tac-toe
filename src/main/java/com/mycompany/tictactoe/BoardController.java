package com.mycompany.tictactoe;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BoardController {

    AppLauncher app;
    private static int chanceCounter;

    private static boolean isSecondPlayer;
    private static boolean isGameOver;

    @FXML
    private void onBoxClicked(Event evt) {
        Label label = (Label) evt.getSource();
        if (label.getText().isEmpty() && !isGameOver) {
            String text;
            if (isSecondPlayer) {
                text = "O";
            } else {
                text = "X";
            }
            chanceCounter++;
            label.setText(text);
            GameInformationController.board.set(Integer.valueOf(label.getId()), text);
            checkGameProgress(text);
        }

        if (isGameOver) {
            app.getGameInformationController().getGameProgressInformation().setText("Player " + (isSecondPlayer ? "Two " : "One ") + "Won!!!");
        } else if (chanceCounter == 9) {
            app.getGameInformationController().getGameProgressInformation().setText("Game Draw");
        } else {
            isSecondPlayer = !isSecondPlayer;
            if (isSecondPlayer) {
                app.getGameInformationController().getGameProgressInformation().setText("Player Two Chance");
            } else {
                app.getGameInformationController().getGameProgressInformation().setText("Player One Chance");
            }
        }
    }

    void setMainApp(AppLauncher app) {
        this.app = app;
        chanceCounter = 0;
    }

    private boolean checkGameProgress(String text) {
        isGameOver = false;
        if ((GameInformationController.board.get(0).equalsIgnoreCase(text)) && (GameInformationController.board.get(1).equalsIgnoreCase(text)) && (GameInformationController.board.get(2).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(3).equalsIgnoreCase(text)) && (GameInformationController.board.get(4).equalsIgnoreCase(text)) && (GameInformationController.board.get(5).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(6).equalsIgnoreCase(text)) && (GameInformationController.board.get(7).equalsIgnoreCase(text)) && (GameInformationController.board.get(8).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(0).equalsIgnoreCase(text)) && (GameInformationController.board.get(3).equalsIgnoreCase(text)) && (GameInformationController.board.get(6).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(1).equalsIgnoreCase(text)) && (GameInformationController.board.get(4).equalsIgnoreCase(text)) && (GameInformationController.board.get(7).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(2).equalsIgnoreCase(text)) && (GameInformationController.board.get(5).equalsIgnoreCase(text)) && (GameInformationController.board.get(8).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(0).equalsIgnoreCase(text)) && (GameInformationController.board.get(4).equalsIgnoreCase(text)) && (GameInformationController.board.get(8).equalsIgnoreCase(text))) {
            isGameOver = true;
        } else if ((GameInformationController.board.get(2).equalsIgnoreCase(text)) && (GameInformationController.board.get(4).equalsIgnoreCase(text)) && (GameInformationController.board.get(6).equalsIgnoreCase(text))) {
            isGameOver = true;
        }
        return isGameOver;
    }
}

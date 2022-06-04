package com.example.scratt.Controller;

import com.example.scratt.Services.CreateGameBuilder;
import com.example.scratt.Services.UserLetters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScreenWriterController implements Initializable {
    @FXML private Text centerletter;
    @FXML private Text letter0;
    @FXML private Text letter1;
    @FXML private Text letter2;
    @FXML private Text letter3;
    @FXML private Text letter4;
    @FXML private Text letter5;

    boolean whichgame = false;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            createGameBtn(whichgame);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //if true generate random numbers
    private void createGameBtn(boolean whichgame) throws FileNotFoundException {
        CreateGameBuilder cr = new CreateGameBuilder();
        if(whichgame){
            cr.generateRandomLetters();
        }
        else{
            UserLetters ul = new UserLetters();
            ul.play();
            cr = new CreateGameBuilder(new StringBuilder(ul.metin), ul.foundWords );
        }
        centerletter.setText(String.valueOf(cr.centerLetter));
        System.out.println(cr.gameletters);
        letter0.setText(String.valueOf(cr.gameletters.charAt(0)));
        letter1.setText(String.valueOf(cr.gameletters.charAt(1)));
        letter2.setText(String.valueOf(cr.gameletters.charAt(2)));
        letter3.setText(String.valueOf(cr.gameletters.charAt(3)));
        letter4.setText(String.valueOf(cr.gameletters.charAt(4)));
        letter5.setText(String.valueOf(cr.gameletters.charAt(5)));
    }
    public void checkGameType(boolean whichgame){
        this.whichgame = whichgame;
    }

    @FXML public void handleSubmitAction(ActionEvent event) throws FileNotFoundException {

    }
}


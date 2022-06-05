package com.example.scratt.Controller;

import com.example.scratt.HelloController;
import com.example.scratt.Services.CreateGameBuilder;
import com.example.scratt.Services.PlayGame;
import com.example.scratt.Services.UserLetters;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

public class ScreenWriterController implements Initializable {
    @FXML private Text centerletter;
    @FXML private Text letter0;
    @FXML private Text letter1;
    @FXML private Text letter2;
    @FXML private Text letter3;
    @FXML private Text letter4;
    @FXML private Text letter5;

    @FXML private AnchorPane anchorPane;


    @FXML private Text userAnswer;
    @FXML private Text foundAnswers;
    @FXML private Label scoreBoard;
    int x = 0;
    boolean whichgame = true;

    int numOfFoundWords, totalNumOfWords , userPoint, totalPoint, numOfFoundPanagrams, totalNumOfPanagrams;
    String score;

    CreateGameBuilder cr = new CreateGameBuilder();

    public ScreenWriterController() throws FileNotFoundException {
    }

    public void createkalvye(){
        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                boolean valid = false;
                if ((x == 0) || (x == 11)) {
                    userAnswer.setText("");
                    x++;
                }
                if (keyEvent.getCode().isLetterKey()) {
                    valid = String.valueOf(cr.gameletters).contains(keyEvent.getCode().toString().toLowerCase(Locale.ROOT));

                    if (valid) {
                        userAnswer.setText(userAnswer.getText() + keyEvent.getCode().toString().toLowerCase(Locale.ROOT));
                        userAnswer.setFill(Color.WHITE);
                    } else {
                        userAnswer.setFill(Color.GRAY);
                        userAnswer.setText(userAnswer.getText() + keyEvent.getCode().toString().toLowerCase(Locale.ROOT));
                    }
                }
                if (keyEvent.getCode() == KeyCode.BACK_SPACE)
                    btnSilClicked(new ActionEvent());
            }

        });
    }



    @Override
    public void initialize(URL location, ResourceBundle resources){
        whichgame = HelloController.gameType;
        try {
            createGameBtn(whichgame);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        createkalvye();

    }
    public void checkGameType(boolean whichgame){
        this.whichgame = whichgame;
    }

    //if true generate random numbers
    private void createGameBtn(boolean whichgame) throws FileNotFoundException {
        if(!whichgame){
            UserLetters ul = new UserLetters();
            System.out.println(HelloController.gameLetters);
            ul.play(HelloController.gameLetters);
            cr = new CreateGameBuilder(new StringBuilder(ul.metin), ul.foundWords );
        }
        ///cr.gameletters = new StringBuilder(String.valueOf(cr.gameletters).replace(String.valueOf(cr.centerLetter), ""));
        centerletter.setText(String.valueOf(cr.centerLetter));
        System.out.println(cr.gameletters);
        letter0.setText(String.valueOf(cr.gameletters.charAt(0)));
        letter1.setText(String.valueOf(cr.gameletters.charAt(1)));
        letter2.setText(String.valueOf(cr.gameletters.charAt(2)));
        letter3.setText(String.valueOf(cr.gameletters.charAt(3)));
        letter4.setText(String.valueOf(cr.gameletters.charAt(4)));
        letter5.setText(String.valueOf(cr.gameletters.charAt(5)));
        totalNumOfWords = cr.gamewordswithcenterletter.size();
        cr.listOfPangrams();
        totalNumOfPanagrams = cr.panagrams.size();
        score = numOfFoundWords + "/" + totalNumOfWords + "/" + userPoint +"/" + numOfFoundPanagrams + "/" +totalNumOfPanagrams;
        scoreBoard.setText(score);
    }

    @FXML public void handleSubmitAction(ActionEvent event) throws FileNotFoundException {
        PlayGame playGame = new PlayGame();
        if (playGame.checkWord(cr.gamewordswithcenterletter, userAnswer.getText())){
            foundAnswers.setText(foundAnswers.getText() + "\n" + userAnswer.getText());
            updateScore();
        }
        else
            userAnswer.setText("");

    }

    @FXML public void btnSilClicked(ActionEvent event){
        StringBuilder str = new StringBuilder(userAnswer.getText());
        str.delete(str.length() - 1, str.length());

        userAnswer.setText(str.toString());
    }
    @FXML public void MixLetters(ActionEvent event) {
        ArrayList<Text> letters = new ArrayList<>();

        letters.add(letter0);
        letters.add(letter1);
        letters.add(letter2);
        letters.add(letter3);
        letters.add(letter4);
        letters.add(letter5);

        Collections.shuffle(letters);
        for (int i = 0; i < 6; i++) {
            letters.get(i).setText(String.valueOf(cr.gameletters.charAt(i)));
        }
    }

    public void LetterClick(MouseEvent mouseEvent) {
        if((x == 0) || (x == 11)){
            userAnswer.setText("");
            x++;
        }
        if(mouseEvent.getSource() == letter0){
            userAnswer.setText(userAnswer.getText() + letter0.getText());
        }
        else if(mouseEvent.getSource() == letter1){
            userAnswer.setText(userAnswer.getText() + letter1.getText());
        }
        else if(mouseEvent.getSource() == letter2){
            userAnswer.setText(userAnswer.getText() + letter2.getText());
        }
        else if(mouseEvent.getSource() == letter3){
            userAnswer.setText(userAnswer.getText() + letter3.getText());
        }
        else if(mouseEvent.getSource() == letter4){
            userAnswer.setText(userAnswer.getText() + letter4.getText());
        }
        else if(mouseEvent.getSource() == letter5){
            userAnswer.setText(userAnswer.getText() + letter5.getText());
        }
        else if(mouseEvent.getSource() == centerletter){
            userAnswer.setText(userAnswer.getText() + centerletter.getText());
        }
        for(String gamwords : cr.gamewordswithcenterletter){
            System.out.println(gamwords);
        }
    }
    public void updateScore(){

        String[] sc  = foundAnswers.getText().split("/n");
        String answer = sc[sc.length-1];
        if (answer.length() == 4) {
            userPoint += 1;
            numOfFoundWords++;
        } else if (answer.length() >= 4) {
            userPoint += (answer.length() - 4) * 2;
        }

        score = numOfFoundWords + "/" + totalNumOfWords + "/" + userPoint+ "/" +totalPoint+ "/" + numOfFoundPanagrams + "/" +totalNumOfPanagrams;
    }

}


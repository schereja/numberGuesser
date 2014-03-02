/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.Serializable;

/**
 *
 * @author schereja
 */
public class NumberGuesserService implements Serializable{
    private String result;
    private int guesses=0;
    private Boolean gameAlive = true;
    public void compareNumbers(int randNum, int guessedNum){
        if(randNum == guessedNum){
            result = "match";
            gameAlive = false;
        } else if(randNum<guessedNum){
            result = "high";
            guesses++;
        } else if(randNum>guessedNum){
            result = "low";
            guesses++;
        }
        resultMsg(result);
    }
    public String resultMsg(String result){
        return this.result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public Boolean isGameAlive() {
        return gameAlive;
    }

    public void setGameAlive(Boolean gameAlive) {
        this.gameAlive = gameAlive;
    }
    
}

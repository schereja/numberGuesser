/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed.beans;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.NumberGuesserService;


/**
 *
 * @author schereja
 */
@Named
@SessionScoped
public class NumberGuesserBean implements Serializable{
    private int numberGuessed;
    private String result;
    private int randomNumber;
    private int numberOfGuesses = 0;
    private Boolean stillPlaying = true;
    Random generator = new Random();
    private int maxGuesses = 0;
    private int leastGuesses = 0;
    
    @Inject
    private service.NumberGuesserService ngs;
    /**
     * Creates a new instance of NumberBean
     */
    public NumberGuesserBean() {
        
    }
    public void startGame(){
        randomNumber = generator.nextInt(10)+1;
        
    }
    public void checkNumber(){
        if(stillPlaying == false){
            randomNumber = generator.nextInt(10)+1; 
            stillPlaying = true;
            ngs.setGameAlive(stillPlaying);
        }
        ngs.compareNumbers(randomNumber, numberGuessed);
        result = ngs.getResult();
        numberOfGuesses = ngs.getGuesses();
        stillPlaying = ngs.isGameAlive();
        if(stillPlaying == true){
            result = "Your number is too " + result + ". Try again.";
        } else if(stillPlaying == false){
            result = "You won.";
            setBothGuesses();
            ngs.setGuesses(0);
        }
    }
    public void setBothGuesses(){
        if(leastGuesses == 0){
            setLeastGuesses(numberOfGuesses);
        } else if(leastGuesses >numberOfGuesses){
            setLeastGuesses(numberOfGuesses);
        }
        if(maxGuesses == 0){
        setMaxGuesses(numberOfGuesses);
        } else if(maxGuesses<numberOfGuesses){
            setMaxGuesses(numberOfGuesses);
        }
        
    }
    public int getNumberGuessed() {
        return numberGuessed;
    }

    public void setNumberGuessed(int numberGuessed) {
        this.numberGuessed = numberGuessed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public NumberGuesserService getNgs() {
        return ngs;
    }

    public void setNgs(NumberGuesserService ngs) {
        this.ngs = ngs;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }

    public Boolean isStillPlaying() {
        return stillPlaying;
    }

    public void setStillPlaying(Boolean stillPlaying) {
        this.stillPlaying = stillPlaying;
    }

    public Random getGenerator() {
        return generator;
    }

    public void setGenerator(Random generator) {
        this.generator = generator;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public void setMaxGuesses(int maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public int getLeastGuesses() {
        return leastGuesses;
    }

    public void setLeastGuesses(int leastGuesses) {
        this.leastGuesses = leastGuesses;
    }

    
    
}

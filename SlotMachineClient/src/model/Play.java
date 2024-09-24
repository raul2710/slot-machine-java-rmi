/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.sql.Timestamp;
import java.time.*;

/**
 *
 * @author rault
 */
public class Play {
    
    private int[] randomNumbers;
    //private Timestamp playAt;
    private LocalDateTime playAt;
    
    public Play(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
        this.playAt = LocalDateTime.now();
    }

    public int[] getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public LocalDateTime getPlayAt() {
        return playAt;
    }

    public void setPlayAt(LocalDateTime playAt) {
        this.playAt = playAt;
    }

    @Override
    public String toString() {
        
        return 
                randomNumbers[0] + "    " + 
                randomNumbers[1] + "    " + 
                randomNumbers[2] + "    " + 
                playAt.toString();
    }   
}

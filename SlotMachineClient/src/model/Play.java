/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rault
 */
public class Play {
    
    private int[] randomNumbers;
    //private Timestamp playAt;
    private LocalDateTime playAt;
    
    public Play(int[] randomNumbers, LocalDateTime playAt) {
        this.randomNumbers = randomNumbers;
        this.playAt = playAt;
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
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("HH:mm    dd/MM/uuuu");
        String dateTime = formatterData.format(playAt);
        return 
            randomNumbers[0] + "    " + 
            randomNumbers[1] + "    " + 
            randomNumbers[2] + "        " + 
            dateTime;
    }   
}

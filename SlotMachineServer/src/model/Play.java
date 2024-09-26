/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rault
 */
public class Play {
    
    private int[] randomNumbers;
    private float moneyBet;
    private LocalDateTime playAt;
    
    public Play(int[] randomNumbers, float moneyBet) {
        this.randomNumbers = randomNumbers;
        this.moneyBet = moneyBet;
        this.playAt = LocalDateTime.now();
    }

    public int[] getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public float getMoneyBet() {
        return moneyBet;
    }

    public void setMoneyBet(float moneyBet) {
        this.moneyBet = moneyBet;
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
        String dateTime = formatterData.format(this.playAt);
        return 
            "Value1: " +    
            this.randomNumbers[0] + "       Value2: " + 
            this.randomNumbers[1] + "       Value3: " + 
            this.randomNumbers[2] + "       Money Bet: " + 
            this.moneyBet + "   Time: " +
            dateTime;
    }   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import util.EncryptUtil;

/**
 *
 * @author rault
 */
public class User {
    
    private String name;
    private String email;
    private double money;
    private String password;
    private List<Play> plays;
    
    public User(String name, String email, double money, String password){
        this.name = name;
        this.email = email;
        this.money = money;
        this.password = EncryptUtil.toMD5(password);
        this.plays = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }
    
    public void addPlay(Play play) {
        this.plays.add(play);
    }
}

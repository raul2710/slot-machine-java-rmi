/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.EncryptUtil;

/**
 *
 * @author rault
 */
public class User {
    
    private String password;
    
    public User(String password){
        this.password = EncryptUtil.toMD5(password);
    }
}

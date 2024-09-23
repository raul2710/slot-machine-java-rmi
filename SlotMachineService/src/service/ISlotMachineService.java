/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author rault
 */
public interface ISlotMachineService extends Remote {
    
    public static final String HOST="127.0.0.1";
    public static final String NOME="DateTime";
    public static final int PORTA= 1099;

    //Assinaturas dos Métodos
    public abstract String getData() throws RemoteException;
    public abstract String getHora() throws RemoteException;
    public abstract String getDataExtenso() throws RemoteException;
}

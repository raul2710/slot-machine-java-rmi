/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author rault
 */
public interface ISlotMachineService extends Remote {
    
    public static final String HOST = "127.0.0.1";
    public static final String NAME = "SlotMachine";
    public static final int PORT = 1099;

    //Assinaturas dos Métodos
    public abstract int[] getRandomNumbers() throws RemoteException;
    public abstract LocalDateTime getLocalDateTime() throws RemoteException;
    public abstract List getHistoryPlay() throws RemoteException;
    public abstract String getMoneyStorage() throws RemoteException;
    public abstract void addPlayToHistory(int[] plays) throws RemoteException;
    public abstract void updateDecreaseMoneyStorage(float value) throws RemoteException;
    public abstract void updateIncreaseMoneyStorage(float value) throws RemoteException;
    public abstract String getUserName() throws RemoteException;
    public abstract int getUserSelect() throws RemoteException;
    public abstract void setUserSelect(int indexUser) throws RemoteException;
    
}

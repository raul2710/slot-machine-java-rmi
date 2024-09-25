/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import service.ISlotMachineService;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Play;
import model.User;
import util.EncryptUtil;

/**
 *
 * @author rault
 */
public class Server extends UnicastRemoteObject implements ISlotMachineService {
       
    private final int DIFFICULTY = 10;
    private List<User> user = new ArrayList<>();
    private int userSelect;

    public Server() throws RemoteException {
        super();
        
        user.add(new User("Raul Tavares Danielli", "raultavares27@outlook.com", 12.2f, "raulzito123"));
        user.add(new User("Isabelle Massonetto", "isa26@outlook.com", 12.2f, "test132"));
        user.add(new User("Fabiano Godine", "221fabin@outlook.com", 12.2f, "fabin213"));
    }
    
    @Override
    public LocalDateTime getLocalDateTime() throws RemoteException {
        return LocalDateTime.now();
    }
    
    @Override
    public int[] getRandomNumbers() throws RemoteException {
        int[] randomNumbers = new int[3];
        Random rand = new Random();;
        
        if (rand.nextInt(DIFFICULTY) == rand.nextInt(5)) {
            int win = rand.nextInt(5);
            for (int i = 0; i < 3; i++) randomNumbers[i] = win;
        }
        else {
            for (int i = 0; i < 3; i++) randomNumbers[i] = rand.nextInt(5);
        }
        
        return randomNumbers;
    }

    //
    // EXECUÇÃO DO SERVER
    //
    public static void main(String[] args) {
        
        try {
            ISlotMachineService srv = new Server();

            Registry rg = LocateRegistry.createRegistry(PORT);
            rg.bind(NAME, srv);

            System.out.println("Servidor " + NAME + " iniciado.");

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    @Override
    public List<String> getHistoryPlay() throws RemoteException {
        List<String> historyPlay = new ArrayList<>();

        this.user.get(userSelect).getPlays().forEach(p -> {
            historyPlay.add(p.toString());
        });
        
        return historyPlay;
    }

    @Override
    public String getMoneyStorage() throws RemoteException {
        return Float.toString(this.user.get(userSelect).getMoney());
    }

//    @Override
    public void addUser(User u) throws RemoteException {
        this.user.add(u);
    }

    @Override
    public void addPlayToHistory(int[] plays) throws RemoteException {
        Play play = new Play(plays);
        this.user.get(userSelect).addPlay(play);
    }

    @Override
    public void updateDecreaseMoneyStorage(float value) throws RemoteException {
        float updateMoney = this.user.get(userSelect).getMoney() - value;
        this.user.get(userSelect).setMoney(updateMoney);
    }
    
    @Override
    public void updateIncreaseMoneyStorage(float value) throws RemoteException {
        float updateMoney = this.user.get(userSelect).getMoney() + value;
        this.user.get(userSelect).setMoney(updateMoney);
    }

    @Override
    public String getUserName() throws RemoteException {
        return this.user.get(userSelect).getName();
    }
    
    @Override
    public void setUserSelect(int userSelect) throws RemoteException {
        this.userSelect = userSelect;
    }

    @Override
    public void addUser(String name, String email, float money, String password) throws RemoteException {
        user.add(new User(name, email, money, password));
    }

    @Override
    public boolean authenticator(String email, String password) throws RemoteException {
        String passwordEncrypt = EncryptUtil.toMD5(password);
        for (User u : this.user) {
            if(u.getEmail().equals(email) && u.getPassword().equals(passwordEncrypt))return true;
            System.out.println("");
        }
        
        return false;
    }
    
    @Override
    public int getUserIndexByEmail(String email) throws RemoteException {
        
        for (int i=0; i<user.size(); i++) {
            if(user.get(i).getEmail().equals(email))return i;
        }
        
        return -1;
    }
}

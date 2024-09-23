/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import service.ISlotMachineService;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Random;

/**
 *
 * @author rault
 */
public class Server extends UnicastRemoteObject implements ISlotMachineService {
       
    private final int DIFFICULTY = 10;
    
    public Server() throws RemoteException {
        super();
    }

    @Override
    public String getHora() throws RemoteException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm:ss");
        return f.format(LocalTime.now());
    }

    @Override
    public String getDataExtenso() throws RemoteException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        return f.format(LocalDate.now());
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

}

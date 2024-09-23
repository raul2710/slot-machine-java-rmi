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

/**
 *
 * @author rault
 */
public class Server extends UnicastRemoteObject implements ISlotMachineService {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String getData() throws RemoteException {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return f.format(LocalDate.now());
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

            Registry rg = LocateRegistry.createRegistry(PORTA);
            rg.bind(NOME, srv);

            System.out.println("Servidor " + NOME + " iniciado.");

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

}

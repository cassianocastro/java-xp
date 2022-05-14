/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets.client;

import java.io.IOException;

/**
 *
 *
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            new Client().init();
            System.out.println("Client connected to server.");
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
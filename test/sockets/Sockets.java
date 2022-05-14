package sockets;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 */
public class Sockets
{

    public static void main(String[] args)
    {
        try (ServerSocket server = new ServerSocket(12345))
        {
            JOptionPane.showMessageDialog(null, "Porta 12345 aberta.");
            Socket cliente = server.accept();

            JOptionPane.showMessageDialog(
                null,
                "Nova conexão com o cliente "
                + cliente.getInetAddress().getHostAddress()
            );

            Scanner scanner = new Scanner(cliente.getInputStream());

            while ( scanner.hasNextLine() )
            {
                // System.out.println(scanner.nextLine());
                JOptionPane.showMessageDialog(null, scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

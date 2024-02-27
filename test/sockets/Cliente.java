package sockets;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 */
public class Cliente
{

    public static void main(String[] args)
    {
        try
        {
            Socket cliente = new Socket("127.0.0.1", 12345);

            JOptionPane.showMessageDialog(null, "Cliente conectado ao servidor.");

            Scanner scanner    = new Scanner(System.in);
            PrintStream stream = new PrintStream(cliente.getOutputStream());

            new ObjectOutputStream(cliente.getOutputStream()).writeObject(args);

            while ( scanner.hasNextLine() )
            {
                stream.println(scanner.nextLine());
            }

            stream.close();
            scanner.close();
        }
        catch ( IOException e )
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
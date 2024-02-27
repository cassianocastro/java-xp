package sockets.server;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class Server
{

    private final int port;

    public Server(int port)
    {
        this.port = port;
    }

    public void init() throws IOException
    {
        ServerSocket server = new ServerSocket(this.port);

        while ( true )
        {
            Socket client = server.accept();

            this.listenInputFrom(client);
        }
    }

    private void listenInputFrom(Socket client) throws IOException
    {
        Scanner scanner = new Scanner(client.getInputStream());

        while ( scanner.hasNextLine() )
        {
            System.out.println(
                client.getInetAddress().getHostAddress() + ": " + scanner.nextLine()
            );
        }

        scanner.close();
    }
}
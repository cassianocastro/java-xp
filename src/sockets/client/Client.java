package sockets.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 *
 */
public class Client
{

    public void init() throws IOException
    {
        Socket client = new Socket("127.0.0.1", 12345);

        this.writeToServer(new PrintStream(client.getOutputStream()));

        client.close();
    }

    private void writeToServer(PrintStream stream) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        while ( scanner.hasNextLine() )
        {
            stream.println(scanner.nextLine());
        }
        scanner.close();
    }
}
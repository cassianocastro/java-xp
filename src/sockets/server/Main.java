package sockets.server;

import java.io.IOException;

/**
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
            new Server(12345).init();
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
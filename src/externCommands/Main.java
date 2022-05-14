/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package externCommands;

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
            new ExternalCommandsTest().testIntegrationWithPython();
        } catch(IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
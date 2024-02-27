package frames;

import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 */
public class NewMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();

        if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
        {
            String file = chooser.getSelectedFile().getAbsolutePath();
            try (BufferedReader reader
                = new BufferedReader(
                    new FileReader(file)))
            {
                while ( true )
                {
                    String line = reader.readLine();
                    if ( line == null )
                    {
                        throw new EOFException("Fim de arquivo");
                    }

                    System.out.println(line);
                }
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

        // Teste teste = new Teste();
        /*
            new Thread(() ->{
                for ( int i = 0; i < 1000; i++ )
                {
                    System.out.println("Programa: " + 1 + "| Valor: " + i);
                }
            }).start();

            new Thread(() -> {
                for ( int i = 0; i < 1000; i++ )
                {
                    System.out.println("Programa: " + 2 + "| Valor: " + i);
                }
            }).start();
        */
    }
}
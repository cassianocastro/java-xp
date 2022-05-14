package externCommands;

import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 */
public class ExternCommandTest
{

    public static void main(String[] args)
    {
        /*
        try
        {
            String comando = "ls -loha /home/cassiano/Downloads/";
            Process exec   = Runtime.getRuntime().exec(comando);

            InputStream input     = exec.getInputStream();
            Scanner scanner       = new Scanner(input);
            StringBuilder builder = new StringBuilder();

            while( scanner.hasNext() )
            {
                // System.out.println( scanner.nextLine() );
                builder.append(scanner.nextLine());
                builder.append("\n");
            }
            JOptionPane.showMessageDialog(null, builder);


            String comando = "python3 /home/cassiano/Documentos/Arquivos_Py/teste.py";
            Process exec   = Runtime.getRuntime().exec(comando);

            OutputStream output = exec.getOutputStream();
            PrintWriter writer  = new PrintWriter(output);

            int valor1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor:"));
            int valor2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor:"));


            writer.println(valor1);
            writer.println(valor2);
            writer.flush();

            InputStream input = exec.getInputStream();
            Scanner scanner   = new Scanner(input);

            while ( scanner.hasNext() )
            {
                System.out.println(scanner.nextLine());
            }

            if ( exec.waitFor() == 0 )
                System.out.println("Processo concluido.");
        } catch(IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        */
        foo();
    }

    public static void foo()
    {
        String pathName = "src/frames/imagens/";
        String[] names  = new File(pathName).list();
        String withoutExtension;

        Map<String, ImageIcon> map = new HashMap<>();

        for ( String name : names )
        {
            withoutExtension = name.substring(0, name.indexOf("."));
            map.put(withoutExtension, new ImageIcon(pathName + name));
        }

        for ( Object object : map.keySet() )
        {
            System.out.println(object);
        }

        JOptionPane.showMessageDialog(
            null,
            "Msg",
            "Title",
            JOptionPane.PLAIN_MESSAGE,
            map.get("ice-cream")
        );
    }
}

package externCommands;

import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class ExternalCommandsTest
{

    public void testIntegrationWithPython() throws IOException, InterruptedException
    {
        int valor1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro valor:"));
        int valor2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo valor:"));

        Process exec = Runtime.getRuntime().exec("python3 src/lib/test.py");
        OutputStream output = exec.getOutputStream();

        PrintWriter writer = new PrintWriter(output);

        writer.println(valor1);
        writer.println(valor2);
        writer.flush();

        Scanner scanner = new Scanner(exec.getInputStream());

        while ( scanner.hasNext() )
        {
            System.out.println(scanner.nextLine());
        }

        if ( exec.waitFor() == 0 )
        {
            System.out.println("Processo concluido.");
        }
    }

    public String testLinuxLsCommand() throws IOException
    {
        Process exec = Runtime.getRuntime().exec("ls -loha /home/cassiano/Downloads/");

        InputStream input     = exec.getInputStream();
        Scanner scanner       = new Scanner(input);
        StringBuilder builder = new StringBuilder();

        while ( scanner.hasNext() )
        {
            builder.append(scanner.nextLine()).append("\n");
        }

        return builder.toString();
    }

    public void foo()
    {
        String pathName = "src/lib/img/";
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
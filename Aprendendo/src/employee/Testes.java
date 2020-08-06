package employee;

import javax.jnlp.FileContents;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Testes {

   // private static FileContents nova;
    //public static  Class nova;


  /*  public static void verificarCaminho() throws IOException{

        System.console();
        Scanner leitor= new Scanner(System.in);
        // System system= new System();
        Path caminho= Paths.get("D:/Genelsia");

        System.out.println(Files.isDirectory(caminho));
        //  Files.newDirectoryStream(caminho);
        DirectoryStream<Path> fluxo= Files.newDirectoryStream(caminho);

        for(Path p: fluxo)
        {
            System.out.println(p);


        }

    }

*/
    public static void testeFormater() throws IOException{

        Scanner teclado= new Scanner(System.in);
        Formatter formatador= new Formatter("./media/teste.txt");

        while (teclado.hasNext()){

            try
             {
                // gera saída do novo registro para o arquivo; supõe entrada válida
                 formatador.format("%d %s %s %.2f%n", teclado.nextInt(),
                        teclado.next(), teclado.next(), teclado.nextDouble());
                 }
             catch (FormatterClosedException formatterClosedException)
             {
                 System.err.println("Error writing to file. Terminating.");
                 break;
                 }
             catch (NoSuchElementException elementException)
             {
                 System.err.println("Invalid input. Please try again.");
                 teclado.nextLine(); // descarta entrada para o usuário tentar de novo
                 }

        formatador.close();

    }
    }



    public static void main(String[] args) throws IOException {



   JFrame aplication= new JFrame();
   aplication.setSize(600,400);
   aplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   aplication.setVisible(true);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.showOpenDialog(aplication);

        System.out.println(fileChooser.getSelectedFile().toPath());
    }


}



package testes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainTestes {


    public static void main(String[] args) {

        File ficheiro=new File("ficheirosTeste/Teste.txt");

        try {

            FileWriter fw=new FileWriter(ficheiro);// Pode-se tambem usar o construtor com mais um parametro
            // booleano para definir se vai acrescentar ou nao
            fw.write("Teste Gratis");
            fw.close();//Apos
            //fw.flush();//Para limpar o Buffer dos arquivos
            FileReader fr=new FileReader(ficheiro);//Para ler os dados do ficheiro pode se usar
            //String teste= new String("Adolfo");
            //System.out.println(teste);
            char[] teste2=new char[500];

            int i=fr.read(teste2);//Contabiliza o numero de caracteres lidos
            System.out.println(i);
            fr.close();
            System.out.println(teste2);
        }catch (IOException erro){

            erro.printStackTrace();

        }



    }
}

package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FicheroTxt {

    public void escrituraFichero(String lineas, ArrayList<String> datosAnteriores) throws IOException {
        FileWriter fichero = new FileWriter("resultados.txt");
       for(String lineaNueva: datosAnteriores){
            fichero.write(lineaNueva + "\n");
        }
        fichero.write(lineas + "\n");
        fichero.close();
    }

    public ArrayList<String> lecturaFichero() throws IOException {
        File fichero = new File("resultados.txt");
        if(!fichero.exists()) fichero.createNewFile();
        Scanner s = null;
        System.out.println("Leyendo el contenido del fichero");
        ArrayList<String> lista= new ArrayList<>();
        s = new Scanner(fichero);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            lista.add(linea);
            System.out.println(linea);
        }
        s.close();
        return lista;

    }

    public void borrarFichero(){
        File fichero= new File("resultados.txt");
        if(fichero.exists()) fichero.delete();
        System.out.println("Fichero antiguo borrado");
    }
}

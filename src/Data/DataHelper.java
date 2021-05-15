package Data;

import java.io.*;

public class DataHelper {
    public void SerializeToFile(Object classObject, String fileName){
        try{
            //Abrimos el outputstrem en el archivo del disco donde escribiremos el contenido.

            FileOutputStream fileStream = new FileOutputStream(fileName);
            //Abre el flujo para convertir un objeto  en un byte stream
            ObjectOutputStream objectStream= new ObjectOutputStream(fileStream);
            //coge el objeto y lo convierte
            objectStream.writeObject(classObject);
            //cerramos los flujos
            objectStream.close();
            fileStream.close();
            System.out.println("Serializable");

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Object deSerializeFromFileToObject(String fileName){
        try{
            FileInputStream fileStream= new FileInputStream(new File(fileName));
            ObjectInputStream objectStream= new ObjectInputStream(fileStream);
            Object deserializableObject= objectStream.readObject();
            objectStream.close();
            fileStream.close();
            return deserializableObject;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}

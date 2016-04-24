import java.io.*;
import java.util.*;
/**
 * A class for serialize object or arraylist to a .dat format file
 * 
 * @author erithiana sisijoan 
 * @version 9.0
 */
public class CustomerFileWriter
{
    /**
     * Variabel untuk menyimpan FileOutputStream
     */
    private FileOutputStream fileOutputStream;
    
    /**
    * Variabel untuk menyimpan ObjectOutputStream
    */
    private ObjectOutputStream objectOutputStream;
    
     /**
     * Variabel untuk menyimpan file
     */
    File objectFile;
    
    /**
     * Kontruktor CustomerFileWriter
     */
    public CustomerFileWriter(){
        objectFile= new File("customer.dat");
        try{
            fileOutputStream= new FileOutputStream(objectFile);
        }
        catch(FileNotFoundException e){
            System.out.println("Not found");
        }
    }
    
    /**
     * Method untuk menulis Arraylist kedalam File .dat
     * 
     * @param customers ArrayList berisi customer
     */
    public void saveCustomer(ArrayList customers){
        try{
            //
            objectOutputStream= new ObjectOutputStream(fileOutputStream);
            
            //menuliskan arraylist ke dalam dat
            objectOutputStream.writeObject(customers);
            
            //hapus output stream
            objectOutputStream.flush();
            
            //Tutup Output Stream
            objectOutputStream.close();
        }
        catch(FileNotFoundException e){
             System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println("IO exception: "+ e.getMessage());
        }
        
    }
}

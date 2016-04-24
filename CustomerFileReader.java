import java.io.*;
import java.util.*;
/**
 * a class for reading dat files into arraylist
 * 
 * @author Erithiana sisijoan 
 * @version 9.0
 */
public class CustomerFileReader
{
    /**
     * Variabel untuk menyimpan FileInputStream
     */
    FileInputStream fileInputStream;
    
    /**
     * Variabel untuk menyimpan ObjectInputStream
     */
    ObjectInputStream objectInputStream;
    
    /**
     * Variabel untuk menyimpan ObjectFile
     */
    File objectFile;
    
    /**
     * Method Konstruktor CustomerFileReader
     */
    public CustomerFileReader(){
        try{
            fileInputStream= new FileInputStream("customer.dat");
        }
        catch(FileNotFoundException e){
            System.out.println("Not found");
        }
        
    }
    
    /**
     * Method untuk menulis Arraylist kedalam File .dat
     * 
     * @return Arraylist<Customer> dari File dat
     */
    public ArrayList<Customer> readCustomer(){
        ArrayList<Customer> cust=null;
        try{
            objectInputStream= new ObjectInputStream(fileInputStream);
            //menampung data hasil bacaan
            cust=(ArrayList<Customer>) objectInputStream.readObject();
            //tutup stream untuk membaca.
            objectInputStream.close();
        }
        catch(IOException dummy){
               System.out.println(dummy.getMessage());
        }
        catch(ClassNotFoundException dummy){
               System.out.println(dummy.getMessage());
       }
        return cust;
    }
}

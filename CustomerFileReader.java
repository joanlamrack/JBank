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
    public CustomerFileReader(File Input){
        try{
            objectFile= Input;
            fileInputStream= new FileInputStream(objectFile);
        }
        catch(FileNotFoundException e){
            System.out.println("Not found");
        }
        
    }
    
    public CustomerFileReader(){
        try{
            objectFile= new File("customers.dat");;
            fileInputStream= new FileInputStream(objectFile);
        }
        catch(FileNotFoundException e){
            System.out.println("Not found");
        }
        
    }
    
    /**
     * Method untuk menulis Arraylist kedalam File .dat
     * 
     * @return SortedSet<Customer> dari File dat
     */
    public SortedSet<Customer> readCustomer(){
        SortedSet<Customer> cust=null;
        try{
            objectInputStream= new ObjectInputStream(fileInputStream);
            //menampung data hasil bacaan
            cust=(SortedSet<Customer>) objectInputStream.readObject();
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

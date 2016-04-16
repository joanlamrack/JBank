import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.math.*;
/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * , dengan GUI
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 8.7
 */
public class Teller
{
    
    /**
    * Awal dari Program
    */
    
    public static void main(String[] args){
        try{
            Customer c1= new Customer("Erithiana", "Sisijoan", ( new GregorianCalendar(1995, 7, 9).getTime()));
            Bank.addCustomer(c1);
            Savings saving= new Savings(c1, 500);
            c1.addAccount(saving);
            
            c1= new Customer("Hey2", "Sisijoan", ( new GregorianCalendar(1995, 7, 8).getTime()));
            Bank.addCustomer(c1);
            saving= new Savings(c1, 1000000);
            c1.addAccount(saving);
            
            ATMGUI gui =new ATMGUI();
        }
       catch(AccountTypeAlreadyExistException dummy){
           System.out.println(dummy.getMessage());
       }
        
    }
}

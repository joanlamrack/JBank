import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.math.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas khusus coba-coba
 * 
 * @author Erithiana Sisijoan  
 * @version 8.7
 */
    public class Sandbox
    {
       public static void main(String[]args){
           try{
                    Customer c1= new Customer("Erithiana", "Sisijoan", ( new GregorianCalendar(1995, 7, 9).getTime()));
                    Bank.addCustomer(c1);
                    Savings saving= new Savings(c1, 500);
                    Investment invest= new Investment(c1, 1000, 12);
                    OverDraftProtection over = new OverDraftProtection(c1, 1500, saving);
                    LineOfCredit line = new LineOfCredit(c1, 3000, 1000);
                    c1.addAccount(saving);
                    c1.addAccount(invest);
                    c1.addAccount(over);
                    c1.addAccount(line);
                    c1.addAccount(line);
                    char getACCT='L';
                    if(Bank.getCustomer(1001).getAccount(getACCT)==null){
                        System.out.println(new AccountTypeNotFoundException(getACCT).getMessage());
                    }
                    System.out.println("lanjut!");
           }
           catch(AccountTypeAlreadyExistException dummy){
               System.out.println(dummy.getMessage());
           }
           catch(AccountTypeNotFoundException sameAccount){
               System.out.println(sameAccount.getMessage());
           }
            
       }
    }


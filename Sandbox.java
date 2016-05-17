import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.math.*;
import java.io.*;
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
            
            ArrayList<Customer> customers= new ArrayList<>();
            
            Customer c1= new Customer(Bank.getNextID(),"Erithiana", "Sisijoan", ( new GregorianCalendar(1995, 7, 9).getTime()));
            Savings saving= new Savings(c1, 500);
            Investment invest= new Investment(c1, 1000, 12);
            OverDraftProtection over = new OverDraftProtection(c1, 1500, saving);
            LineOfCredit line = new LineOfCredit(c1, 3000, 1000);
            c1.addAccount(saving);
            c1.addAccount(invest);
            c1.addAccount(over);
            //c1.addAccount(line);
            
            customers.add(c1);
            
            c1= new Customer(Bank.getNextID(),"hello again", "Sisijoan", ( new GregorianCalendar(1995, 7, 9).getTime()));
            saving= new Savings(c1, 500);
            customers.add(c1);
            c1.addAccount(saving);
            
            c1= new Customer(Bank.getNextID(),"hello again", "wkwkwk", ( new GregorianCalendar(1995, 8, 9).getTime()));
            saving= new Savings(c1, 500);
            customers.add(c1);
            c1.addAccount(saving);
            
            c1= new Customer(Bank.getNextID(),"hewkwkwkn", "Sisijoan", ( new GregorianCalendar(1997, 7, 9).getTime()));
            saving= new Savings(c1, 500);
            invest= new Investment(c1, 1000, 6);
            customers.add(c1);
            c1.addAccount(saving);
            c1.addAccount(invest);
            
            CustomerFileWriter writer= new CustomerFileWriter();
            
           writer.saveCustomer(customers);
          
           // =============================================
           
           CustomerFileReader reader= new CustomerFileReader();
           System.out.println("Membaca data....");
           //SortedSet<Customer> cust=reader.readCustomer();
           /*
           SortedSet<Customer> customer2= new TreeSet<>(Comparator.comparing(Customer::getCustomerId));
           for(Customer c: cust){       
                customer2.add(c);
                System.out.println(c.getCustomerName());
           }
           System.out.println("Selesai memasukkan data ke Sorted set");
           System.out.println("Print isi sorted set");
           for(Customer c: customer2){
               System.out.println(c.getCustomerName()+ ",  dengan ID" + c.getCustid());
           }
           
           Iterator itrpointer = customer2.iterator();
           while (itrpointer.hasNext()){
               Customer hey= (Customer)itrpointer.next();
               if(hey.getCustid()==(1002)){
                System.out.println(hey.getCustomerName());
                break;
                }
           }
        */
           
        }
       catch(AccountTypeAlreadyExistException dummy){
               System.out.println(dummy.getMessage());
       }
            
       }
       
    
}


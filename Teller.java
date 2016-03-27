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
 * 
 * program berikut ini akan membuat akun dan saldo berdasarkan input dari pengguna. 
 * program akan looping selama pengguna belum menterminasi program
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 6.8
 */
public class Teller
{
    
    /**
    * Awal dari Program
    */
    
    public static void main(String[] args){
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
        
        c1= new Customer("Heya", "Sisijoan", ( new GregorianCalendar(1995, 8, 1).getTime()));
        Bank.addCustomer(c1);
        saving= new Savings(c1, 1000);
        invest= new Investment(c1, 20000, 6);
        c1.addAccount(saving);
        c1.addAccount(invest);
        
        for (int i=0; i<Bank.getNumCust();i++){
                System.out.println("Nama Kustomer: "+ Bank.customer[i].getCustomerName());
                System.out.println("Tanggal lahir: "+Bank.customer[i].getDOB());
                System.out.println("Kustomer ID: "+Bank.customer[i].getCustid()+"\n");
                 for (int j=0; j<Bank.customer[i].getNumOfAccounts();j++){
                System.out.println("Informasi Akun ke " + j);
                System.out.println("Tipe Akun: "+Bank.customer[i].getAcctType(Bank.customer[i].accounts[j]));
                System.out.println("ID: "+Bank.customer[i].getAccount(Bank.customer[i].getAcctType(Bank.customer[i].accounts[j])).getId());
                System.out.println("Balance: "+ Bank.customer[i].accounts[j].getBalance()+"\n");
            }
            
            System.out.println("\n\n");
       }
    }
}

import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.math.*;
/**
 * Kelas khusus coba-coba
 * 
 * @author Erithiana Sisijoan  
 * @version 6.8
 */
    public class Sandbox
    {
       public static void main(String[]args){
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
                
                //saving.addDailyInterest(280);
                //invest.addDailyInterest(280);
                /*
                System.out.println("balance setelah 280 hari     : " + invest.getBalance());
                
                System.out.println("Akun anda berhasil dibuat. Periksa kembali data dibawah ini");
                System.out.println("Nama          : " + c1.getCustomerName());
                System.out.println("balance overdraft      : " + over.getBalance());
                System.out.println("balance savings      : " + saving.getBalance());
                System.out.println("fee      : " + over.getMonthlyFee());
                
                over.withdraw(1600);
                
                System.out.println("balance overdraft      : " + over.getBalance());
                System.out.println("balance savings      : " + saving.getBalance());
                System.out.println("fee      : " + over.getMonthlyFee());
                
                over.withdraw(400);
                
                System.out.println("balance overdraft      : " + over.getBalance());
                System.out.println("balance savings      : " + saving.getBalance());
                System.out.println("fee      : " + over.getMonthlyFee());
                
                
                 System.out.println("Akun anda berhasil dibuat. Periksa kembali data dibawah ini");
                System.out.println("Nama          : " + c1.getCustomerName());
                System.out.println("balance loc      : " + line.getBalance());
                System.out.println("fee      : " + line.getMonthlyFee());
                
                line.withdraw(1000);
                System.out.println("balance loc      : " + line.getBalance());
                System.out.println("fee      : " + line.getMonthlyFee());
                
                line.withdraw(2500);
                System.out.println("balance loc      : " + line.getBalance());
                System.out.println("fee      : " + line.getMonthlyFee());
                
                line.withdraw(1000);
                System.out.println("balance loc      : " + line.getBalance());
                System.out.println("fee      : " + line.getMonthlyFee());
                
                
                System.out.println("status      : " + c1.addAccount(saving));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(saving));
                System.out.println("status      : " + c1.addAccount(saving));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(saving));
                System.out.println("status      : " + c1.addAccount(invest));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(invest));
                System.out.println("status      : " + c1.addAccount(over));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(over));
                System.out.println("status      : " + c1.addAccount(line));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(line));
                System.out.println("status      : " + c1.addAccount(line));
                System.out.println("jenis akun saving adalah      : " + c1.getAcctType(line));
                */
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

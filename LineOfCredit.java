import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Write a description of class LineOfCredit here.
 * 
 * @author erithiana sisijoan
 * @version 8.7
 */
public class LineOfCredit extends Checking
{
    /**
     * variabel untuk balance kredit
     */
   private double creditBalance;
   
   /**
    * variabel untuk limit dari kredit
    */
   private double creditLimit;
   
   /**
    * kontruktor dari kelas LOC
    * 
    * @param cust akun customer
    * @param amount yang akan di masukan
    * @param creditLimit limit dari kredi yang akan digunakan
    */
   public LineOfCredit(Customer cust, double amount, double creditLimit){
      id=cust.getCustomerId()+"";
      setCreditLimit(-1*(creditLimit));
      setBalance(amount);
   }
   
   /**
    * method untuk menghitung biaya tambahkan dari kredit
    */
   public void feeAssessment(){
       int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
       double deficit = creditBalance;
       double amt = deficit * Math.pow((1+ 0.21 / 365),(days));
       this.monthlyFee = amt -  deficit;
   }
   
   /**
    * method untuk mengembalikan balance credit
    * 
    * @return balance kredit
    */
   public double getCreditBalance(){
       return creditBalance;
   }
   
  /**
    * method untuk mengembalikan limit kredit
    * 
    * @return limit kredit
    */
   public double getCreditLimit(){
       return creditLimit;
   }
   
   /**
    * method untuk mengeset balance credit
    * 
    * @param amount balance kredit
    */
   public void setCreditBalance(double amount){
       creditBalance=amount;
   }
   
   /**
    * method untuk mengeset balance credit
    * 
    * @param amount balance kredit
    */
   public void setCreditLimit(double amount){
       creditLimit=amount;
   }
   
    /**
    * method untuk wiithdraw dari LOC
    * 
    * @param amount balance yang diambil
    */
   public void withdraw(double amount)throws AmountOverDrawnException{
       if(amount<=balance){
           balance -= amount;
       }
       else if(amount>balance && creditBalance>creditLimit){
           creditBalance-=(amount-balance);
           balance = 0;
           feeAssessment();
       }
       else{
           throw new AmountOverDrawnException(this);
       }
   }
}

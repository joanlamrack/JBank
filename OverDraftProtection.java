
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverDraftProtection extends Checking
{
   /**
    * variable menyimpan akun saving
    */
   private Savings savingsAccount;
   
   /**
    * konstruktor dari kelas OverDraftProtection
    * 
    * @param cust akun kustomer
    * @param amount jumlah yang akan di set
    * @param saving akun saving
    */
   public OverDraftProtection(Customer cust, double amount, Savings savingsAccount){
       setBalance(amount);
       this.savingsAccount=savingsAccount;
       id=cust.getCustomerId()+"";
   }
   
   /**
    * method untuk menambah fee dengan tiga jika penarikan berhasil
    */
   public void feeAssessment(){
       monthlyFee=monthlyFee+3;
   }
   
   /**
    * method penarikan overdraft
    * 
    * @param amount jumlah yang akan ditarik
    */
   public boolean withdraw(double amount){
       if(amount>(balance + savingsAccount.getBalance()-10)){
           return false;
       }
       else if(amount>balance){
           savingsAccount.withdraw(amount - balance);
           balance=0;
           feeAssessment();
           return true;
       }
       else{
           balance= balance-amount;
           return true;
       }
   }
   
}

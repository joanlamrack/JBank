
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author erithiana sisijoan
 * @version 8.7
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
   public void withdraw(double amount)throws AmountOverDrawnException{
       if(amount>(balance + savingsAccount.getBalance()-10)){
           throw new AmountOverDrawnException(this);
       }
       else if(amount>balance){
           savingsAccount.withdraw(amount - balance);
           balance=0;
           feeAssessment();
       }
       else{
           balance= balance-amount;
       }
   }
   
}

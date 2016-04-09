
/**
 * Kelas yang mewakili saving, ektensi dari Account
 * 
 * @author Erithiana Sisijoan
 * @version 6.3
 */
public class Savings extends Account
{
    /**
     * variabel untuk menyimpan bunga yang didapatkan 
     */
    protected double interestEarned;
    
    /**
     * kontrukstor untuk kelas Savings
     * 
     * @param cust akun customer
     * @param amount jumlah yang akan dimasukkan
     */
    public Savings(Customer cust, double amount){
        super();
        id=cust.getCustomerId()+"";
        if(amount>=10){
            setBalance(amount);
        }
    }
    
    /**
     * metode getter untuk pengambilan bunga
     * 
     * @return bunga yang didapatkan
     */
    public double getInterestEarned(){
        return interestEarned;
    }
    
    /**
     * method untuk menarik balance dari savings
     * 
     * @param amount jumalah yang akan ditarik
     */
    public boolean withdraw(double amount){
        double checkDrawBalance= balance - amount;
        if (checkDrawBalance<0||amount<0){
            return false;
        }
        else{
            this.balance=balance-amount;
            return true;
        }
    }
    
     /**
       * Method berikut ini menunjukan balance dari akun saving setelah mendapat bunga majemuk 3% selama setahun,
       * dimana bunga dihitung tiap harinya.
       * 
       * @param days hari bunga
       */
    public void addDailyInterest(int days){
        double f= balance*(Math.pow((1+(0.03/365)),(days)));
        this.interestEarned= f-balance;
        balance=f;
    }
    
}

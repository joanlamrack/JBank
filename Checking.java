
/**
 * Abstract class Checking - 
 * 
 * @author erithiana sisijoan
 * @version 6.8
 */
public abstract class Checking extends Account
{
    /**
     * variabel biaya bulanan
     */
    protected double monthlyFee;
    
    protected void feeAssessment(){
    
    }
    
    /**
     * method untuk mereset biaya bulanan
     */
    public void resetMonthlyFee(){
        monthlyFee=0;
    }
    
    /**
     * method untuk mengembalikan biaya bulanan
     * 
     * @return biaya bulanan
     */
    public double getMonthlyFee(){
        return monthlyFee;
    }
}

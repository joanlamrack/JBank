
/**
 * Write a description of class Teller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teller
{
    // instance variables - replace the example below with your own
    private Customer c1=new Customer();
    private Account a1 = new Account();
    public String printout;
    private Account akun1;
    private double balance, balance2;
    
   
    public static void main(String[] args){
    
    }

    public Teller(){
    c1.setName("sanadhi","sutandi");
    printout=c1.getCustomerName();
    System.out.println(printout);
    
    
    a1.setBalance(1000);
    balance=a1.getBalance();
    System.out.println(balance);
    
    c1.setAccount(a1);
    akun1=c1.getAccount();
    balance2=akun1.getBalance();
    System.out.println(balance2);
    }
    
    
    /**
     * Constructor for objects of class Teller
     */
 

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

}

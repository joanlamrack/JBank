
/**
 * Merepresentasikan Akun Bank, dapat di Assign kepada Kustomer.
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 2.3 (Javadoc Session)
 */
public class Teller
{
    // instance variables - replace the example below with your own
    private Customer c1=new Customer();
    private Account a1 = new Account();
    public String printout;
    private Account akun1;
    private double balance, balance2;
   
    /**
     * Awal dari Program
     */
    public static void main(String[] args){
    }
    /* Legend:
     * (1) Customer object named c1 using setname Method to enter names
     * (2) using string variable named printout to contain return value of c1's
     * getCustomerName
     * (3) Print the result
     * 
     * Second Legend:
     * (4) Account object named a1 using setBalance Method to enter balance value
     * (5) using float variable named balance to contain return value of a1's
     * getBalance
     * (6) Print the result
     * 
     * Third Legend:
     * (7) Account object named c1 using setAccount Method to assign c1 to a1
     * (8) using Account-type variable named akun1 to contain return value of c1's
     * getAccount
     * (9) using float variable named balance2 to contain return value of akun1's
     * getBalance()
     * (10) Print the result

     */
    public Teller(){
    c1.setName("sanadhi","sutandi");// (1)
    printout=c1.getCustomerName();// (2)
    System.out.println(printout);//(3)
    
    a1.setBalance(1000);//(1)
    balance=a1.getBalance();//(2)
    System.out.println(balance);//(3)

    c1.setAccount(a1);//(1)
    akun1=c1.getAccount();//(2)
    balance2=akun1.getBalance();//(3)
    System.out.println(balance2);//(4)
    }
}

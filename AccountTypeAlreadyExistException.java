
/**
 * Write a description of class AccountTypeAlreadyExistException here.
 * 
 * Kelas yang mewakili exception yang mengatasi duplikat akun pada customer
 * 
 * @author erithiana sisijoan
 * @version 8.7
 */
public class AccountTypeAlreadyExistException extends java.lang.Exception
{
    /**
     * Class variable untuk menyimpan Object Account
     */
    public Account akun;
    
    /**
     * Method konstruktor untuk exception
     * 
     * @param akun Account yang akan dijadikan parameter
     */
    public AccountTypeAlreadyExistException(Account akun){
        super("Unable to create duplicate account of type ");
        this.akun=akun;
    }
    
    /**
     * Method untuk Pesan error yang terjadi pada Exception
     * 
     * @return pesan error
     */
    public String getMessage(){
        String messageOut="Error";
        if(this.akun instanceof Savings && akun instanceof Investment==false){
            messageOut="Savings";
        }
        else if (this.akun instanceof Investment && akun instanceof Investment==true){
            messageOut="Investment";
        }
        else if (this.akun instanceof LineOfCredit){
            messageOut="Line-Of-Credit";
        }
        else if (this.akun instanceof OverDraftProtection){
            messageOut="Overdraft";
        }
        return super.getMessage()+ messageOut;
    }
}

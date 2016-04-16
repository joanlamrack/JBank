
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * kelas yang mewakili exception jika penarikan melebihi saldo yang ada pada akun
 * 
 * @author erithiana sisijoan
 * @version 8.7
 */
public class AmountOverDrawnException extends java.lang.Exception
{
    /**
     * Class variable untuk menyimpan akun
     */
    public Account akun;
    
    /**
     * Method construktor untuk AccountTypeNotFoundException
     * 
     * @param akun Account yang akan dijadikan parameter
     */
    public AmountOverDrawnException(Account akun){
        super("Insufficient funds");
        this.akun=akun;
    }
    
    /**
     * method untuk mengembalikan pesan error
     * 
     * @return pesan error
     */
    public String getMessage(){
        String messageOut="Error";
        if(this.akun instanceof Savings && akun instanceof Investment==false){
            messageOut=" In savings Account";
        }
        else if (this.akun instanceof Investment && akun instanceof Investment==true){
            messageOut=" In Investment Account";
        }
        else if (this.akun instanceof LineOfCredit){
            messageOut=" In Line-Of-Credit Account";
        }
        else if (this.akun instanceof OverDraftProtection){
            messageOut=" In Overdraft Protect Account";
        }
        return super.getMessage()+ messageOut;
    }
}

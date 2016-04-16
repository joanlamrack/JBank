
/**
 * Write a description of class AccountTypeNotFoundException here.
 * 
 * kelas yang mewakili exception jika tidak ada akun dengan tipe yang dicari
 * 
 * @author erithiana sisijoan 
 * @version 8.7
 */
public class AccountTypeNotFoundException extends java.lang.Exception
{
    /**
     * Class variable untuk menyimpan karakter tipe akun
     */
    public char akun;
    
    /**
     * Method construktor untuk AccountTypeNotFoundException
     * 
     * @param akun tipe Account dalam char (S=savings, I=investment, L=LineOfCredit, O=overdraft)
     */
    public AccountTypeNotFoundException(char akun){
        super("Account does not exist ");
        this.akun=akun;
    }
    
    /**
     * method untuk mengembalikan pesan error
     * 
     * @return pesan error
     */
     public String getMessage(){
        String messageOut="Error";
        if(this.akun=='S'){
            messageOut="Savings";
        }
        else if (this.akun=='I'){
            messageOut="Investment";
        }
        else if (this.akun=='L'){
            messageOut="Line-Of-Credit";
        }
        else if (this.akun=='O'){
            messageOut="Overdraft";
        }
        return messageOut + super.getMessage();
    }
}

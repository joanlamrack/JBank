
/**
 * Exception handling untuk Customer yang tidak ditemukan
 * 
 * @author Erithiana Sisijoan 
 * @version 10
 */
public class CustomerNotFoundException extends Exception
{

    /**
     * Method construktor untuk AccountTypeNotFoundException
     * 
     * @param Id kustomer
     */
    public CustomerNotFoundException(int ID)
    {
        super("Customer" + ID +" not Found");
    }

    /**
     * method untuk mengembalikan pesan error
     * 
     * @return pesan error
     */
    public String getMessage(){
        return super.getMessage();
    }
}

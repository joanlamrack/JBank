import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Mewakili Kelas Kustomer yang berisi informasi tentang Kustomer serta akun
 * 
 * @author Erithiana Sisijoan
 * @version 2.4 (Javadoc Session & Business Rules)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private Account accounts =new Account();
    private String cityAddress;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
    }
    public Customer(String fname, String lname, String dob){
        
    }
    public Customer(String firstName, String lastName, String dateOfBirth, int custId){
        
    }
     /**
     * menyatukan data jalan, kota dan kode pos menjadi satu rangkaian string alamat
     * 
     * @return     gabungan dari string streetAddress, cityAddress dan zipOrPostalCode
     * berurutan
     */
    private String getAddress(){
        return streetAddress+" "+ cityAddress +" "+ zipOrPostalCode;
    }
    /**
     * mengambil account yang tersimpan
     * 
     * @return  akun yang tersimpan
     */
    public Account getAccount(){
        return accounts;
    }
    /**
     * mengambil customer id yang tersimpan
     * 
     * @return  ID dari customer
     */
    private int getCustomerId(){
        return custId;
    }
    /**
     * mengambil data email
     * 
     * @return  nama email yang tersimpan dalam bentuk string
     */
    public String getEmail(){
        return email;
    }
     /**
     * mengambil nama kustomer dari gabungan nama depan dan belakang
     * 
     * @return  nama belakang kustomer, nama depan kustomer
     */
    public String getCustomerName(){
        return lastName + " , " + firstName;
    }
     /**
     * menunjukan jumlah akun yang sudah dibuat
     * 
     * @return  jumlah akun
     */
    public int getNumOfAccounts(){
        return numberOfCurrentAccounts;
    }
     /**
     * mengambil data nomor telepon
     * 
     * @return  nomor telepon dari kustomer
     */
    private String getPhoneNumber(){
        return phoneNumber;
    }
     /**
     * membuat data alamat dengan input jalan, kota dan kode pos, dan memasukan input ke
     * variabel yang bersangkutan
     * 
     * @param street alamat-nama jalan
     * @param city alamat-nama kota
     * @param code alamat-kode pos
     * @return none
     */
    private void setAddress(String street, String city, String code){
        streetAddress= street;
        cityAddress=city;
        zipOrPostalCode=code;
    }
    /**
     * membuat data email kustomer, dimasukkan ke variable email. Menvalidasi format
     * tulisan email pada umumnya dengan menggunakan regex. pada terminal akan bernilai true
     * jika penulisan sesuai.
     * 
     * @param emailAddress email kustomer
     * @return none
     */
    public void setEmail(String emailAddress){
        String regex="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        System.out.println(emailAddress +" : "+ matcher.matches());
        if (matcher.matches()==true){
            email=emailAddress;
        }
}
    /**
     * membuat data nama kustomer, dimasukkan ke dua variabel untuk memisahkan
     * nama depan dan belakang
     * 
     * @param lname nama keluarga kustomer
     * @param fname nama depan kustomer
     * @return none
     */
    public void setName(String lname, String fname){
        lastName=lname;
        firstName=fname;
    }
     /**
     * untuk memasukkan nomor telepon baru, phoneNum dimasukkan dalam string phoneNumber
     * 
     * @param  phoneNum   nomor telepon dalam bentuk string ""
     * @return  none
     */
    private void setPhoneNumber(String phoneNum){
        phoneNumber=phoneNum;
    }
    /**
     * To set an account
     * 
     * @param  akun nama akun yang akan ditambah
     * @return none
     */
    public void setAccount(Account akun){
        accounts=akun;
    }
}
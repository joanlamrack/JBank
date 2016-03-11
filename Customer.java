import java.util.regex.Matcher; // library untuk regular expression, matcher dan pattern 
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.util.Date;
/**
 * Mewakili Kelas Kustomer yang berisi informasi tentang Kustomer serta akun
 * 
 * @author Erithiana Sisijoan
 * @version 4.2.1 (String and Date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    /**
     * membuat objek Account dengan nama accounts
     */
    private Account accounts =new Account();

    /**
     * Variable untuk menyimpan nama kota
     */
    private String cityAddress;
    
    /**
     * Variable untuk menyimpan id kustomer
     */
    private int custId;
    
    /**
     * Variable untuk menyimpan tanggal lahir kustomer
     */
    private Date dateOfBirth;
    
    /**
     * Variable untuk menyimpan tanggal lahir kustomer
     */
    private String email;
    
    /**
     * Variable untuk menyimpan name depan kustomer
     */
    private String firstName;
    
    /**
     * Variable untuk menyimpan tanggal lahir kustomer
     */
    private String lastName;
    
    /**
     * Variable untuk menyimpan jumlah maksimal kustomer yang dapat dibuat
     */
    private int numberOfCurrentAccounts;
    
    /**
     * Variable untuk menyimpan jalan tempat tinggal kustomer
     */
    private String streetAddress;
    
    /**
     * Variable untuk menyimpan nomor telepon kustomer
     */
    private String phoneNumber;
    
    /**
     * Variable untuk menyimpan Kode pos kustomer
     */
    private String zipOrPostalCode;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
    }
    
     /**
     * Constructor method dengan input nama depan, nama belakang dan tanggal lahir, serta mengambil ID secara langsung
     * @param firstName nama depan
     * @param lastName nama belakang
     * @param dateOfBirth tanggal tempat lahir
     */
    public Customer(String firstName, String lastName, Date dateOfBirth){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.custId=Bank.getNextID();//mengambil nexid dari kelas static Bank dengan memanggil nama kelas secara langsung
    }
    
     /**
     * Constructor method untuk Customer dengan input nama depan dan belakang saja
     * @param firstName nama depan
     * @param lastName nama belakang
     */
     public Customer(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=null;
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
     * pertama kali, masukan kriteria regex pada string,
     * kemudian pattern akan mengambil pola dari string kriteria tersebut
     * matcher akan mencocokan pola tersebut dengan string input.
     * 
     * jika sesuai, maka input akan di masukkan ke variabel class
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
    private void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
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
    
    /**
     * To set Customer id
     * 
     * @param custId Id kustomer yang akan di assign
     * @return none
     */
    public void setCustId(int custId){
        this.custId=custId;
    }
    
     /**
     * Metode getter untuk customer id
     * 
     * @return Id kustomer
     */
    public int getCustid(){
        return custId;
    }
    
    /**
     * Metode Getter untuk Tanggal lahir Kustomer
     * 
     * @return tanggal lahir kustomer
     */
    public Date getDOB(){
        return dateOfBirth;
    }
    
}
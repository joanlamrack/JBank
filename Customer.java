import java.util.regex.Matcher; // library untuk regular expression, matcher dan pattern 
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.util.Date;
import java.io.Serializable;
/**
 * Mewakili Kelas Kustomer yang berisi informasi tentang Kustomer serta akun
 * 
 * @author Erithiana Sisijoan
 * @version 8.7
 */
public class Customer implements Serializable
{
    /**
     * membuat objek Account dengan nama accounts
     */
    public Account[] accounts=new Account[4];

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
     * Constructor method dengan input nama depan, nama belakang dan tanggal lahir, serta mengambil ID secara langsung
     * @param firstName nama depan
     * @param lastName nama belakang
     * @param dateOfBirth tanggal tempat lahir
     */
    public Customer(int custId, String firstName, String lastName, Date dateOfBirth, String cityAddress, String streetAddress, String phoneNumber, String zipOrPostalCode, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.custId=custId;//mengambil nexid dari kelas static Bank dengan memanggil nama kelas secara langsung
        this.cityAddress=cityAddress;
        this.streetAddress=streetAddress;
        this.phoneNumber=phoneNumber;
        this.zipOrPostalCode=zipOrPostalCode;
        setEmail(email);
    }
    
     /**
     * Constructor method untuk Customer dengan input nama depan dan belakang saja
     * @param firstName nama depan
     * @param lastName nama belakang
     */
     public Customer(int custId, String firstName, String lastName, Date dateOfBirth){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.custId=custId;
        System.out.println("Creating customer"+ firstName +" "+ lastName+" "+dateOfBirth + " with ID " + this.custId);
        (new LogData()).write((Bank.lastCustID+1)+"");
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
     * mengambil account yang tersimpan dari array
     * 
     * @param type tipe akun yang akan diambil dari array
     * @return  akun yang tersimpan
     */
    public Account getAccount(char type)throws AccountTypeNotFoundException{
        for (int i=0; i<4; i++){
                if(accounts[i]!=null){  
                   if(type==getAcctType(accounts[i])){
                       return accounts[i];
                   }
                }
         }
        throw new AccountTypeNotFoundException(type);
    }
    
    /**
     * Menghapus akun dari kustomer dari array
     * 
     * @param type tipe akun yang akan dihapus dari array
     * @return mengembalikan status dari mrhod, jika true maka akun terhapus, jika tidak makan akun tidak terhapus
     */
    public boolean removeAccount(char type){
        for (int i=0; i<4; i++){
                if(accounts[i]!=null){  
                   if(type==getAcctType(accounts[i])){
                       accounts[i]=null;
                       this.numberOfCurrentAccounts--;
                       return true;
                   }
                }
         }
        return false;
    }
    
    /**
     * mengambil customer id yang tersimpan
     * 
     * @return  ID dari customer
     */
    public int getCustomerId(){
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
        //System.out.println(emailAddress +" : "+ matcher.matches());
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
     * Mengassign akun customer ke akun. akun yang di assign pada customer tidak boleh memiliki ID sama
     * 
     * @param  akun nama akun yang akan ditambah
     * @return status dari method, true jika akun ditambahkan, false jika akun tidak di tambahkan
     *
     */
    public void addAccount(Account akun)throws AccountTypeAlreadyExistException{
        /**
         * Variabel lokal untuk boolean akun dimasukan ke array atau tidak
         */
        if (getNumOfAccounts()<5){
            if(checkMultiAccount(akun)==false){
                accounts[numberOfCurrentAccounts]=akun;
                numberOfCurrentAccounts++;
            }
            else if (checkMultiAccount(akun)==true){
                throw new AccountTypeAlreadyExistException(akun);
            }
        }
        else{
            throw new AccountTypeAlreadyExistException(akun);
        }
    }
    
    /**
     * Check for multiple account type
     * 
     * @param akun account yang akan dicheck tipenya
     * @return status dari method, true jika menemukan akun yang sama, false jika tidak ada akun yang sama.
     */
    public boolean checkMultiAccount(Account akun){
         for (int i=0; i<4; i++){
                if(accounts[i]!=null){  
                   if(getAcctType(akun)==getAcctType(accounts[i])){
                       return true;
                   }
                }
         }
         return false;
    }
   
   /**
     * Mengetahui tipe dari suatu akun, untuk menentukan sifat dari akun tersebut
     * 
     * @return tipe dari akun
     */
   public char getAcctType(Account akun){
        char acctType='M';
        if(akun instanceof Savings==true && akun instanceof Investment==false){
            acctType='S';
        }
        else if(akun instanceof Investment==true && akun instanceof Investment==true){
            acctType='I';
        } 
        else if(akun instanceof OverDraftProtection==true){
            acctType='O';
        }
        else if(akun instanceof LineOfCredit==true){
            acctType='L';
        }
        else{
            //do nothing
        }
        return acctType;
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
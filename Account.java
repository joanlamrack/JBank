
/**
 * Mewakili Kelas Akun yang berhubungan dengan balance dan tipe akun
 * 
 * @author Erithiana Sisijoan Koesnadi 
 * @version 2.4 (Javadoc Session & Business Rules)
 */
public class Account
{
    // instance variables - replace the example below with your own
    private char acctType;
    private double balance, checkDrawBalance;
    private String id;
    /**
     * Constructor for objects of class Account
     */
    public Account()
    {
    }
    public Account(char type, double amount){
        
    }
      /**
     * Operasi deposit pada suatu akun, balance yang ada akan ditambahkan
     * dengan jumlah deposit.
     * Jika jumlah yang dimasukan bernilai minus
     * atau sama dengan nol, input ditolak
     * 
     * @param  amount jumlah uang yang akan dimasukkan
     */
    public void deposit(double amount){
    if (amount>0|amount!=0){
        balance=balance + amount;
    }
}
     /**
     * Mengetahui tipe dari suatu akun, untuk menentukan sifat dari akun tersebut
     * 
     * @return tipe dari akun
     */
    public char getAcctType(){
        return acctType;
    }
    /**
     * Mengetahui balance dari suatu akun saat ini
     * 
     * @return jumlah uang yang ada ditabungan
     */
    public double getBalance(){
       return balance;
    }
     /**
     * Mengetahui ID dari suatu akun
     * 
     * @return ID dari tabungan
     */
    public String getId(){
        return id;
    }
    /**
     * Mengeset Balance berdasarkan uang yang ada, membuka tabungan dengan
     * dana awal
     * 
     * @param amount jumlah pertama kali membuka tabungan
     */
    public void setBalance(double amount){
        balance = amount;
    }
     /**
     * mengeset Id Akun, memasukkan id tersebut kedalam variabel
     * 
     * @param acctId ID dalam bentuk string
     */
    public void setID(String acctId){
        id = acctId;
    }
     /**
     * Mengeset tipe dari suatu akun
     * 
     * @param type tipe dari tabungan, 'L'(Tipe line of kredit),
     * 'O' (tipe overdraft), 'S'(tipe saving/biasa) dan 'I' (investment)
     */
    public void setAcctType(char type){
        acctType = type;
    }
    /**
     * Method untuk mengambil uang dalam suatu akun dengan jumlah sesuai input
     * uang dalam akun akan berkurang. jika jumlah yang diambil
     * melebihi jumlah uang dalam akun, transaksi ditolak.
     * @param amount jumlah uang yang akan di ambil
     */
    public void withdraw(double amount){
        checkDrawBalance= balance - amount;
        if (checkDrawBalance<0){
        //do nothing
        }
        else{
            balance=balance-amount;
        }
    }
}

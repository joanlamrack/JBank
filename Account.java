
/**
 * Mewakili Kelas Akun yang berhubungan dengan balance dan tipe akun
 * 
 * @author Erithiana Sisijoan Koesnadi 
 * @version 3.4.1 (Classes Session: Indentation)
 */
public class Account
{
    // instance variables - replace the example below with your own
    /**
     * Deklarasi tipe Akun dengan tipe CHAR
     */
    private char acctType;
    
    /**
     * Deklarasi saldo dan pemeriksaan saldo dengan tipe double
     */
    private double balance, checkDrawBalance;
    
    /**
     * deklarasi untuk ID akun
     */
    private String id;
    
    /**
     * Constructor for objects of class Account
     */
    public Account()
    {
        acctType = 'S';
        balance=20.00;
    }
    
    /**
     * Method constructor dengan input tipe akun dan saldo
     * @param type tipe akun yang akan dibuat
     * @param amount jumlah saldo awal
     */
    public Account(char type, double amount){
        if(type=='S'|type=='O'|type=='L'|type=='I'){
            if(amount>0){
                acctType=type;
                balance=amount;
            }
        }
    }
    
    /**
     * Operasi deposit pada suatu akun, balance yang ada akan ditambahkan
     * dengan jumlah deposit.
     * Jika jumlah yang dimasukan bernilai minus
     * atau sama dengan nol, input ditolak
     * 
     * @param  amount jumlah uang yang akan dimasukkan
     */
    public boolean deposit(double amount){
        if(amount<0){
            return false;
        }
            else if (amount>0|amount!=0){
                balance=balance + amount;
                return true;
            }
                else{
                    return false;
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
    public boolean withdraw(double amount){
        checkDrawBalance= balance - amount;
        if (checkDrawBalance<0|amount<0){
            return false;
        }
        else{
             balance=balance-amount;
            return true;
        }
    }
    
}

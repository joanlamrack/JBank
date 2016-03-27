
/**
 * Mewakili Kelas Akun yang berhubungan dengan balance dan tipe akun
 * 
 * @author Erithiana Sisijoan Koesnadi 
 * @version 5.4 (Arrays)
 */
public abstract class Account
{
    // instance variables - replace the example below with your own
    
    /**
     * Deklarasi saldo dan pemeriksaan saldo dengan tipe double
     */
    protected double balance, checkDrawBalance;
    
    /**
     * deklarasi untuk ID akun
     */
    protected String id;
    
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
    
    public String toString(){
        return id;
    }
    
    /**
     * Mengeset Balance berdasarkan uang yang ada, membuka tabungan dengan
     * dana awal
     * 
     * @param amount jumlah pertama kali membuka tabungan
     */
    public void setBalance(double amount){
        if(amount>0){
                balance=amount;
        }
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
            this.balance=balance-amount;
            return true;
        }
    }
    
}

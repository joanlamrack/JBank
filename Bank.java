
/**
 * Mewakili kelas Bank yang mengandung informasi mengenai Bank
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 3.4.1 (Classes Session: fixed getNextid() Logic)
 */
public class Bank
{
    // instance variables - replace the example below with your own
    /**
     * variabel Menyimpan bunga dari credit
     */
    private static double creditInterestRate;
    
    /**
     * variabel menyimpan waktu tutup bank
     */
    private static String closeTime;
    
    /**
     * variabel menyimpan waktu tutup bank
     */
    private static double investmentInterestRate; 
    
    /**
     * variabel menyimpan nilai awal id kustomer
     */
    private static int lastCustID=1000;
    private static int nextCustID=1000;
    
    /**
     * variabel menyimpan nomor telepon bank
     */
    private static String phone;
    
    /**
     * variabel menyimpan bunga premium bank
     */
    private static double premiumInterestRate;
    
    /**
     * variabel menyimpan waktu buka bank
     */
    private static String startTime;
    
    /**
     * variabel menyimpan situs website bank
     */
    public static String website;
    
    /**
     * variabel menyimpan alamat bank
     */
    public static String bankAddress="1234 JavaStreet, Anycity, ThisState, 34567";
    
    /**
     * variabel menyimpan jumlah maksimal kustomer yang dapat dibuat oleh bank
     */
    public static int maxNumOfCustomers= 20;
    
    /**
     * variabel menyimpan nama bank
     */
    public static String bankName="JBANK";
    
    /**
     * variabel menyimpan jumlah kustomer bank saat ini
     */
    public static int numOfCurrentCustomer;
    
    /**
     * variabel menyimpan variable untuk id kustomer
     */
    private static int nextID=1000;
    
    /**
     * Constructor for objects of class Bank
     */
    private Bank(){
    }
    
    /**
     * getAddress - Method untuk mengambil alamat bank yang ada pada variabel bankAddress
     * @return String   alamat bank
     */
    /*
    public static String getAddress(){
        return bankAddress;
    }
    */
    /**
     * Mengambil data  persenan bunga
     * 
     * @return double   bunga bank
     */
    
    public static double getCreditRate(){
        return creditInterestRate;
    }
    
     /**
     * Mengambil data bunga bank tipe akun Investment 
     * 
     * @return double   bunga bank tipe Investment
     */
    public static double getInvestmentRate(){
        return investmentInterestRate;
    }
    
     /**
     * Menghitung Lama bank beroperasi dalam satuan jam 
     * 
     * @return String   jam operasi bank
     */
    public static String getHoursOfOperation(){
        return null;
    }
    
    /**
     * Mengambil ID terakhir
     * 
     * @return int  ID terakhir
     */
    public static int getLastID(){
    return lastCustID;
    }
    
     /**
     * Mengambil data berapa jumlah maksimal kustomer yang dapat dilayani
     *
     * @return jumlah   maksimum kustomer
     */
    public static int getMaxCustomers(){
        return maxNumOfCustomers;
    }
    /**
     * Menunjukkan nama Bank
     * 
     * @return String   nama bank
     */
    /*
    public static String getName(){
        return bankName;
    }
    */
    /**
     * Menunjukkan ID kustomer berikutnya. semua akun dimulai dari angka 1000.
     * customer ke -n akan mendapatkan id 1000+n
     * jika jumlah kustomer sudah penuh, maka tidak akan membuat id lagi
     * 
     * @return int  ID kustomer berikutnya
     */ 
    public static int getNextID(){
        nextCustID=lastCustID+1;
        if( numOfCurrentCustomer==maxNumOfCustomers){
            nextID=0;
        }
        else if(nextCustID==0){
            nextCustID=1000;
            numOfCurrentCustomer++;
            nextCustID=nextCustID;
        }
        else{
            nextID=nextCustID;
            lastCustID=nextCustID;
            numOfCurrentCustomer++;
        }
        return nextID;
    }
    
     /**
     * Menunjukkan data website dari bank
     * 
     * @return String   untuk alamat website bank
     */   
    public static String getWebsite(){
        return website;
    }
    
     /**
     * Mengembalikan Persen bunga untuk akun tipe Premium
     * 
     * @return persen   bunga dari premium 
     */
    public static double getPremiumRate(){
        return premiumInterestRate;
    }
    
    /**
     * Mengembalikan data Nomor telepon Bank
     * 
     * @return Nomor    Telepon Bank
     */
    public static String getPhone(){
        return phone;
    }
    
    /**
     * Mengeset Bunga kredit, dimasukkan dalam variabel creditInterestRate
     * 
     * @param rate  bunga kredit dalam bentuk decimal
     */
    public static void setCreditRate(double rate){
        creditInterestRate=rate;
    }
    
     /**
     * Mengeset Persen Bunga dari tipe akun Investment, dimasukkan kedalam
     * variabel investInterestRate
     * 
     * @param rate  persen bunga investment
     */
    public static void setInvestmentRate(double rate){
        investmentInterestRate=rate;
    }
    
    /**
     * Mengeset Besar Bunga bank untuk tipe akun Premium, dimasukkan dalam
     * variabel premiumInterestRate
     * 
     * @param rate  Besar Bunga Bank Premium
     */
    public static void setPremium(double rate){
       premiumInterestRate=rate;
    }
    /*
    public static int getNumOfCurrentCustomer(){
        return numOfCurrentCustomer;
    }
    */
}

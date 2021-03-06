import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.math.*;
import java.io.*;
/**
 * Mewakili kelas Bank yang mengandung informasi mengenai Bank
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 5.4 (Arrays)
 */
public class Bank implements Serializable
{
    // instance variables - replace the example below with your own
    /**
     * variabel Menyimpan bunga dari credit
     */
    private static double creditInterestRate;
    
    /**
     * variabel menyimpan waktu tutup bank
     */
    private static Date closeTime;
    
    /**
     * variabel menyimpan bunga dari akun investment
     */
    private static double investmentInterestRate; 
    
    /**
     * variabel menyimpan nilai awal id kustomer
     */
    public static int lastCustID=1000;
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
    private static Date startTime;
    
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
    private static int maxNumOfCustomers;

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
    public static int nextID=1000;
    
    /**
     * variabel untuk array customer
     */
    public static ArrayList<Customer> customer; 
    
    /**
     * Static Initializer block
     * 
     * mengeset jumlah maximum customer yang dapat di buat dalam array
     */
    static {
        System.out.println("Enter Max number of customer");
        Scanner trial = new Scanner(System.in);
        maxNumOfCustomers=3;//trial.nextInt();
        
        //CustomerFileReader reader= new CustomerFileReader();
        LogData logdata= new LogData();
        
        //customer= new TreeSet<>(Comparator.comparing(Customer::getCustomerId));
        customer= new ArrayList<Customer>();

        try{
            logdata.readFile();
                
        
        }
        catch(IOException e){
            // do nothing
        }

        
    }
    
    /**
     * untuk Mengecek jumlah customer yang dibuat
     */
    public static int numCust;
    
    /**
     * Constructor for objects of class Bank
     */
    private Bank(){
    }
    
    /**
     * getAddress - Method untuk mengambil alamat bank yang ada pada variabel bankAddress
     * @return String   alamat bank
     */
    
    public static String getAddress(){
        return bankAddress;
    }
    
    /**
     * Method untuk menambahkan objek customer ke dalam array
     * 
     * @param cust kustomer yang akan ditambahkan
     * @return status dari method, true jika ditambakan, false jika tidak
     */
    public static boolean addCustomer(Customer cust){
            if (numCust<maxNumOfCustomers){
                customer.add(cust);
                numCust++;
                return true;
            }
            else {
                return false;
            }
    }
   
    /**
     * method tambahan untuk mengambil variable numCust
     * 
     * @return jumlah kustomer saat ini
     */
    public static int getNumCust(){
        return numCust;
    }
    
    /**
     * Method to get customer objek based on ID
     * 
     * @param custID cust di yang akan dicari.
     * @return akun kustomer dengan id yang sama dengan parameter
     */
    public static Customer getCustomer(int custID) throws CustomerNotFoundException{
        Iterator itrpointer = customer.iterator();
        Customer found=null;
        while (itrpointer.hasNext()){
           found= (Customer)itrpointer.next();
           if(found.getCustid()==(custID)){ 
               break;
           }
           
        }
        if(found.getCustid()!=custID){
            found=null;
            throw new CustomerNotFoundException(custID);
        }
        return found;
    }
    
    /**
     * method untuk ambil nilai integer dari maxNumOfCustomer
     * 
     * @return jumlah maksimum kustomer yang dapat dibuat
     */
    public static int getMaxNumOfCustomers(){
        return maxNumOfCustomers;
    }
    
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
     * Mereturn jam operasional Bank dalam bentuk string
     * 
     * @return String   jam operasi bank
     */
    public static String getHoursOfOperation(){
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        String start1 = df.format(getStartTime());
        String close1 = df.format(getCloseTime());
        return start1 + " TO " + close1;
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
    
    public static String getName(){
        return bankName;
    }
    
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
        
        System.out.println("Nextid "+nextID+"\n nextcustid: "+nextCustID+"\nlastCustId: "+lastCustID);
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
    
    /**
     * Untuk mendapatkan jumlah customer saat ini
     * 
     * @return jumlah customer saat ini
     */
    public static int getNumOfCurrentCustomer(){
        return numOfCurrentCustomer;
    }
   
    /**
     * Method untuk mengembalikan Waktu buka Bank dalam bentuk date
     * 
     * @return waktu jam buka
     */
    public static Date getStartTime(){
        return startTime;
    }
   
    /**
     * Method untuk mengeset Waktu buka Bank. Dengan parameter jam dan menit dalam bentuk integer.
     * Misal: jika bank buka jam 07:00, maka jam=7, menit=0
     * 
     * @param jam jam berapa bank buka 
     * @param menit Menit keberapa dia akan buka 
     */
    public static void setStartTime(int jam, int menit){
        Calendar currentTime = new GregorianCalendar();
        startTime=new GregorianCalendar(currentTime.get(Calendar.YEAR), currentTime.get(Calendar.MONTH), currentTime.get(Calendar.DATE), jam, menit).getTime();
    }
    
    /**
     * Method untuk mengembalikan Waktu tutup Bank dalam bentuk date
     * 
     * @return waktu jam tutup
     */
    public static Date getCloseTime(){
        return closeTime;
    }
    
    /**
     * Method untuk mengeset Waktu tutup Bank. Dengan parameter jam dan menit dalam bentuk integer.
     * Misal: jika bank tutup jam 21:30, maka jam=21, menit=30
     * 
     * @param jam jam berapa bank tutup 
     * @param menit Menit keberapa akan tutup 
     */
    public static void setCloseTime(int jam, int menit){
        Calendar currentTime = new GregorianCalendar();
        closeTime=new GregorianCalendar(currentTime.get(Calendar.YEAR), currentTime.get(Calendar.MONTH), currentTime.get(Calendar.DATE), jam, menit).getTime();
    }
    
    /**
     * Method lokal untuk mengeset Waktu tutup dan buka bank dengan input integer. input ini kemudian di pass ke method lainnya dengan fungsi mengeset
     * waktu buka dan tutup secara terpisah.
     * 
     * @param jamBuka jam berapa bank buka 
     * @param menitBuka Menit keberapa dia akan buka 
     * @param jamTutup jam berapa bank tutup 
     * @param menitTutup Menit keberapa akan tutup 
     */
    public static void setCloseOpenTime(int jamBuka, int menitBuka, int jamTutup,int menitTutup){
        setCloseTime(jamTutup, menitTutup);
        setStartTime(jamBuka, menitBuka);
    }
    
    
    public static void saveCustomer(){
         CustomerFileWriter writer= new CustomerFileWriter();   
         writer.saveCustomer(customer);
    }
}

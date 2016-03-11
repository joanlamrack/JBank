import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * 
 * program berikut ini akan membuat akun dan saldo berdasarkan input dari pengguna. 
 * program akan looping selama pengguna belum menterminasi program
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 4.2.1 (String and Date)
 */
public class Teller
{
    
    /**
     * Awal dari Program
     */

    public static void main(String[] args){
        setCloseOpenTime(7, 0, 21,0);                                             //Set Waktu buka dan tutup bank dengan method dalam kelas yang sama 
        Date current=new GregorianCalendar().getTime();                           //Mengeset variable Date (dan waktu) saat ini agar dapat dibandingkan dengan waktu buka/tutup bank
        
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        
        /**
         * If dibawah berikut ini adalah fungsi pengecekan apakah waktu saat ini masih dalam jam buka bank, menggunakan method Date .equals, .before, .after
         * untuk membandingkan dua tanggal. Ketiga method tersebut akan mengembalikan nilai boolean untuk menilai jika paramater tanggal pertama sama, sebelum
         * atau sesudah dari tanggal kedua.
         * 
         * Jika waktu saat ini berada dalam jam operasional, maka program Jbank akan berjalan. jika tidak maka Program jbank akan keluar.
         */
        if((current.after(Bank.getStartTime())==true | current.equals(Bank.getStartTime())==true)&(current.before(Bank.getCloseTime())==true | current.equals(Bank.getCloseTime())==true)){
                int loop=0;                                                             //deklarasi dan Instalasi parameter melanjutkan atau memberhentikan loop do while
                System.out.println("Operation Hour: " + getHoursOfOperation());// Print 
                System.out.println("Current Time  : " + df.format(current));
                do{
                          loop=0;                                                       //instalasi ulang parameter agar tidak terjadi infinite loop
                          System.out.println("Selamat datang Di Jbank. Apakah anda ingin menjadi nasabah? (y/n)");
                          Scanner inputreac = new Scanner(System.in);                   //instalasi scanner untuk mengambil input dari user, akan digunakan untuk semua jenis input
                          char reaction = inputreac.next().charAt(0);                   //ambil input tipe char (karakter pertama dari input user)
                          
                              //Jika input user Y/y, memasuki algoritma pemgambilan data kustomer
                              if (reaction=='y' | reaction=='Y'){
                                 
                                          inputreac.nextLine();                         //Deklarasi ulang untuk menghapus karakter yang tersisa pada next().charAt(0)
                                          
                                          System.out.println("Masukkan nama Depan");
                                          String namaDepan = inputreac.nextLine();      //variabel untuk menyimpan input nama depan user (berjenis string)
                                          
                                          System.out.println("Masukkan nama Keluarga");
                                          String namaBelakang = inputreac.nextLine();   //variabel untuk menyimpan input nama belakang user (berjenis String)
                                          
                                          System.out.println("Masukkan tanggal lahir (1-31)");
                                          int day = inputreac.nextInt();            //variabel untuk menyimpan input tanggal lahir user (berjenis int)
    
                                          System.out.println("Masukkan bulan lahir (1-12)");
                                          int month = inputreac.nextInt();          //variabel untuk menyimpan input bulan lahir user (berjenis int)
                                          month--;
                                          
                                          System.out.println("Masukkan tahun lahir (1995-2000)");
                                          int year= inputreac.nextInt();            //variabel untuk menyimpan input Tahun lahir user (berjenis int)
                                         
                                          Customer c1= new Customer (namaDepan, namaBelakang, ( new GregorianCalendar(year, month, day).getTime())); //membuat object kustomer baru dengan input yang ada
    
                                                System.out.println("Apakah Anda ingin membuat Akun? (y/n)");
                                                char membuatAkun = inputreac.next().charAt(0);
                                                //Jika User ingin membuat akun
                                                if(membuatAkun=='y' | membuatAkun=='Y'){
                                          
                                                      System.out.println("Jenis Akun apa yang akan anda Buat? (Override=O/Line of Credit=L/Investasi=I/Saving=S)");
                                                      char jenisAkun = inputreac.next().charAt(0);
                                                      
                                                      System.out.println("masukkan saldo");
                                                      int initialBalance =inputreac.nextInt();
                                                      
                                                      /*
                                                       * Pmeriksaan input yang invalid untuk pembuatan akun
                                                       * syarat valid: Input adalah Char dengan character L,O,S atau I dan saldo harus lebih dari nol
                                                       */
                                                      if((jenisAkun=='L'|jenisAkun=='O'|jenisAkun=='S'|jenisAkun=='I')&(initialBalance>0)){
                                                          Account a1= new Account (jenisAkun, initialBalance);
                                                          double balance= a1.getBalance(); // mengambil balance dari akun yang baru saja dibuat
                                                          
                                                          /*
                                                           * Mengeset ID akun dengan gabungan id kustomer dan jenis Akun
                                                           */
                                                          a1.setID(Integer.toString(c1.getCustid())+a1.getAcctType()); 
                                                          
                                                          /*
                                                           * Mengassign kustomer ke akun. 
                                                           */
                                                          c1.setAccount(a1);
                                                          
                                                          System.out.println("Akun anda berhasil dibuat. Periksa kembali data dibawah ini");
                                                          System.out.println("Nama          : " + c1.getCustomerName());
                                                          System.out.println("Jenis Akun    : " + c1.getAccount().getAcctType());
                                                          System.out.println("Saldo Saat ini: " + c1.getAccount().getBalance());
                                                          System.out.println("ID akun       : " + c1.getAccount().getId());
                                                          
                                                          //Pilihan untuk kembai ke menu utama
                                                          System.out.println("Apakah Anda ingin Kembali ke menu utama? (y/n)");
                                                          char menuUtama = inputreac.next().charAt(0);
                                                     
                                                            if (menuUtama=='y' | menuUtama=='Y'){
                                                                System.out.println("Kembali ke menu utama....");
                                                                loop=1;
                                                            }
                                                            else if (menuUtama=='n' | menuUtama=='N'){
                                                                System.out.println("terima kasih karena telah mencoba Program Jbank. Terminasi program sekarang");
                                                                loop=0;
                                                            }
                                                          
                                                      }//end if
                                           
                                                    }
                                                //Jika User tidak ingin membuat akun, print data yang didapat dan berikan opsi untuk kembali ke menu utama
                                                else if(membuatAkun=='n' | membuatAkun=='N'){
                                                     System.out.println("Data anda berhasil disimpan. Periksa kembali data dibawah ini");
                                                     System.out.println("Nama               : " + c1.getCustomerName());
                                                     System.out.println("Tanggal Lahir      : " + c1.getDOB());
                                                     System.out.println("ID Kustomer        : " + c1.getCustid());
                                                     
                                                     System.out.println("Apakah Anda ingin Kembali ke menu utama? (y/n)");
                                                     char menuUtama = inputreac.next().charAt(0);
                                                     
                                                     if (menuUtama=='y' | menuUtama=='Y'){
                                                         System.out.println("Kembali ke menu utama....");
                                                         loop=1;
                                                     }
                                                     else if (menuUtama=='n' | menuUtama=='N'){
                                                         System.out.println("terima kasih karena telah mencoba Program Jbank. Terminasi program sekarang");
                                                         loop=0;
                                                     }
                                                     
                                                }//end if
                                                
                              }
                              
                              else if (reaction=='n' | reaction=='N'){
                                  //terminasi program
                                  System.out.println("terima kasih karena telah mencoba Program Jbank. Terminasi program sekarang");
                                  loop=0;
                              }
                                  
                              else{
                                  //jika input salah/tidak sesuai, tetap loop
                                  loop=1;
                              }
                                
                }while (loop==1);           //tetap loop selama nilai variabel loop sama dengan 1 
                
             }//end if
             
        else{ 
            System.out.println("Sorry, Jbank Service is not Available");            //print pesan bahwa masih Belum operasional
        }
    }
        
    /**
     * Kelas Konstruktor untuk Teller
     */
    public Teller(){
    }
    
    /**
     * Method untuk mengeset waktu buka dan tutup JBank dari Teller
     * Cara penggunaaan:
     * jika Jbank buka dari jam 07:59 hingga jam 21:00, maka jamBuka=7, menitBuka=59, jamTutup=21, menitTutup=0, 
     * 
     * @param jamBuka satuan jam buka bank
     * @param menitBuka satuan menit buka bank
     * @param jamTutup satuan jam tutup bank
     * @param menitTutup satuan menit tutup bank
     */
    private static void setCloseOpenTime(int jamBuka, int menitBuka, int jamTutup,int menitTutup){
        Bank.setCloseOpenTime(jamBuka, menitBuka, jamTutup,menitTutup);
    }
    
    /**
     * Method untuk mengembalikan waktu buka dan tutup JBank dari Teller
     * 
     * @return Jam buka bank TO jam tutup bank
     */
    private static String getHoursOfOperation(){
        String output= Bank.getHoursOfOperation();
        return output;
    }
    
}

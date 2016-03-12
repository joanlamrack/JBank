import java.util.Scanner;// Library untuk scanner
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.math.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.lang.*;
/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * 
 * program berikut ini akan membuat akun dan saldo berdasarkan input dari pengguna. 
 * program akan looping selama pengguna belum menterminasi program
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 4.3 (String and Date)
 */
public class Teller
{
    
    /**
     * Awal dari Program
     */

    public static void main(String[] args){
        //Trial Space:
        
        Account saving= new Account('S', 1000);// jawaban soal nomor 2
        Account invest= new Account('I', 1000);// jawaban soal nomor 3
        Account creditline= new Account('L', 500);// jawaban soal nomor 4
        
        //===== jawaban nomor 5 =======================================
        
        /**
         * Program berikut ini menunjukan balance dari akun saving setelah mendapat bunga majemuk 3% selama setahun,
         * dimana bunga dihitung tiap harinya.
         */
        
        //Deklarasi Variabel
        BigDecimal balanceSaving = new BigDecimal(saving.getBalance());         //Variabel konversi akun saving menjadi BigDecimal
        BigDecimal setahun = new BigDecimal("360.0");                           //Jumlah hari (360)
        BigDecimal t = new BigDecimal("1.0");                                   //Nilai 1 (satu tahun)
        BigDecimal bungaSaving = new BigDecimal(".03");                         //Nilai bunga saving per tahun
        BigDecimal one = new BigDecimal("1.0");                                 //Nilai 1 
        
        /**
         * Dibawah ini adalah perhitungan Balance saving dengan bunga setelah setahun.
         * rumus:
         * 
         * balance setelah bunga = balance saat ini * (1+ bunga pertahun /jumlah hari dalam satu tahun)^(jumlah hari dalam satu tahun*berapa tahun)
         */

        BigDecimal s1 = bungaSaving.divide(setahun, 7, RoundingMode.CEILING).add(one);      //1+ bunga pertahun /jumlah hari dalam satu tahun
        BigDecimal s2 = setahun.multiply(t);                                                //jumlah hari dalam satu tahun*berapa tahun
        double interestRateSaving = Math.pow(s1.doubleValue(), s2.doubleValue());           //(1+ bunga pertahun /jumlah hari dalam satu tahun)^(jumlah hari dalam satu tahun*berapa tahun)
        double balanceSavingAfter = interestRateSaving * balanceSaving.doubleValue();       // balance setelah bunga
        
        saving.setBalance(balanceSavingAfter);                                              //set balance akun saving ke nilai setelah bunga
        System.out.println("\nBalance Saving Setelah Setahun dengan bunga "+ bungaSaving +" : "+saving.getBalance());   //Print jumlah balance saat ini.
        
        //======= jawaban nomor 6 ========================================
        
        /**
         * Program berikut ini menunjukan balance dari akun investment setelah mendapat bunga majemuk 7% selama setahun dan 5% selama 6 bulan(0.5 tahun),
         * dimana bunga dihitung tiap harinya.
         */
        
        //Deklarasi Variabel
        BigDecimal balanceInvest = new BigDecimal(invest.getBalance());                    //Balance invest invest account
        BigDecimal bunga12Term = new BigDecimal(".07");                                    //bunga untuk term setahun
        BigDecimal bunga6Term = new BigDecimal(".05");                                     //bunga untuk term setengah tahun
        BigDecimal setengahTahun = new BigDecimal("0.5");                                  //6 bulan = 0.5 tahun
        
        /**
         * Dibawah ini adalah perhitungan Balance saving dengan bunga setelah setahun.
         * rumus:
         * 
         * balance setelah bunga = balance saat ini * ((1+ bunga term 6 bulan pertahun /jumlah hari setahun)^(jumlah hari setahun*berapa tahun) +(
         *                         bunga term 12 bulan pertahun /jumlah hari setahun)^(jumlah hari setahun*berapa tahun))
         */
        
        BigDecimal inv_12_1 = bunga12Term.divide(setahun, 7, RoundingMode.CEILING).add(one);        //0.07/360
        BigDecimal inv_6_1 = bunga6Term.divide(setahun, 7, RoundingMode.CEILING).add(one);          //0.05/360
        BigDecimal inv_12_2 = setahun.multiply(t);                                                  //360 * 1
        BigDecimal inv_6_2 = setahun.multiply(setengahTahun);                                       //360 * 0.5
        double interest12TermRate = Math.pow(inv_12_1.doubleValue(), inv_12_2.doubleValue())-1;     //(0.07/360)^(360 * 1)
        double interest6TermRate = Math.pow(inv_6_1.doubleValue(), inv_6_2.doubleValue())-1;        //(0.05/360)^(360 * 1)
        double interestTotal = (1+interest12TermRate+interest6TermRate)* balanceInvest.doubleValue();// balance setelah bunga
        
        invest.setBalance(interestTotal);                                                           //set isi akun ke nilai setelah bunga
        System.out.println("\nBalance Investment setelah setahun : " + invest.getBalance());      //Print isi akun
        //===== 7 =======================================
        
        /**
         * Program berikut ini menunjukan berapa hutang yang harus dibayar setelah setahun,
         * dimana bunga dihitung tiap harinya.
         * 
         * hutang dihitung ketika pengguna mengambil saldo lebih banyak dari yang ada pada akun saving,
         * selama pengambilan tidak melebih 750. kelebihan pengambilan akan di bebankan pada akun credit,
         * yang akan dihitung sebagai peminjaman.
         * 
         * peminjaman ini akan diberikan bunga sebesar 18% pertahun.
         */
        
        Account savingLinked= new Account('S', 500);                                                //Deklarasi Akun baru saving dengan nilai 500
        System.out.println("\nBalance saving sebelum penarikan:" + savingLinked.getBalance());          //Print isi akun saving
        
        double draw = 700;                                                                          //Jumlah yang akan ditarik 
        System.out.println("jumlah yang di tarik:" + draw);                                         

        
        /**
         * Pilihan:
         * -Jika penarikan melebih jumlah akun saving, habiskan isi akun saving, bebankan kelebihan pada credit dan hitung jumlah yang harus dibayar
         * -Jika penarikan masih kurang dari akun saving, withdraw seperti biasa.
         */
        
        //Jika penarikan melebihi
        if(draw>savingLinked.getBalance()){
            
            double calculateCredit=savingLinked.getBalance();           //Simpan isi akun saving saat ini
            savingLinked.withdraw(calculateCredit);                     //jadikan akun saving kosong
            double credit = draw-calculateCredit;                       //hitung besar peminjaman
            
            creditline.withdraw(credit);                                //tarik saldo dari credit sebesar peminjaman
            
            //Deklarasi
            BigDecimal bungaCredit = new BigDecimal(".18");                                 //besar bunga peminjaman (0,18)
            BigDecimal hutang = new BigDecimal(credit);                                     //konversi hutang ke BigDecimal
            
            /**
            * Dibawah ini adalah perhitungan besar hutang dengan bunga setelah setahun.
            * rumus:
            * 
            * hutang setelah bunga = hutang saat ini * (1+ bunga pertahun /jumlah hari dalam satu tahun)^(jumlah hari dalam satu tahun*berapa tahun)
            */
            
            BigDecimal credit1 = bungaCredit.divide(setahun, 7, RoundingMode.CEILING).add(one);     //1+bunga pertahun /jumlah hari dalam satu tahun
            BigDecimal credit2 = setahun.multiply(t);                                               //jumlah hari dalam satu tahun*berapa tahun
            double hutangInterestRate = Math.pow(credit1.doubleValue(), credit2.doubleValue());     //(1+ bunga pertahun /jumlah hari dalam satu tahun)^(jumlah hari dalam satu tahun*berapa tahun)
            double totalBayar = hutangInterestRate * hutang.doubleValue();                          //hutang setelah bunga
            
            //Print hasil dari perhitungan dan isi variabel
            System.out.println("\nBalance saving saat ini:" + savingLinked.getBalance());
            System.out.println("hutang: " + credit);
            System.out.println("Isi Akun Credit:  " + creditline.getBalance());
            System.out.println("\nBayaran hutang anda akan menjadi: " + totalBayar);
        }
          //jika masih dalam saldo saving;
          else if(draw<creditline.getBalance()|draw==creditline.getBalance()){
            savingLinked.withdraw(draw);                                                
            System.out.println("Balance akun saat ini:" + savingLinked.getBalance()+"\n");
          }
            else{
                //Do nothing
            }
      
      
        //=======Program Jbank Utama================================================
        
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
                                          int month = inputreac.nextInt()-1;          //variabel untuk menyimpan input bulan lahir user (berjenis int)
                                          
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

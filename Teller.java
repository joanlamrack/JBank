import java.util.Scanner;// Library untuk scanner
/**
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * 
 * program berikut ini akan membuat akun dan saldo berdasarkan input dari pengguna. 
 * program akan looping selama pengguna belum menterminasi program
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 3.4.1 (Classes Session: Effective Using of Scanner Section, Menu with char Input, Added Comment and indentation)
 */
public class Teller
{
    
    /**
     * Awal dari Program
     */
        public static void main(String[] args){
        int loop=0;                                                                 //deklarasi dan Instalasi parameter melanjutkan atau memberhentikan loop do while
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
                                      
                                      System.out.println("Masukkan tanggal lahir");
                                      String DOB = inputreac.nextLine();            //variabel untuk menyimpan input tanggal lahir user (berjenis string)
                                      
                                      Customer c1= new Customer (namaDepan, namaBelakang, DOB); //membuat object kustomer baru dengan input yang ada
                                      
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
                                                  }
                                       
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
                                                 
                                            }
                                            
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
            
        }
     
    public Teller(){
    }
    
}

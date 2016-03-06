import java.util.Scanner;
/**
 * ASISTEN: Perhatikan kerapihan indentasi
 * Merepresentasikan Akun teller, yang dapat berinteraksi dengan bank, kustomer dan akun.
 * 
 * program berikut ini akan membuat akun dan saldo berdasarkan input dari pengguna. 
 * program akan looping selama pegguna belom menterminasi program
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 3.4 (Classes Session)
 */
public class Teller
{
    // instance variables - replace the example below with your ow  
    /**
     * Awal dari Program
     */

        public static void main(String[] args){
        int loop=0;
        do{
                  loop=0;
                  System.out.println("Selamat datang Di Jbank. Apakah anda ingin menjadi nasabah? (Yes=1/No=0)");
                  Scanner inputreac = new Scanner(System.in);
                  int reaction = inputreac.nextInt();
                  if (reaction==1){
                              Scanner input = new Scanner(System.in);
                              System.out.println("Masukkan nama Depan");
                              String namaDepan = input.nextLine();
                              System.out.println("Masukkan nama Keluarga");
                              String namaBelakang = input.nextLine();
                              System.out.println("Masukkan tanggal lahir");
                              String DOB = input.nextLine();
                              Customer c1= new Customer (namaDepan, namaBelakang, DOB);
                              
                                          
                              
                                          System.out.println("Jenis Akun apa yang akan anda Buat? (Override=O/Line of Credit=L/Investasi=I/Saving=S)");
                                          Scanner akun = new Scanner(System.in);
                                          char jenisAkun = akun.next().charAt(0);
                                          System.out.println("masukkan saldo");
                                          int initialBalance =input.nextInt();            
                                          if((jenisAkun=='L'|jenisAkun=='O'|jenisAkun=='S'|jenisAkun=='I')&(initialBalance>0)){
                                          Account a1= new Account (jenisAkun, initialBalance);
                                          double balance= a1.getBalance();
                                          
                                          a1.setID(Integer.toString(c1.getCustid())+a1.getAcctType());
                                          c1.setAccount(a1);
                                          Account ca1=c1.getAccount();
                                          
                                          
                                          System.out.println("Akun anda berhasil dibuat. Periksa kembali data dibawah ini");
                                          System.out.println("Nama          :"+c1.getCustomerName());
                                          System.out.println("Jenis Akun    :" + ca1.getAcctType());
                                          System.out.println("Saldo Saat ini:" + ca1.getBalance());
                                          System.out.println("ID            :"+ ca1.getId());
                                        }
                               
                    }
                    if (reaction==0){
                        System.out.println("terima kasih karena telah mencoba Program Jbank. Terminasi program sekarang");
                        loop=0;
                    }
                    else{loop=1;}
                    }while (loop==1);
                }
     
    public Teller(){
    }
}

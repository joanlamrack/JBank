import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
/**
 * Write a description of class Investment here.
 * 
 * @author Erithiana Sisijoan Koesnadi
 * @version 6.3
 */
public final class Investment extends Savings
{
    /**
     * variabel untuk menyimpan data akhir tanggal
     */
    private Date endDate;
    
    /**
     * variabel untuk menyimpan data bunga yang di dapatkan
     */
    private double interestRate;
    
    /**
     * variable untuk menyimpan awal pembuatan akun
     */
    private Date startDate;
    
    /**
     * variable untuk menyimpan term berapa tabungan tersebut
     */
    private int term;
    
    /**
     * kontruktor untuk kelas investment
     * 
     * @param cust akun customer
     * @param amount yang akan dimasukkan
     * @param months berapa bulan
     */
    public Investment(Customer cust, double amount, int months){
        super(cust, amount);
        if(months>=0 && months<=6){
            term=6;
            interestRate=0.05;
        }
        else if(months>=6 && months<=12){
            term=months;
            interestRate=0.06;
        }
        else if(months>=12){
            term=months;
            interestRate=0.07;
        }
        Calendar s= new GregorianCalendar();
        startDate=s.getTime();
        s.add(Calendar.MONTH, term);
        endDate =s.getTime();
        
    }
    
    /**
     * metode untuk menghitung bunga
     * 
     * @param days hari yang akan dihitung
     */
    public void addDailyInterest(int days){
        double f= balance*(Math.pow((1+(interestRate/365)),(days)));
        this.interestEarned= f-balance;
        balance=f;
    }
    
    /**
     * method untuk menarik balance
     * 
     * @param amount jumlah yang ditarik
     * @return boolean status dari method
     */
    public boolean withdraw(double amount){
        boolean status=false;
        if(withdraw(amount)==true){
            if(Calendar.getInstance().before(endDate)==true){
                status=true;
            }
        }
        else{
            //do nothing
         }
        return status;
        }
    }

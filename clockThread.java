import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Write a description of class clockThread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clockThread implements Runnable
{
    Date date;
    Thread t;
    ATMGUI gui;
    SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, hh:mm:ss a");
    
    public clockThread(ATMGUI gui)
    {
       this.gui=gui;
    }

   /**
    * method start() untuk thread
    * serta memeriksa jiga thread sudah berjalan atau belum
    */
   public void start(){
       if(t==null){
        t= new Thread(this, "Clock");
        t.start();
        }
   }
    
    /**
    * method run untuk thread dengan jeda 
    */
   public void run(){
       try{
           
           while(gui!=null){
               date= new Date();
               gui.setClock(df.format(date));
               Thread.sleep(100);
            }
            
        }
    
        catch(InterruptedException e){
        // do nothing
        }
   }
   
}

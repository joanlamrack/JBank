import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk WindowHandler, Child dari WindowAdapter
 * 
 * @author erithiana sisijoan
 * @version 7.3
 */
public class WindowHandler extends WindowAdapter
{
    /**
     * Method untuk mengatur apa yang terjadi jika window ditutup
     * 
     * @param w event dari window
     */
   public void windowClosing(WindowEvent w){
       quitMessage();
       System.exit(0);
   }
   
   /**
    * Method untuk mendefinisikan pesan ketika keluar
    */
   private void quitMessage(){
       JOptionPane.showMessageDialog(null,"You are exiting, goodbye!");
   }
}

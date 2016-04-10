import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk mengatur ActionLister dari ATM GUI,
 * Mengimplementasikan Action Listener
 * 
 * @author erithiana sisijoan
 * @version 7.3.1
 */
public class ButtonHandler implements ActionListener
{
   /**
    * Variabel untuk menyimpan parameter ATMGUI
    */
   private ATMGUI gui;
   
   /**
    * Kelas Konstruktor dari Button Handler
    * 
    * @param gui Objek gui yang akan dijadikan parameter.
    */
   public ButtonHandler(ATMGUI gui){
       this.gui=gui;
   }
   
   /**
    * Method untuk menghandle Event
    * 
    * @param e event yang dilakukan
    */
   public void actionPerformed(ActionEvent e){
       if(e.getActionCommand().equals("Deposit")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" saves an amount of money: Rp " + gui.getNominal());
           
           if(Bank.getCustomer(1001).getAccount('S').deposit(gui.getNominal())==false){
               JOptionPane.showMessageDialog(null,"Invalid Transaction");
           }
           else{
               Bank.getCustomer(1001).getAccount('S').deposit(gui.getNominal());
               JOptionPane.showMessageDialog(null,"Transaction Done");
           }
       }
       else if(e.getActionCommand().equals("Withdraw")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" withdraws an amount of money: Rp " + gui.getNominal());
           
           //mengambil label dari button sebagai identitas untuk melihat tombol mana yang ditekan
           if(Bank.getCustomer(1001).getAccount('S').withdraw(gui.getNominal())==false){
               JOptionPane.showMessageDialog(null,"Invalid Transaction");
           }
           else{
               Bank.getCustomer(1001).getAccount('S').withdraw(gui.getNominal());
               JOptionPane.showMessageDialog(null,"Transaction Done");
           }
           
        }
       else if(e.getActionCommand().equals("Total")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" Mempunyai Total dalam Account: Rp " + Bank.getCustomer(1001).getAccount('S').getBalance());
       }
       
       else{
           gui.setTextArea("");
       }
   }
   
   
   
}

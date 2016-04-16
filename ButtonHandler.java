import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk mengatur ActionLister dari ATM GUI,
 * Mengimplementasikan Action Listener
 * 
 * @author erithiana sisijoan
 * @version 8.7
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
           
           locateAccount('S').deposit(gui.getNominal());
           
           clearText();
       }
       else if(e.getActionCommand().equals("Withdraw")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" withdraws an amount of money: Rp " + gui.getNominal());
           //mengambil label dari button sebagai identitas untuk melihat tombol mana yang ditekan
           withdrawAction(locateAccount('S'), gui.getNominal());
           clearText();
        }
       else if(e.getActionCommand().equals("Total")){
           gui.setTextArea("Customer: " + gui.getIDcust() +" Mempunyai Total dalam Account: Rp " + locateAccount('S').getBalance());
           clearText();
       }
       
       else{
           clearText();
           gui.setTextArea("");
       }
       
   }

   /**
    * untuk error message
    * 
    * @param message pesan error yang akan dimasukkan
    */
   public void errorMessage(String message){
       gui.setTextArea(message);
   }
   
   /**
    * Mendefinisikan apa yang dilakukan oleh withdraw di gui
    * 
    * @param akun Account dari user
    * @param amount jumlah yang akan ditarik
    */
   public void withdrawAction(Account akun, double amount){
       try{
           akun.withdraw(amount);
       }
       catch(AmountOverDrawnException unexpected){
           errorMessage(unexpected.getMessage());
        }
   }
   
   /**
    * Method untuk mencari akun di kelas static Bank, dengan exception.
    * 
    * @param acctType tipe akun yang dicari
    * @return akun yang dicari
    */
   public Account locateAccount(char acctType){
       try{
           return Bank.getCustomer(gui.getIDcust()).getAccount(acctType);
       }
       catch(AccountTypeNotFoundException sameAccount){
           errorMessage(sameAccount.getMessage());
       }
       return null;
    }
    
   /**
     * method untuk clear customerText area dan amountText area
     */
   public void clearText(){
        gui.customerText.setText("");
        gui.amountText.setText("");
   }
}

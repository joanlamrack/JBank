import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Kelas untuk mengatur ActionLister dari ATM GUI,
 * Mengimplementasikan Action Listener
 * 
 * @author erithiana sisijoan
 * @version 10
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
       try{
           //mengambil label dari button sebagai identitas untuk melihat tombol mana yang ditekan
           if(e.getActionCommand().equals("Deposit")){
               gui.setTextArea("Customer: " + gui.getIDcust() +" saves an amount of money: Rp " + gui.getNominal());
               
               locateAccount(gui.getAcctTypeSelected()).deposit(gui.getNominal());
               
               clearText();
           }
           else if(e.getActionCommand().equals("Withdraw")){
               gui.setTextArea("Customer: " + gui.getIDcust() +" withdraws an amount of money: Rp " + gui.getNominal());
               
               withdrawAction(locateAccount(gui.getAcctTypeSelected()), gui.getNominal());
               
               clearText();
            }
           else if(e.getActionCommand().equals("Info")){
               //Membuat buffer string, dan menambahkannya dengan informasi akun
               String print="";
               print=print+"Customer ID:"+gui.getIDcust()+"\nNama:"+locateCustomer(gui.getIDcust()).getCustomerName()+"\nDOB:"+locateCustomer(gui.getIDcust()).getDOB()+"\n\n";
               
               for(int i=0;i<(locateCustomer(gui.getIDcust()).getNumOfAccounts());i++){
                    print=print+"\nAccount Type: "+locateCustomer(gui.getIDcust()).getAcctType(locateCustomer(gui.getIDcust()).accounts[i]);
                    print=print+"\nBalance: "+locateCustomer(gui.getIDcust()).accounts[i].getBalance()+"\n";
                    
                    if (locateCustomer(gui.getIDcust()).accounts[i] instanceof Checking==true){
                        print=print+"\nMonthly Fee"+ ((Checking)(locateCustomer(gui.getIDcust()).accounts[i])).getMonthlyFee();
                    }
               }
               
               //Print Text yang sudah dibuffer dalam String Print
               gui.setTextArea(print);
               
               //Hapus semua text dalam field
               clearText();
           }

           else if(e.getActionCommand().equals("Save & Return")){
               if(gui.idText.isEditable()==false){
                   //Membuat kustomer dan menambahkannya ke bank
                   Customer c1= new Customer(gui.getId(),gui.getFirstName(),gui.getLastName(),gui.getDOB());
                   Bank.addCustomer(c1);
                   
                   //membuat akun dan menambahkannya ke customer
                   createAccount(gui.getSelectedType(),c1);
                   
                   //Update ID di GUI
                   gui.getNextID();
                   
                   //Hapus semua text dalam Field
                   gui.clearall();
                }
                else if(gui.idText.isEditable()==true){
                    createAccount(gui.getSelectedType(),locateCustomer(gui.getId()));
                    gui.clearall();
                }
                
            }
           
           else if(e.getActionCommand().equals("Cancel")){
               
               gui.clearall();
               
           }
           else if(e.getActionCommand().equals("Show all Customer's Data")){
               
               System.out.println("\n\n Printing All Customer Data \n");
               
               for(Customer c:Bank.customer){
                    System.out.println("\nCustomer ID: " + c.getCustomerId()+"\n Name: "+c.getCustomerName()+"\n Date Of Birth: "+ c.getDOB());
                    
                    for(int i=0;i<(c.getNumOfAccounts());i++){
                        System.out.println("Account Type: "+c.getAcctType(c.accounts[i]));
                        System.out.println("Balance: "+c.accounts[i].getBalance());
                        if (c.accounts[i] instanceof Checking==true){
                            System.out.println("Monthly fee:"+((Checking)(c.accounts[i])).getMonthlyFee());
                        }
                    }
                    
                }
           
           }
           else if(e.getActionCommand().equals("Generate Backup")){
               (new FileChooser()).saveFile();
           }
           else if(e.getActionCommand().equals("LoadBackup")){
               (new FileChooser()).loadFile();
           }
           else if(e.getActionCommand().equals("Create Another Account For Existing Customer")){
               
               AbstractButton abstractButton = (AbstractButton) e.getSource();
               boolean selected = abstractButton.getModel().isSelected();
               
               gui.existingCustomerSwitch(selected);
               if(selected==false){
                   gui.lastKnownID();
                }
               
           }
           else{
               clearText();
               gui.setTextArea("");
          }
          
        }
        catch(NumberFormatException invalid){
            gui.textAreaMain.setText("Invalid Input");
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
           return locateCustomer(gui.getIDcust()).getAccount(acctType);
       }
       catch(AccountTypeNotFoundException sameAccount){
           errorMessage(sameAccount.getMessage());
       }
       catch(NullPointerException noCustomer){
           errorMessage("Customer Not exist");
       }
       return null;
    }
    
   /**
    * Method untuk mengambil Customer dibank berdasarkan nomor ID
    * 
    * @param ID identitas Kustomer
    * @return Customer dengan ID yang diminta
    */
   public Customer locateCustomer(int ID){
       Customer found=null;
       try{
           found= Bank.getCustomer(ID);
       }
       catch(CustomerNotFoundException e){
            e.getMessage();
       }
       return found;
   }
    
   /**
     * method untuk clear customerText area dan amountText area
     */
   public void clearText(){
        gui.customerText.setText("");
        gui.amountText.setText("");
   }
   
   /**
    * Method Untuk membuat akun baru
    * 
    * @param accountType tipe akun
    * @param owner kustomer yang akan memiliki akun tersebut
    */
   public void createAccount(String accountType, Customer owner){
       try{
           Account akun=null;
           if(gui.getSelectedType()=="Savings"){
               akun= new Savings(owner, 100);
               owner.addAccount(akun);
           }
           else if(gui.getSelectedType()=="CheckingOverDraft"){
               Savings akun1= new Savings(owner, 100);
               owner.addAccount(akun1);
               akun= new OverDraftProtection(owner,500,akun1);
               owner.addAccount(akun);
           }
           else if(gui.getSelectedType()=="Line Of Credit"){
               akun= new LineOfCredit(owner, 500, 1000);
               owner.addAccount(akun);
           }
           else if(gui.getSelectedType()=="Investment"){
               akun= new Investment(owner, 500, 6);
               owner.addAccount(akun);
           }
           
       }
       catch(AccountTypeAlreadyExistException e){
           e.getMessage();
       }
   }
   
}

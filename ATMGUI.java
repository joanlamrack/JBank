import javax.swing.*;//Library GUI
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher; // library untuk regular expression, matcher dan pattern 
import java.util.regex.Pattern;
/**
 * Kelas yang merepresentaskan ATMGUI
 * , Merupakan child dari JFrame
 * 
 * @author erithiana sisijoan 
 * @version 7.3.1
 */
public class ATMGUI extends JFrame
{
   /**
    * JLabel untuk Jam 
    */
    public JLabel clock;
    
    /**
     * Variabel dalam Customer GUI
     */
    
    //Textfield untuk identitas
    public JTextField idText;
    public JTextField lastText;
    public JTextField firstText;
    public JTextField addressText;
    public JTextField cityText;
    public JTextField stateText;
    public JTextField zipText;
    public JTextField phoneText;
    public JTextField emailText;
    public JTextField dobText;
    
    String[] data = {"CheckingOverDraft","Line Of Credit","Savings","Investment"};
    JList<String> tipeAkun;
    
    public JButton cancel;
    public JButton saveReturn;
    
    public JCheckBox existingCustomer;
    
    /**
     * variabel-variabel dalam ATMGUI
     */
    public JMenuBar menubar;
    public JMenu adminMenu;
    public JMenuItem about;
    public JMenu appMenu;
    public JMenuItem adminViewAllCust;
    public JMenuItem adminGenerateSave;
    public JMenuItem adminLoadSave;
    public JMenuItem viewLogs;
    public JMenuItem quit;
    public JMenu notifyMe;
    public JMenuItem bankOpen;
    public JMenuItem bankClose;
    
    //Untuk membuat tab
    public JTabbedPane tabbedPane;
    
    //Label untuk TextField
    public JLabel customerLabel;
    public JLabel amountLabel;
    
    //Group RadioButton
    public ButtonGroup radioGroup;
    
    public JRadioButton tipeAkunSaving;
    public JRadioButton tipeAkunInvestment;
    public JRadioButton tipeAkunLineOfCredit;
    public JRadioButton tipeAkunOverdraft;
    
    public JTextField customerText;
    public JTextField amountText;
    public JTextArea textAreaMain;
    
    public JButton deposit;
    public JButton withdraw;
    public JButton exit;
    public JButton total;
    
    public JFrame frame;
    
    /**
     * Kontruktor dari kelas ATMGUI
     */
    public ATMGUI()
    {
        super("ATMGUI"); // Membuat objek Jframe
        buildGUI();
        setVisible(true);//Menampilkan GUI
    }
    
    /**
     * Method untuk membangun GUI dengan Metode Nested Panel
     */
    public void buildGUI(){
        /**
         * Komponen atas-bawah
         * 
         */
        
        JPanel topDown = new JPanel();
        topDown.setLayout(new BoxLayout(topDown,BoxLayout.Y_AXIS));
        
        /**
         * Komponen jam
         */
        
        clock= new JLabel("Jam disini");
        
        JPanel clockPanel= new JPanel();
        clockPanel.setLayout(new BorderLayout());
        clockPanel.add(clock, BorderLayout.CENTER);
           
        /**
         * Komponen MainPanel
         */
        //Membuat Container
        Container contentPane= getContentPane();
        
        //membuat komponen tab
        tabbedPane= new JTabbedPane();
        
        //Membuat menubar
        menubar= new JMenuBar();
        
        //Membuat Menu
        adminMenu=new JMenu("Admin Menu");
        appMenu=new JMenu("App Menu");
        
        menubar.add(adminMenu);
        //menubar.add(appMenu);
        
        //Membuat JMenuItem
        adminViewAllCust=new JMenuItem("Show all Customer's Data");
        adminGenerateSave= new JMenuItem("Generate Backup");
        adminLoadSave=new JMenuItem("LoadBackup");
        viewLogs= new JMenuItem("Show Logs");
        quit= new JMenuItem("Quit");
        notifyMe= new JMenu("Notify me when:");
        about= new JMenuItem("About");
        bankOpen=new JMenuItem("Bank Opens");
        bankClose= new JMenuItem("Bank Closes");
        
        //Menambahkan Item-Item tersebut kedalam 
        adminMenu.add(adminViewAllCust);
        adminMenu.add(adminGenerateSave);
        adminMenu.add(adminLoadSave);
        //appMenu.add(notifyMe);
        //appMenu.add(about);
        //appMenu.add(quit);
        //notifyMe.add(bankOpen);
        //notifyMe.add(bankClose);
        
        //Membuat Panel-panel untuk mengelompokkan Komponen
        JPanel buttonPanel= new JPanel();
        buttonPanel.setLayout(new GridLayout(0,1));
        JPanel checkboxPanel= new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        JPanel infoPanel= new JPanel();
        infoPanel.setLayout(new FlowLayout());
        JPanel textPanel= new JPanel ();
        textPanel.setLayout(new FlowLayout());
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        //Membuat ButtonGroup Untuk Jradio Button
        radioGroup=new ButtonGroup();
        
        //Membuat Komponen Label
        customerLabel= new JLabel("Enter Customer ID");
        amountLabel = new JLabel("Enter amount here:");
        
        //Membuat Komponen TextField dan TextArea
        customerText= new JTextField(10);
        amountText= new JTextField(15);
        textAreaMain= new JTextArea(20, 50);
        textAreaMain.setEditable(false);
        
        //Membuat RadioButton
        tipeAkunSaving = new JRadioButton("Savings");
        tipeAkunInvestment = new JRadioButton("Investment");
        tipeAkunLineOfCredit = new JRadioButton("Line Of Credit");
        tipeAkunOverdraft = new JRadioButton("Overdraft");
        
        //Membuat Button
        deposit= new JButton("Deposit");
        withdraw= new JButton("Withdraw");
        total= new JButton("Info");
        exit= new JButton("Exit");
        
        //Menambahkan JButton ke ButtonPanel
        buttonPanel.add(deposit);
        buttonPanel.add(withdraw);
        buttonPanel.add(total);
        buttonPanel.add(exit);
        
        //menambahkan JradioButton ke ButtonGroup
        radioGroup.add(tipeAkunSaving);
        radioGroup.add(tipeAkunInvestment);
        radioGroup.add(tipeAkunLineOfCredit);
        radioGroup.add(tipeAkunOverdraft);
        
        //Menambahkan JRadioButton ke CheckBoxPanel
        checkboxPanel.add(tipeAkunSaving);
        checkboxPanel.add(tipeAkunInvestment);
        checkboxPanel.add(tipeAkunLineOfCredit);
        checkboxPanel.add(tipeAkunOverdraft);
        
        //Menambahkan Komponen-Komponen ke infoPanel
        infoPanel.add(customerLabel);
        infoPanel.add(customerText);
        infoPanel.add(checkboxPanel);
        infoPanel.add(amountLabel);
        infoPanel.add(amountText);
        
        //Menambahkan Komponen-Komponen ke textPanel
        textPanel.add(textAreaMain);
        textPanel.add(buttonPanel);
        
        //Menambahkan Komponen-Komponen ke mainPanel
        mainPanel.add(infoPanel);
        mainPanel.add(textPanel); 
        
        //mengaplikasikan menubar ke JFrame
        setJMenuBar(menubar);
        
        /**
         * Komponen BackGUI
         */
        existingCustomer= new JCheckBox("Create Another Account For Existing Customer");
        
        //Membuat Panel-panel untuk mengelompokkan Komponen
        JPanel onePanel= new JPanel();
        onePanel.setLayout(new FlowLayout());
        JPanel twoPanel= new JPanel();
        twoPanel.setLayout(new FlowLayout());
        JPanel threePanel= new JPanel();
        threePanel.setLayout(new FlowLayout());
        JPanel fourPanel= new JPanel();
        fourPanel.setLayout(new FlowLayout());
        
        JPanel backPanel=new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        
        //Membuat Komponen TextField dan TextArea
        idText= new JTextField(10);
            idText.setText(Bank.getNextID()+"");
            idText.setEditable(false);
        lastText= new JTextField(10);
            TextPrompt lastNamePrompt= new TextPrompt("Last Name", lastText);
        firstText= new JTextField(19);
            TextPrompt firstNamePrompt= new TextPrompt("First Name", firstText);
        addressText= new JTextField(19);
            TextPrompt addressPrompt= new TextPrompt("Address", addressText);
        cityText= new JTextField(9);
            TextPrompt cityPrompt= new TextPrompt("City", cityText);
        stateText= new JTextField(9);
            TextPrompt statePrompt= new TextPrompt("State", stateText);
        zipText= new JTextField(9);
            TextPrompt zipPrompt= new TextPrompt("Zip Code", zipText);
        phoneText= new JTextField(9);
            TextPrompt phonePrompt= new TextPrompt("Phone", phoneText);
        emailText= new JTextField(14);
            TextPrompt emailPrompt= new TextPrompt("Email", emailText);
        dobText= new JTextField(14);
            TextPrompt dobPrompt= new TextPrompt("Date of Birth(DD-MM-YYYY)", dobText);
        
        cancel=new JButton("Cancel");
        saveReturn=new JButton("Save & Return");
        
        tipeAkun= new JList<String>(data);
        
        //Menambahkan Komponen-Komponen ke Panel
        onePanel.add(cancel);
        onePanel.add(saveReturn);
        onePanel.add(idText);
        onePanel.add(lastText);
        
        twoPanel.add(firstText);
        twoPanel.add(addressText);
        
        threePanel.add(cityText);
        threePanel.add(stateText);
        threePanel.add(zipText);
        threePanel.add(phoneText);
        
        fourPanel.add(emailText);
        fourPanel.add(dobText);
        fourPanel.add(tipeAkun);
        
        //Menambahkan Komponen-Komponen ke mainPanel
        backPanel.add(existingCustomer);
        backPanel.add(onePanel);
        backPanel.add(twoPanel);
        backPanel.add(threePanel);
        backPanel.add(fourPanel);
        
        /**
         * Konfigurasi komponen Tab
         */
        tabbedPane.addTab("ATM GUI", mainPanel);
        tabbedPane.addTab("Customer GUI", backPanel);
        
        //menambahkan komponen ke topDownPanel
        topDown.add(clock);
        topDown.add(tabbedPane);
        
        //menambahkan Tabbedpane ke mainPanel
        contentPane.add(topDown);
        
        //Menambahkan jam
        (new clockThread(this)).start();
        
        //mengatur komponen dalam GUI
        pack();
        
        //Menambahkan Window Listener
        addWindowListener(new WindowHandler());
        
        //Menambahkan ButtonHandler
        deposit.addActionListener(new ButtonHandler(this));
        withdraw.addActionListener(new ButtonHandler(this));
        total.addActionListener(new ButtonHandler(this));
        cancel.addActionListener(new ButtonHandler(this));
        saveReturn.addActionListener(new ButtonHandler(this));
        
        adminViewAllCust.addActionListener(new ButtonHandler(this));
        existingCustomer.addActionListener(new ButtonHandler(this));
        
        adminGenerateSave.addActionListener(new ButtonHandler(this));
        adminLoadSave.addActionListener(new ButtonHandler(this));
    }
    
    //====Method dari mainPanel===========================================
    
    /**
     * Method untuk mengembalikan ID yang dituliskan dalam GUI
     * 
     * @return ID kustomer
     */
    public int getIDcust(){
        return Integer.parseInt(customerText.getText());
    }
    
     /**
     * Method untuk mengembalikan Nominal yang dituliskan dalam GUI
     * 
     * @return Nominal yang ditulis
     */
    public double getNominal(){
       return Double.parseDouble(amountText.getText());
    }
    
     /**
     * Method untuk mengembalikan Apa yang ada dalam Text Area
     * 
     * @return isi text area
     */
    public String getTextArea(){
        return textAreaMain.getText();
    }
    
    /**
     * Method untuk mengeset apa yang akan ditulis di Text Area
     * 
     * @param input Text yang akan ditulis dalam TextArea
     */
    public void setTextArea(String input){
        textAreaMain.setText(input);
    }
    
    //Method dari Backpanel=============================================
    
    /**
     * Method untuk mendapatkan id yang ada dari fieldtext Customer GUI
     * 
     * @return ID kustomer dalam bentuk integer
     */
    public int getId(){
        return Integer.parseInt(idText.getText());
    }
    
    /**
     * Method untuk mendapatkan Nama akhir dari Field Customer GUI
     * 
     * @return Nama akhir Kustomer
     */
    public String getLastName(){
        return lastText.getText();
    }
    
    /**
     * Method untuk mendapatkan Nama akhir dari Field Customer GUI
     * 
     * @return Nama akhir Kustomer
     */
    public String getFirstName(){
        return firstText.getText();
    }
    
    /**
     * Method untuk mendapatkan Alamat dari Field Customer GUI
     * 
     * @return alamat Kustomer
     */
    public String getAddress(){
        return addressText.getText();
    }
    
    /**
     * Method untuk mendapatkan Kota dari Field Customer GUI
     * 
     * @return kota Kustomer
     */
    public String getCity(){
        return cityText.getText();
    }
    
    /**
     * Method untuk mendapatkan Negara dari field customer GUI
     * 
     * @return negara dari customer GUI
     */
    public String getStates(){
        return stateText.getText();
    }
    
    /**
     * Method untuk mendapatkan Kodepos dari field customer GUI
     * 
     * @return kodepos dari field customer GUI
     */
    public String getZip(){
        return zipText.getText();
    }
    
    /**
     * Method untuk mendapatkan nomor telepon dari kustomer
     * 
     * @return nomor telepon kustomer
     */
    public String getphone(){
        return phoneText.getText();
    }
    
    /**
     * Method untuk mendapatkan email dari kustomer field
     * 
     * @return email kustomer
     */
    public String getEmail(){
        return emailText.getText();
    }
    
    /**
     * Method untuk mendapatkan tanggal lahir dari kustomer field, Menggunakan regex untuk validasi dd-mm-yyyy
     * 
     * @return tanggal lahir customer
     */
    public Date getDOB(){
        
        String dob= dobText.getText();
        
        String regex="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dob);
        
        Date parsedDate=null;
        
        System.out.println(dob +" : "+ matcher.matches());
        
        if(matcher.matches()==true){
           int day = Integer.parseInt(dob.substring(0,2));
           int month = Integer.parseInt(dob.substring(3,5))-1;
           int year = Integer.parseInt(dob.substring(6));
            
           parsedDate=(new GregorianCalendar(year, month, day).getTime());
        }
        return parsedDate;
    }
    
    /**
     * Method untuk mendapatkan tanggal lahir dari kustomer field
     * 
     * @return tipe akun
     */
    public String getSelectedType(){
        return tipeAkun.getSelectedValue().toString();
    }
    
    /**
     * Method untuk menhapus semua seleksi dan input dari Customer GUI
     */
    public void clearall(){
        lastText.setText("");
        firstText.setText("");
        addressText.setText("");
        cityText.setText("");
        stateText.setText("");
        zipText.setText("");
        phoneText.setText("");
        emailText.setText("");
        dobText.setText("");
        tipeAkun.clearSelection();
    }
 
    /**
     * Method untuk mengambil id berikut ketika save and return ditekan
     */
    public void getNextID(){
        int id=Bank.getNextID();
        if(id!=0){
            idText.setText(id+"");
            setIDfield(true);
            cancel.setEnabled(true);
            saveReturn.setEnabled(true);
        }
        else{
            idText.setText("MAX CUST");
            setIDfield(false);
            cancel.setEnabled(false);
            saveReturn.setEnabled(false);
        }
    }
    
    /**
     * Method untuk mengeset jam
     * 
     * @param time String waktu
     */
    public void setClock(String time){
        clock.setText(time);
    }
    
    /**
     * Method untuk set Semua textfield diblokir atau tidak
     * 
     * @param state false untuk memblokir semua textField
     */
    public void setIDfield(boolean state){
        lastText.setEditable(state);
        firstText.setEditable(state);
        addressText.setEditable(state);
        cityText.setEditable(state);
        stateText.setEditable(state);
        zipText.setEditable(state);
        phoneText.setEditable(state);
        emailText.setEditable(state);
        dobText.setEditable(state);
    }
    
    /**
     * Method yang dipanggil untuk checkbox untuk memblokir beberapa JtextField
     * 
     * @param state true untuk memblokir semua field kecuali id dan Jenis akun
     */
    public void existingCustomerSwitch(boolean state){
        setIDfield(!state);
        idText.setEditable(state);
    }
    
    /**
     * Method untuk mengeset ID field pada id terakhir yang diketahui
     */
    public void lastKnownID(){
        idText.setText(Bank.getLastID()+"");
    }
    
    public char getAcctTypeSelected(){
       char acctType='M';
       if(tipeAkunSaving.isSelected()==true){
           acctType='S';
       }
       else if(tipeAkunInvestment.isSelected()==true){
           acctType='I';
       }
       else if(tipeAkunLineOfCredit.isSelected()==true){
           acctType='L';
       }
       else if(tipeAkunOverdraft.isSelected()==true){
           acctType='O';
       }
       return acctType;
    }
}

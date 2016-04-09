import javax.swing.*;//Library GUI
import java.awt.*;
/**
 * Kelas yang merepresentaskan GUI
 * , Merupakan child dari JFrame
 * 
 * @author erithiana sisijoan 
 * @version 7.3
 */
public class ATMGUI extends JFrame
{
    /**
     * variabel-variabel dalam GUI
     */
    public JLabel customerLabel;
    public JLabel amountLabel;
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
    public ButtonGroup radioGroup;
    public ButtonGroup buttonGroup;
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
        //Membuat Container
        Container contentPane= getContentPane();
        
        //Membuat Panel-panel untuk mengelompokkan Komponen
        JPanel buttonPanel= new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JPanel checkboxPanel= new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        JPanel infoPanel= new JPanel();
        infoPanel.setLayout(new FlowLayout());
        JPanel textPanel= new JPanel ();
        textPanel.setLayout(new FlowLayout());
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
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
        exit= new JButton("Exit");
        
        //Menambahkan JButton ke ButtonPanel
        buttonPanel.add(deposit, BorderLayout.PAGE_START);
        buttonPanel.add(withdraw, BorderLayout.CENTER);
        buttonPanel.add(exit, BorderLayout.PAGE_END);
        
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
        
        //menambahkan mainpanel ke Contentpane
        contentPane.add(mainPanel);
        
        //mengatur komponen dalam GUI
        pack();
        
        //Menambahkan Window Listener
        addWindowListener(new WindowHandler());
        
        //Menambahkan ButtonHandler
        deposit.addActionListener(new ButtonHandler(this));
        withdraw.addActionListener(new ButtonHandler(this));
    }
    
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
     * @return ID kustomer
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
}

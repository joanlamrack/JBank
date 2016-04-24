import javax.swing.*;//Library GUI
import java.awt.*;
/**
 * Kelas yang merepresentasikan CustomerGUI
 * 
 * @author erithiana sisijoan  
 * @version 9.3
 */
public class CustomerGUI extends JFrame
{
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
    
    String[] data = {"CheckingOverDraft","Line Of Credit","Savings","Investment","Other"};
    JList<String> tipeAkun;
    
    public JButton cancel;
    public JButton saveReturn;
    
    public JFrame frame;
    
    public CustomerGUI(){
        super("CustomerGUI"); // Membuat objek Jframe
        buildGUI();
        setVisible(true);//Menampilkan GUI
    }
    
    public void buildGUI(){
        //Membuat Container
        Container contentPane= getContentPane();
        
        //Membuat Panel-panel untuk mengelompokkan Komponen
        JPanel onePanel= new JPanel();
        onePanel.setLayout(new FlowLayout());
        JPanel twoPanel= new JPanel();
        twoPanel.setLayout(new FlowLayout());
        JPanel threePanel= new JPanel();
        threePanel.setLayout(new FlowLayout());
        JPanel fourPanel= new JPanel();
        fourPanel.setLayout(new FlowLayout());
        
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        //Membuat Komponen TextField dan TextArea
        idText= new JTextField(10);
            idText.setText("ID");
        lastText= new JTextField(10);
            lastText.setText("Last Name");
        firstText= new JTextField(19);
            firstText.setText("First Name");
        addressText= new JTextField(19);
            addressText.setText("Address");
        cityText= new JTextField(9);
            cityText.setText("City");
        stateText= new JTextField(9);
            stateText.setText("State");
        zipText= new JTextField(9);
            zipText.setText("Zip Code");
        phoneText= new JTextField(9);
            phoneText.setText("Phone Number");
        emailText= new JTextField(14);
            emailText.setText("Email");
        dobText= new JTextField(14);
            dobText.setText("DOB");
        
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
        mainPanel.add(onePanel);
        mainPanel.add(twoPanel);
        mainPanel.add(threePanel);
        mainPanel.add(fourPanel);
        
        //menambahkan mainpanel ke Contentpane
        contentPane.add(mainPanel);
        
        //mengatur komponen dalam GUI
        pack();
        
        //Menambahkan Window Listener
        addWindowListener(new WindowHandler());
        
        //Menambahkan ButtonHandler
        cancel.addActionListener(new ButtonHandler(this));
        saveReturn.addActionListener(new ButtonHandler(this));
    }
    
    public String getId(){
        return idText.getText();
    }
    
    public String getLastName(){
        return lastText.getText();
    }
    
    public String getFirstName(){
        return firstText.getText();
    }
    
    public String getAddress(){
        return addressText.getText();
    }
    
    public String getCity(){
        return cityText.getText();
    }
    
    public String getStates(){
        return stateText.getText();
    }
    
    public String getZip(){
        return zipText.getText();
    }
    
    public String getphone(){
        return phoneText.getText();
    }
    
    public String getEmail(){
        return emailText.getText();
    }
    
    public String getDOB(){
        return dobText.getText();
    }
    
    public String getSelectedType(){
        return tipeAkun.getSelectedValue().toString();
    }
 
}

import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 * Kelas untuk menghandle loading dan save menggunakan Jfile Chooser
 * 
 * @author erithiana sisijoan
 * @version 10
 */
public class FileChooser extends JFileChooser implements Serializable
{
    /**
     * Variable untuk melihat apakah sudah diapprove atau belum
     */
    private int returnValue;
    
    /**
     * Variabel untuk Menyimpan tipe File
     */
    private File selected;
    
    /**
     * Method Konstruktor untuk jfile chooser
     */
    public FileChooser(){
        super();
    }
    
    /**
     * Method untuk Menload file
     */
    public void loadFile(){
        returnValue = this.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
              selected = new File(this.getSelectedFile().getAbsolutePath());
              Bank.customer=(new CustomerFileReader(selected)).readCustomer();
        }
    }
    
    /**
     * Method untuk menyimpan file
     */
    public void saveFile(){
        returnValue = this.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
              new CustomerFileWriter(new File(this.getSelectedFile().getAbsolutePath())).saveCustomer(Bank.customer);
        }
    }
}

import java.io.*;
/**
 * kelas untuk menulis id 
 * 
 * @author erithiana sisijoan
 * @version 10
 */
public class LogData
{
    /**
     * variabel untuk menyimpan direktori file
     */
    String file="logId.txt";
    PrintWriter writer;
    /**
     * Constructor for objects of class LoadData
     */
    public LogData()
    {
        
    }
    
    /**
     * Method untuk menulis kedalam File
     * @param String
     */
    public void write(String input){
        try{
            writer=new PrintWriter(file);
            writer.println(input);
            writer.close();
        }
        catch(FileNotFoundException e){
            Bank.nextID=1000;
        }
    }
    
    /**
     * Method untuk membaca File
     * @return String yang terbaca
     */
    public String readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
    
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}

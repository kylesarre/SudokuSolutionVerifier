package java_threadsafe_demos;
import java.util.*;
import java.io.*;
/**
 * Reads a text file and creates a scanner object with that file
 * @author Kyle
 */
public class ReadFile 
{
    private File inputFile;
    private Scanner scan;
    
    public ReadFile(String fileName)
    {
        inputFile = new File("C:\\Users\\Kyle\\Documents\\NetBeansProjects\\Java_ThreadSafe_Demos\\src\\java_threadsafe_demos\\" + fileName);
        try
        {
            scan = new Scanner(inputFile);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Scanner getScanner()
    {
        return scan;
    }
}

package java_threadsafe_demos;
import java.util.*;
/**
 * Parses a scanner with sudoku solutions and stores the solutions in an an ArrayList.
 * View the header for the ReadFile class to see how the input file should be formatted for parsing
 * @author Kyle
 */
public class SudokuParser 
{
    Scanner scan;
    
    public SudokuParser(Scanner scan)
    {
        this.scan = scan;
    }
    
    // generates an ArrayList that stores nxn sudoku solutions
    public ArrayList<int[][]> parseData()
    {
        ArrayList<int[][]> solutions = new ArrayList();
        while(scan.hasNextLine())
        {
            int size = scan.nextInt();
            scan.nextLine();
            int[][] solution = new int[size][];
            for(int k = 0; k < size; k++)
            {
		String sData = scan.nextLine();               
                sData = sData.replaceAll("\\s", "");
                System.out.println(sData);
		int[] iData = StringToInt(sData);
		solution[k] = iData;
            }
            //System.out.println(Arrays.deepToString(solution));
            solutions.add(solution);
        }
        return solutions;
    }
    
    // converts string of integers (no whitespace) to an array of integers
    public int[] StringToInt(String string)
    {
        int[] rowNums = new int[string.length()];
        for(int i = 0; i < string.length(); i ++)
        {
            rowNums[i] = Integer.parseInt(string.substring(i, i+1));
        }
        return rowNums;
    }
    
    // returns an nxn sudoku solution corresponding to the specified index
    public int[][] getSolution(ArrayList<int[][]> solutions,int index)
    {
        return solutions.get(index);
    }
}

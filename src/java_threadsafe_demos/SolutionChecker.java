package java_threadsafe_demos;
import java.util.*;
/**
 *
 * @author Kyle
 */
public class SolutionChecker 
{   
    public static void main(String args[])
    {
        int threadTypes = 3;
        boolean validSolution = false;
        ReadFile reader = new ReadFile("SudokuSolutions.txt");
        SudokuParser parser = new SudokuParser(reader.getScanner());
        ArrayList<int[][]> solutions = parser.parseData();
        
        for(int[][] solution : solutions)
        {
            Thread[] rowThreads = new Thread[solution.length];
            RowCheck[] rowCheck = new RowCheck[solution.length];
            Thread[] colThreads = new Thread[solution.length];
            Thread[] subGThreads = new Thread[solution.length];
            Thread[] allThreads = new Thread[solution.length];
            
             // initialization of threads to check each row of the solution               
            for(int i = 0; i < solution.length; i++)
            {
                rowCheck[i] = new RowCheck(i, solution);
                rowThreads[i] = new Thread(rowCheck[i]);
                rowThreads[i].start();
            }
            
            // wait for all row threads to finish
            for(Thread thread : rowThreads)
            {
                try
                {
                    thread.join();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            // all threads should be finished; run a test on all the objects to verify the solution
            for(RowCheck rowcheck : rowCheck)
            {
                System.out.println(rowcheck.possibleSolution);
                if(!rowcheck.possibleSolution)
                {
                    validSolution = false;
                    break;
                }
                else
                    validSolution = true;
            }
        System.out.println();
        System.out.println("Row Test Final result: " + validSolution);
        }
        
        
        
        
       
        
        
        
        
        
        // Initialization of the column part of the problem
        // Initialization of the subGrid part of the problem
    }
   
}

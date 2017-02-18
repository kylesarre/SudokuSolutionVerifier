package java_threadsafe_demos;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */
public class RowCheck implements Runnable 
{
    HashSet<Integer> intLookup;
    int row;
    int[][] solution;
    boolean possibleSolution;
    
    public RowCheck(int row, int[][] solution)
    {
        intLookup = new HashSet();
        this.solution = solution;
        this.row = row;
        possibleSolution = true;
    }
    
    public boolean check()
    {
        int i = 0;
        while(possibleSolution)
        {
            if(i >= solution.length)
                return possibleSolution;
            int curNum = solution[row][i];
            i++;
            if( curNum <= 9 && curNum >= 1 && !intLookup.contains(curNum) )
                intLookup.add(curNum);          
            else
                possibleSolution = false;
        }
        return possibleSolution;       
    }
    
    @Override
    public void run() 
    {
        System.out.println(Arrays.deepToString(solution));
        possibleSolution = check();
    }
    
}

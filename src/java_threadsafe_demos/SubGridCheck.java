/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodokuverifier;
import java.util.*;
/**
 *
 * @author kyle
 */
public class SubGridCheck implements Runnable
{
    HashSet<Integer> set;
    int index;
    int[][] solution;
    boolean possibleSolution;
    
    public SubGridThread(int index, int[][] solution)
    {
        set = new HashSet();
        this.index = index;
	this.solution = solution;
        possibleSolution = true;
    }

    public boolean check()
    {
        int rowOffset = (index*3)/solution.length;
        int columnOffset = (index*3)%solution.length;
        
        for(int i = 0; i < solution.length; i++)
        {
            int element = solution[rowOffset + i*3/solution.length][columnOffset + i*3%solution.length];
        }
    }

    @Override
    public void run() 
    {
        check();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodokuverifier;

/**
 *
 * @author kyle
 */
public class ColumnThread implements Runnable
{
    int column;
    boolean possibleSolution;
    
    public ColumnThread(int column)
    {
        this.column = column;
        possibleSolution = true;
    }
    
    @Override
    public void run() 
    {
        
    }
    
}

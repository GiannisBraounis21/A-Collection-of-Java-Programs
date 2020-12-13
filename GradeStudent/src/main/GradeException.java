/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;

/**
 *
 * @author John
 */
public class GradeException extends Exception 
{
    private int number;
    
    public GradeException()
    {
        super();
    }
    
    public GradeException(String msg)
    {
        super(msg);
    }
    
    public GradeException(String msg , int number)
    {
        super(msg+":"+number);
        this.number = number;
    }
    
    public int getNumber()
    {
        return number;
    }
}

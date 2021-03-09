package goosegame;
import java.io.*;
/*
 * @author Gioani Braouni DIT18131
 */
public abstract class SpecialSquare 
{    
    private final int squareNumber;
    private final String squareDesc;
    
    public SpecialSquare(int squareNumber , String squareDesc) 
    {
        this.squareNumber = squareNumber;
        this.squareDesc = squareDesc;
    }
    
    public int getSquareNumber()
    {
        return squareNumber;
    }
    
    public String getDesc()
    {
        return squareDesc;
    }
    
    public abstract void action(Player player,int number,boolean flag);
}

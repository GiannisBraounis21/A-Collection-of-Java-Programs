/*
 * @author Gioani Braouni DIT18131
 */
package goosegame;
import java.io.*;

public class BasicSquare 
{
    private final int squareNumber;
    private final String squareDesc;
    
    public BasicSquare(int squareNumber) 
    {
        this.squareNumber = squareNumber;
        this.squareDesc = "Basic";
    }
    
    public String getDesc()
    {
        return squareDesc;
        
    }
    public int getSquareNumber()
    {
        return squareNumber;
    }
    
    public void action(Player player)
    {
        System.out.println();
        System.out.println("Ο παικτης " + player.getName() + " απο το τετραγωνο με αριθμο " + player.getSquareBeforeDiceThrow());
        System.out.println("Eφτασε σε " + squareDesc + " με αριθμο τετραγωνου " + squareNumber);
        System.out.println();
    }
}

/*
 * @author Gioani Braouni DIT18131
 */
package goosegame;

import java.io.Serializable;
import java.util.Random;


public class Player implements Serializable
{
    private final String name;
    private int currentSquare;
    private int squareBeforeDiceThrow;
    private int totalCoin;
    //Για το 10
    //Μπανει εδω και οχι στο lose2 επειδη 
    //Υπαρχει περιπτωση 2+ παικτες να μπουν στο τετραγωνο 19
    private boolean roundSem[] = {false,false};
    private boolean canContinue = false;
    //Για το 11,13
    private boolean cannotContinue = false;
            
    private Random rnd = new Random();

    //constructorr
    public Player(String name)
    {
        this.name = name;
        this.currentSquare=0;
        this.squareBeforeDiceThrow=0;
        this.totalCoin = 5;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int throwDice()
    {
        int dice;
        dice = rnd.nextInt(6) + 1;
        System.out.println("Ο παικτης " + name + " εριξε " + dice);
        return dice;
        
    }
    
    public void moveTo(int value , boolean changeCurrentSquare)
    {
        squareBeforeDiceThrow = currentSquare;
        
        /*  Επειδη το currentSquare προσθετει τα ζαρια που εριξε ο χρηστης
            εαν βρεθει σε τετραγωνο οπου τον επιστρεφει σε προηγουμενο η σε επομενο τετραγωνο
            πρεπει να αλλαξει η τιμη του currentSquare
            και η squareBeforeDiceThrow να μεινει το ιδιο
        */
        
        if(changeCurrentSquare == true)
            currentSquare = value;
        else
            currentSquare += value;
            
 
    }
    
    public int getCurrentSquare()
    {
        return currentSquare;
    }
    
    public int getSquareBeforeDiceThrow()
    {
        return squareBeforeDiceThrow;
    }
    
    public boolean getRoundSem(int i)
    {
        return roundSem[i];
    }
    
    public void setRoundSem(int i,boolean flag)
    {
        roundSem[i] = flag;
    }
    
    public boolean getCanContinue()
    {
        return canContinue;
    }
    
    public void setCanContinue(boolean flag)
    {
       canContinue = flag;
    }
    
    public boolean getCannotContinue()
    {
        return cannotContinue;
    }
    
    public void setCannotContinue(boolean flag)
    {
        cannotContinue = flag;
    }
    
    public int getTotalCoin()
    {
        return totalCoin;
    }
    
    public void setTotalCoin(int x)
    {
        totalCoin = x;
    }
}

package goosegame;

/*
 * @author Gioani Braouni DIT18131
 */

public class GooseGame 
{
    public static void main(String[] args) 
    {
        boolean result;
        
        Game game = new Game();
        
        game.initGame();
        
        result = game.startGame();
        
        if(result == true)
            game.printWinner();
        
    }  
    
}

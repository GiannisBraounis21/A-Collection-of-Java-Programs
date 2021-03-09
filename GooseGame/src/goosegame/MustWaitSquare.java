package goosegame;
/**
 *
 * @author Giannis Braouni DIT18131
 */
public class MustWaitSquare extends SpecialSquare
{
    
    public MustWaitSquare(int squareNumber , String squareDesc) 
    {
        super(squareNumber,squareDesc);
    }

    //η toString καλο ειναι να μην δεχεται καποια παραμετρο γιαυτο γραφτηκε 
    //η εκτυπωση με αυτο το τροπο
    @Override
    public void action(Player player,int dice_total,boolean flag) 
    {
        player.moveTo(dice_total,flag);
        System.out.println("Ο παικτης " + player.getName() + " απο το τετραγωνο με αριθμο " + player.getSquareBeforeDiceThrow());
        System.out.println("Eφτασε σε " + super.getDesc() + " με αριθμο τετραγωνου " + player.getCurrentSquare());
        System.out.println();
        
    }
}

/*
 * @author Gioani Braouni DIT18131
 */
package goosegame;

public class GooseSquare extends SpecialSquare
{

    public GooseSquare(int squareNumber , String squareDesc) 
    {
        super(squareNumber,squareDesc);
    }

    //η toString καλο ειναι να μην δεχεται καποια παραμετρο γιαυτο γραφτηκε 
    //η εκτυπωση με αυτο το τροπο
    @Override
    public void action(Player player,int dice_total,boolean flag) 
    {
        int GooseSquares[]={5,9,14,18,23,27,32,36,41,45,50,54,59};
        
        player.moveTo(dice_total,flag);
        System.out.println("Ο παικτης " + player.getName() + " απο το τετραγωνο με αριθμο " + player.getSquareBeforeDiceThrow());
        if(flag==true && dice_total!=59)
            System.out.print("Eφτασε σε Basic");
        else if(player.getCurrentSquare() == 31)
            System.out.print("Eφτασε σε Well");
        else
        {
            //Ελεγχει εαν εφτασει σε Goose Square η Basic
            for(int i = 1; i<=63; i++)
            {
                flag = false;
                for(int j =0; j<13; j++)
                {
                    if(GooseSquares[j]==i)
                    {
                        flag = true;
                    }
                }
            }
            if(flag==true)
                System.out.print("Eφτασε σε " + super.getDesc());
            else
                System.out.print("Eφτασε σε Basic");
        }
        System.out.println(" με αριθμο τετραγωνου " + player.getCurrentSquare());
        System.out.println();
        
    }
}

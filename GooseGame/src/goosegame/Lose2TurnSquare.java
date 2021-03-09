/*
 * @author Gioani Braouni DIT18131
 */
package goosegame;

public class Lose2TurnSquare extends SpecialSquare
{
    public Lose2TurnSquare(int squareNumber , String squareDesc) 
    {
        super(squareNumber,squareDesc);
    }

    //η toString καλο ειναι να μην δεχεται καποια παραμετρο γιαυτο γραφτηκε 
    //η εκτυπωση με αυτο το τροπο
    @Override
    public void action(Player player,int number,boolean flag) 
    {
        //Ο παικτης παραμενει για 2 γυρους
        //υλοποιειται με semaphores
        if(player.getRoundSem(0)==false)
        {
            //καθεται για 1 round
            player.setRoundSem(0,true);
            System.out.println("Ο " + player.getName() + " παραμενει στο ιδιο κελι για 1 round");
            System.out.println();
        }
        else if(player.getRoundSem(0)==true && player.getRoundSem(1)==false)
        {
            //καθεται για 2ο round
            player.setRoundSem(1,true);
            System.out.println("Ο " + player.getName() + " παραμενει στο ιδιο κελι για 1 round");
            System.out.println();
        }
        else if(player.getRoundSem(0)==true && player.getRoundSem(1)==true)
        {
            //εχει κατσει για 2 rounds οι semaphores γινονται down
            //και ο παικτης συνεχιζει κανονικα το παιχνιδι
            player.setRoundSem(0,false);
            player.setRoundSem(1,false);
            System.out.println("Ο " + player.getName()+ " μπορει να συνεχισει");
            System.out.println();
            player.setCanContinue(true);
        }
    }
    
}

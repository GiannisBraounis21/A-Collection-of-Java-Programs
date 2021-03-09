package goosegame;

import java.io.*;
import java.util.*;

/*
 * @author Gioani Braouni DIT18131
 */

public class Game 
{
    ArrayList<Player> player = new ArrayList<>();
    
    private String winnerName;
    
    public void initGame()
    {
        System.out.println("Καλως ηρθατε στο παιχνιδι της Χηνας.");
     
        String playersName[] = {"John","Nick","Peter","George","Paul","Jack"};
        
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Δωσε αριθμο παικτων(2-6.)");
        
        //Ελεγχει την εισοδο που δινει ο χρηστης για τους παικτες
        while(true)
        {
            try
            {
                int playersNum = input.nextInt();
                if(playersNum>=2 && playersNum<=6)
                {
                    for(int i = 0; i<playersNum; i++)
                    {
                        Player pl = new Player(playersName[i]);
                        
                        player.add(pl);
                        System.out.println("Ο παικτης " + pl.getName() + " εχει προστεθει επιτυχως στο παιχνιδι.");
                    }
                    System.out.println();
                    break;
                }
                else
                {
                    throw new ArithmeticException("Παρακαλω δωσε σωστο αριθμο παικτων(2-6).");
                }
            }
            catch(InputMismatchException e)
            {
                System.err.println("Παρακαλω δωσε ακεραιο αριθμο.");
            }
            catch(ArithmeticException e)
            {
                System.err.println(e.getMessage());
            }
            input.nextLine();
        }
    }
    public boolean startGame()
    {
        int i=0;
        int j=0;
        int dice_total=0;
        boolean winnerFound=false;
        
        Board board = new Board();
        while(true)
        {
            j++;
            if(j>1)
            {
                System.out.println("Μηπως θα ηθελες να κανεις save/load το παιχνιδι");
                System.out.println("Πληκτρολoγησε yes η no");
                    Scanner input = new Scanner(System.in);
                    String answear = input.nextLine();
                    if(answear.equalsIgnoreCase("yes"))
                    {
                        System.out.println();
                        System.out.println("Save η Load");
                        answear = input.nextLine();
                        if(answear.equalsIgnoreCase("save"))
                        {
                            saveGame(board);
                        }
                        else if(answear.equalsIgnoreCase("load"))
                        {
                            if(loadGame()==null)
                            {
                                System.out.println("H ανακτηση δεν εγινε επιτυχως");
                                System.out.println();
                            }
                            else
                            {
                                System.out.println("Η ανακτηση εγινε επιτυχως");
                                System.out.println();
                                player = loadGame();
                            }
                        }
                    }
            }
            for(Player currentPlayer : player)
            { 
                int dice1;
                int dice2;
                int k;
                
                //Ελεγχω εαν δεν εχει coins πριν ξεκινησει την σειρα του ο παικτης
                if(currentPlayer.getTotalCoin()<0)
                {
                    k=0;
                    for(Player plr:player)
                    {
                        if(plr.getTotalCoin()<0)
                            k++;
                    }
                    //Εαν ολοι οι παικτες δεν εχουν coins τοτε σταματαει το παιχνιδι
                    if(player.size()==k)
                    {
                        System.out.println("Το παιχνιδι σταματαει γιατι κανενας παιχτης δεν εχει αλλα coins");
                        return false;
                    }
                    else
                        System.out.println("O παικτης " + currentPlayer.getName() + " δεν μπορει να συνεχισει γιατι δεν εχει αλλα coins");
                        System.out.println();
                    //Αλλιως κανει μονο skip την σειρα του παικτη που δεν εχει coins
                    continue;
                }
                
                //Τετραγωνο Inn
                if(currentPlayer.getCurrentSquare()==19)
                {
                    //Εκτυπωνει μηνυμα προς τον χρηστη
                    board.getSpecialSquare(currentPlayer.getCurrentSquare()).action(currentPlayer, 0, false);
                    
                    //Ο παικτης πρεπει να κατσει
                    if(currentPlayer.getCanContinue()==false)
                        continue;
                    
                    //Ηρθε η ωρα ο παικτης να φυγει
                    currentPlayer.setCanContinue(false);
                    
                    //Χανει coin
                    currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()-1);
                }
                //Τετραγωνο Well
                else if(currentPlayer.getCurrentSquare()==31)
                {
                    //Η μεταβλητη CanContinue χρησιμοποειται ως βοηθητικη
                    //Ειναι πεδιο της κλασης player
                    if(currentPlayer.getCanContinue()==false)
                    {
                        //Δεν μπορει να φυγει ο παικτης
                        currentPlayer.setCannotContinue(true);
                    
                        System.out.println("Ο παικτης " + currentPlayer.getName() + " πρεπει να κατσει μεχρι να ερθει ενας αλλος παικτης στο τετραγωνο 31");
                        System.out.println();
                        
                        //Ελεγχει εαν υπαρχει καποιος παικτης που ειναι στο ιδιο κελι και περιμενει να φυγει
                        for(Player oldPlayer : player )
                        {
                            if(oldPlayer.getName()!=currentPlayer.getName())
                            {
                                //Εαν η συνθηκη ειναι true 
                                //Βρεθηκε παικτης που περιμενει να φυγει
                                if(oldPlayer.getCannotContinue()==true && oldPlayer.getCurrentSquare()==31)
                                {
                                    System.out.println("Ο παικτης " + oldPlayer.getName() + " μπορει να αποχωρησει απο το τετραγωνο ");
                                    System.out.println();
                                    //Ενημερωνει καταλληλα τα πεδια της κλασης του παλιου παικτη
                                    oldPlayer.setCannotContinue(false);
                                    oldPlayer.setCanContinue(true);
                                    
                                    //Μπορει να υπαρχουν και αλλοι παικτες στο ιδιο τετραγωνο
                                    //Γιαυτο το λογο υπαρχει το continue
                                    continue;
                                }
                            }
                        }
                    }
                    if(currentPlayer.getCannotContinue()==true)
                    {
                        //Ο νεος παικτης πρεπει να κατσει
                        if(currentPlayer.getCurrentSquare()==31)
                            continue;
                    }
                }
                //Τετραγωνο Prison
                else if(currentPlayer.getCurrentSquare()==52)
                {
                    //Βοηθητικη μεταβλητη η flag & canContinue
                    //Οταν μπει ο νεος παικτης σε αυτο το κελι και βρεθει ενας παλιος παικτης που περιμενει ηδη
                    //Ο νεος φευγει στον γυρο αυτο , ο παλιος οταν ερθει σειρα του.
                    //Οταν ο oldPlayer γινει currentPlayer δεν θα μπει στο 1ο if γιατι
                    //η CanContinue ειναι true απο πριν και ετσι συνεχιζει κανονικα
                    boolean flag = false;
                    if(currentPlayer.getCanContinue()==false)
                    {
                        currentPlayer.setCannotContinue(true);
                        System.out.println("Ο παικτης " + currentPlayer.getName() + " πρεπει να κατσει μεχρι να ερθει ενας αλλος παικτης στο τετραγωνο 52");
                        System.out.println();
                        //Ελεγχει εαν υπαρχει καποιος παικτης που ειναι στο ιδιο κελι και περιμενει να φυγει
                        for(Player oldPlayer : player )
                        {
                            if(oldPlayer.getName()!=currentPlayer.getName() && oldPlayer.getCurrentSquare()==52)
                            {
                                //Βρεθηκε παικτης που περιμενει να φυγει
                                if(oldPlayer.getCannotContinue()==true )
                                {
                                    System.out.println("Ο παικτης " + oldPlayer.getName() + " μπορει να αποχωρησει απο το τετραγωνο ");
                                    System.out.println();
                                    oldPlayer.setCannotContinue(false);
                                    oldPlayer.setCanContinue(true);
                                    flag = true;
                                    continue;
                                }
                            }
                        }
                    }
                    else
                        flag=true;
                    if(flag==true)
                    {
                        //Ο νεος παικτης συνεχιζει την διαδρομη του
                        currentPlayer.setCannotContinue(false);
                        System.out.println("Ο παικτης " + currentPlayer.getName() + " μπορει να συνεχισει την διαδρομη του");
                        System.out.println();
                    }
                    else
                        //Αλλιως καθεται
                        continue;
                }
                
                //Ο παικτης ριχνει τα ζαρια
                dice1 = currentPlayer.throwDice();
                dice2 = currentPlayer.throwDice();
                
                //Οταν ο παικτης βρισκεται στην αρχη του παιχνιδιου
                //ελεγχει τα πρωτα ζαρια που θα ριξει
                if(currentPlayer.getCurrentSquare()==0)
                {
                    if(dice1==6 && dice2==3)
                    {
                        currentPlayer.moveTo(26,true);
                        System.out.println();
                        System.out.println("Ο παικτης " + currentPlayer.getName() + " απο το τετραγωνο με αριθμο " + currentPlayer.getSquareBeforeDiceThrow());
                        System.out.println("Eφτασε σε Basic τετραγωνο με αριθμο 26");
                        System.out.println();
                        continue;
                    }
                    else if(dice1==5 && dice2==4)
                    {
                        currentPlayer.moveTo(53,true);
                        System.out.println();
                        System.out.println("Ο παικτης " + currentPlayer.getName() + " απο το τετραγωνο με αριθμο " + currentPlayer.getSquareBeforeDiceThrow());
                        System.out.println("Eφτασε σε Basic τετραγωνο με αριθμο 53");
                        System.out.println();
                        continue;
                    }
                    
                }
                
                //Ο παικτης μετακινειται
                dice_total = dice1 + dice2;
                currentPlayer.moveTo(dice_total,false);
                
                //Αποθηκευω την θεση του παιχτη στο ταμπλο που βρισκεται ο Player
                k=currentPlayer.getCurrentSquare();
                
                //Εδω υλοποιω τον κανονα 8
                for(Player player : player )
                {
                        //Συγκρινει καθε φορα τον παικτη ειναι η σειρα του
                        //Με τους παικτες στην λιστα
                        if(currentPlayer.getName()!=player.getName())
                        {
                            //Ο κανονας 8 δεν ισχυει για το τετραγωνο :
                            //0 επειδη ειναι η αρχη
                            //19 επειδη χανει 2 γυρους
                            //31,52 επειδη περιμενει εκει
                            if(k!=0 && k!=19 && k!=31 && k!=52)
                            {
                                //Ελεγχει την θεση που βρισκεται ο currentPlayer 
                                //με την θεση των υπολοιπων παικτων στο ταμπλο
                                if(k==player.getCurrentSquare())
                                {
                                    int square = currentPlayer.getSquareBeforeDiceThrow();
                                    System.out.println();
                                    System.out.println("Ο παικτης " + currentPlayer.getName() + " εφτασε στο ιδιο τετραγωνο που ηταν ο " + player.getName());
                                    System.out.println("Ο παικτης " + player.getName() + " πρεπει να μεταφερθει στο τετραγωνο οπου ξεκινησε ο " + currentPlayer.getName());
                                    
                                    //Ο παιχτης απλα πηγαινει πισω και δεν κανει τιποτα αλλο ανεξαρτητος τι τετραγωνο ειναι
                                    player.moveTo(square, true);
                                }
                            }
                        }
                }
                //Πρεπει να γυρισει πισω στο τετραγωνο 59
                if(currentPlayer.getCurrentSquare()>63)
                {
                    System.out.println();
                    board.getSpecialSquare(59).action(currentPlayer, 59, true);
                    //εδω εαν δεν υπαρχει το continue θα ξαναριξει τα ζαρια επειδη 
                    //το 59 ειναι GooseSquare
                    continue;
                }
                //Ελεγχω εαν ειναι basic
                if(board.getBasicSquare(k)!=null)
                {
                    board.getBasicSquare(k).action(currentPlayer);
                }
                else
                {
                    //Ελεγχω την περιπτωση που φτασει σε MoveSquare η GooseSquare:
                    
                    System.out.println();
                    System.out.println("Ο παικτης " + currentPlayer.getName() + " απο το τετραγωνο με αριθμο " + currentPlayer.getSquareBeforeDiceThrow());
                    System.out.println("Eφτασε σε " + board.getSpecialSquare(k).getDesc() + " με αριθμο τετραγωνου " + board.getSpecialSquare(k).getSquareNumber());
                    System.out.println();
                    //Οχι αρα ελεγχω μονο Square
                    if(currentPlayer.getCurrentSquare()==6)
                    {
                        currentPlayer.moveTo(12, true);
                        board.getBasicSquare(12).action(currentPlayer);
                        currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()-1);
                    }
                    else if(currentPlayer.getCurrentSquare()==42)
                    {
                        currentPlayer.moveTo(30, true);
                        board.getBasicSquare(30).action(currentPlayer);
                        currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()-1);
                    }
                    else if(currentPlayer.getCurrentSquare()==58)
                    {
                        currentPlayer.moveTo(1, true);
                        board.getBasicSquare(1).action(currentPlayer);
                        currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()-1);
                    }
                    else if(board.getSpecialSquare(k).getDesc().equals("Goose"))
                    {
                        board.getSpecialSquare(k).action(currentPlayer,dice_total,false);
                        //Εαν ριξει τα ιδια ζαρια και ξεπερασει το τετραγωνο 63 ξαναγυρναει πισω
                        if(currentPlayer.getCurrentSquare()>63)
                        {
                            System.out.println();
                            board.getSpecialSquare(59).action(currentPlayer, 59, true);
                            continue;
                        }
                    }
                }
                
                //Coin System
                if(currentPlayer.getCurrentSquare()<63)
                {
                    //Εαν ειναι σε τετραγωνο πρεπει να περιμενει , να μην τον ρωταει σχετικα με τα coins
                    if(currentPlayer.getCurrentSquare()==52 || currentPlayer.getCurrentSquare()==31)
                        continue;
                    
                    System.out.println("Παικτη: " + currentPlayer.getName());
                    System.out.println("Θα ηθελες να κερδισεις ενα coin και να γυρισεις 5 τετραγωνα πισω? (1)");
                    System.out.println("Ή να ριξεις ξανα με κοστος 2 coins?(2)");
                    System.out.println();
                    System.out.println("Δωσε 1,2 ή 3 εαν δεν θελεις");
                    System.out.println();
                    
                    Scanner input = new Scanner(System.in);
                    int playersChoice = input.nextInt();
                    
                    //Ο παικτης κερδιζει coin και γυριζει 5 τετραγωνα πισω
                    if(playersChoice==1)
                    {    
                        //Ο παικτης δεν εχει την δυνανοτητα να γυρισω πισω απο τα αρνητικα
                        if(currentPlayer.getCurrentSquare()>=5)
                        {
                            currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()+1);
                        
                            k=currentPlayer.getCurrentSquare()-5;
                            currentPlayer.moveTo(k, true);
                        }
                        else
                        {
                            System.out.println("Πρεπει να βρισκεσαι σε τετραγωνο με αριθμο μεγαλυτερο απο το 5");
                            System.out.println();
                        }
                    }
                    //Ριχνει ζαρια , αφαιρωντας 2 coin
                    else if(playersChoice==2)
                    {
                        currentPlayer.setTotalCoin(currentPlayer.getTotalCoin()-2);
                        
                        //Πριν μετακινηθει ο παικτης βλεπει εαν εχει αρνητικα coins
                        if(currentPlayer.getTotalCoin()<0)
                        {
                            k=0;
                            for(Player plr:player)
                            {
                                if(plr.getTotalCoin()<0)
                                    k++;
                            }
                            //Εαν ολοι οι παικτες δεν εχουν coins τοτε σταματαει το παιχνιδι
                            if(player.size()==k)
                            {
                                System.out.println("Το παιχνιδι σταματαει γιατι κανενας παιχτης δεν εχει αλλα coins");
                                return false;
                            }
                            else
                                System.out.println("O παικτης " + currentPlayer.getName() + " δεν μπορει να συνεχισει γιατι δεν εχει αλλα coins");
                                System.out.println();
                            //Αλλιως κανει μονο skip την σειρα του παικτη που δεν εχει coins
                            continue;
                        }
                        
                        //Ο παικτης ριχνει 2 ζαρια και παει στο τετραγωνο
                        dice1 = currentPlayer.throwDice();
                        dice2 = currentPlayer.throwDice();
                        dice_total = dice1 + dice2;
                        currentPlayer.moveTo(dice_total, false);
                        
                        k=currentPlayer.getCurrentSquare();
                    }
                    if(playersChoice!=3)
                    {
                        //Ελεγχω εαν εφτασει σε Basic
                        if(board.getBasicSquare(k)!=null)
                            board.getBasicSquare(k).action(currentPlayer);
                        else
                        {
                            //Τετραγωνο Inn
                            if(currentPlayer.getCurrentSquare()==19)
                            {
                                System.out.println("Ο παικτης " + currentPlayer.getName() + " απο το τετραγωνο με αριθμο " + currentPlayer.getSquareBeforeDiceThrow());
                                System.out.println("Eφτασε σε " + board.getSpecialSquare(k).getDesc() + " με αριθμο τετραγωνου " + board.getSpecialSquare(k).getSquareNumber());
                                System.out.println();
                            }
                            //Ξεπερασε το 63
                            else if(currentPlayer.getCurrentSquare()>63)
                            {
                                board.getSpecialSquare(59).action(currentPlayer, 59, true);
                                System.out.println("Ο παικτης " + currentPlayer.getName() + " εχει συνολικα coins " + currentPlayer.getTotalCoin());
                                System.out.println();
                                //εδω εαν δεν υπαρχει το continue θα ξαναριξει τα ζαρια επειδη 
                                //το 59 ειναι GooseSquare
                                continue;
                            }
                            //Εφτασε σε Goose τετραγωνο
                            else if(board.getSpecialSquare(k).getDesc().equals("Goose"))
                            {
                                System.out.println();
                                //Η εντολη αυτη καλυπτει ολα τα τετραγωνα Goose
                                board.getSpecialSquare(k).action(currentPlayer,dice_total,false);
                                System.out.println("Ο παικτης " + currentPlayer.getName() + " εχει συνολικα coins " + currentPlayer.getTotalCoin());
                                System.out.println();
                                continue;
                            }
                            //Η εντολη αυτη καλυπτει ολα τα υπολοιπα τετραγωνα
                            //Γιατι καθε τετραγωνο εχει δικο του Print
                            board.getSpecialSquare(k).action(currentPlayer,k,false);
                        }                  
                    }
                }
                
                System.out.println("Ο παικτης " + currentPlayer.getName() + " εχει συνολικα coins " + currentPlayer.getTotalCoin());
                System.out.println();
                
                //Eαν ο παικτης ειναι στο τετραγωνο 63 , βρεθηκε νικητης και σταματαει το παιχνιδι
                if(currentPlayer.getCurrentSquare()==63)
                {
                    winnerFound = true;
                    winnerName = currentPlayer.getName();
                    break;
                }
            }
            if(winnerFound == true)
            {
                return true;
            }
        }
        
        
    }
    public void printWinner()
    {
        System.out.println("Ο παικτης " + winnerName + " νικησε το παιχνιδι της χηνας");
    }
    private void saveGame(Board board)
    {
        try
        {
            //Δημιουργει ενα δυαδικο αρχειο savegame.bin
            FileOutputStream fileOut = new FileOutputStream("Savegame.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //Γραφει το αντικειμενο player γιατι μας ενδιαφερει οι θεσεις του καθε παικτη
            //Τα πεδια των αλλων κλασεων δεν αλλαζουν κατα την διαρκεια εκτελεσης του προγραμματος
            //Και παραμενουν παντα σταθερα
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.println("Η αποθηκευση εγινε επιτυχως");
            System.out.println();
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
    private ArrayList<Player> loadGame()
    {
        try
        {
            //Ανοιγω το αρχειο
            FileInputStream fileIn = new FileInputStream("Savegame.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //Εισαγω στην λιστα player αυτα που διαβαζει το προγραμμα
            //Το typecast γινεται γιατι πρεπει να ξερει το τυπο που διαβαζει
            ArrayList<Player>  player = (ArrayList<Player>)(in.readObject());
            fileIn.close();
            in.close();
            return player;
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println(e);
        }
        return null;
    }
}

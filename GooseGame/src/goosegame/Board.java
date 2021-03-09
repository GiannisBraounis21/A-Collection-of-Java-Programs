package goosegame;

import java.util.ArrayList;
import java.io.Serializable;

/*
 * @author Gioani Braouni DIT18131
 */

public class Board implements Serializable
{
    private ArrayList<SpecialSquare> s_square = new ArrayList<>();
    private ArrayList<BasicSquare> b_square = new ArrayList<>();
    
    private int GooseSquares[]={5,9,14,18,23,27,32,36,41,45,50,54,59};
    
    public Board()
    {
        //Αρχικοποιει τα squares σε basic και special
        for(int i = 1; i<=63; i++)
        {
            boolean specialSquare = false;
            for(int j =0; j<13; j++)
            {
                if(GooseSquares[j]==i)
                {
                   addSpecialSquare(new GooseSquare(i,"Goose"));
                   specialSquare = true;
                }
            }
            if(!specialSquare)
            {
                switch(i)
                {
                case 6:
                    addSpecialSquare(new MoveSquare(i,"Bridge"));
                    break;
                case 19:
                    addSpecialSquare(new Lose2TurnSquare(i,"Inn"));
                    break;
                case 31:
                     addSpecialSquare(new MustWaitSquare(i,"Well"));
                    break;
                case 42:
                    addSpecialSquare(new MoveSquare(i,"Labyrinth"));
                    break;
                case 52:
                    addSpecialSquare(new MustWaitSquare(i,"Prison"));
                    break;
                case 58:
                    addSpecialSquare(new MoveSquare(i,"Death"));
                    break;
                default:
                    addBasicSquare(new BasicSquare(i));
                    break;
                }
            }        
        }
    }
    
    private void addSpecialSquare(SpecialSquare object)
    {
        s_square.add(object);
    }
    private void addBasicSquare(BasicSquare object)
    {
        b_square.add(object);
    }
    public BasicSquare getBasicSquare(int squareNum)
    {
        int k=0;
        for(BasicSquare square : b_square )
        {
            if(square.getSquareNumber()==squareNum)
            {
                return b_square.get(k);
            }
            k++;
        }
       return null;
    }
    
    public SpecialSquare getSpecialSquare(int squareNum)
    {
        int k=0;
        for(SpecialSquare square : s_square )
        {
            if(square.getSquareNumber()==squareNum)
            {
                return s_square.get(k);
            }
            k++;
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;
import java.util.Scanner;

public class Lab02 {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Για ενεργοποιηση τηλεορασης πατα τo κοκκινο κουμπι");
        String x = input.nextLine();
        TV TvRemote = new TV();
        if(x.equals("red button"))
        {
            System.out.println("Η τηλεοραση ανοιξε");
            System.out.println("Για να αλλαξεις καναλι πατα το (+ch) η (-ch)");
            System.out.println("Για να δυναμωσεις/κατεβασεις την φωνη πατα το (+vol) η (-vol)");
            System.out.println("Για να απενεργοποιησεις την τηλεοραση πατα το κοκκινο κουμπι");
            TvRemote.turnTvOnOff(true);
            TvRemote.setTVDefaultSettings();
            do
            {
                x = input.nextLine();
                if(x.equals("+ch")||x.equals("-ch"))
                {
                    TvRemote.channel(x);
                    System.out.println("Το καναλι της τηλεορασης αλλαξε σε: " + TvRemote.channel);
                }
                else if(x.equals("+vol")||x.equals("-vol"))
                {
                    TvRemote.volume(x);
                    if((TvRemote.getVolume())==0)
                    {
                        System.out.println("Η φωνη δεν αλλαξε γιατι εχεις ξεπερασει το οριο");
                    }
                    else
                    {
                        System.out.println("Η φωνη αλλαξε σε: " + TvRemote.getVolume());
                    }
                }
                else if(x.equals("red button"))
                {
                    TvRemote.turnTvOnOff(false);
                    System.out.println("Η τηλεοραση εκλεισε");
                }
                else
                {
                    System.out.println("Εδωσες λαθος επιλογη");
                }
            }while(TvRemote.is0n()!=false);
        }
        else
        {
            System.out.println("Εδωσες λαθος επιλογη");
        }
        
    }
    
}

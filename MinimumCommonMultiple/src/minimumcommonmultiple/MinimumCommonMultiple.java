/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumcommonmultiple;

import java.util.Scanner;

/**
 *
 * @author wwwbr
 */
public class MinimumCommonMultiple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuChoice();
    }
    public static void menuChoice()
    {
        while(true)
        {
            System.out.println("1. Ευρεση ΕΚΠ");
            System.out.println("2. Βοηθεια");
            System.out.println("3. Έξοδος");
            
            System.out.println("Δωσε εναν αριθμο απο");
            System.out.println("το 1 εως το 3");
            
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if(choice==1)
            {
                System.out.println("Δωσε 2 ακεραιους θετικους αριθμους");
                while(true)
                {
                    int number1 = input.nextInt();
                    int number2 = input.nextInt();
                    if(number1<=0 || number2<=0)
                    {
                        System.out.println("Δωσε θετικο αριθμο");
                    }
                    else
                    {
                        mcm(number1,number2);
                        break;
                    }
                }
            }
            else if(choice==2)
            {
                System.out.println("Αυτο το προγραμμα δημιουργηθηκε απο τον : Gioani Braouni");
            }
            else if(choice==3)
            {
                System.out.println("Εξοδος προγραμματος");
                break;
            }
            else
            {
                System.out.println("Λανθασμενος αριθμος.Ξαναπροσπαθησε παλι");
            }
        }
        
    }
    public static void mcm(int number1 , int number2)
    {
        int higher,lower,ekp;
        if(number1>number2)
        {
            higher=number1;
            lower=number2;
        }
        else
        {
            higher=number2;
            lower=number1;
        }
        ekp=higher;
        while (ekp % lower != 0) 
        {
            ekp += higher;
        }
        System.out.println("Το ελαχιστο κοινο πολλαπλασιο των αριθμων " + higher + " και " + lower + " ειναι " + ekp);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class Exc1 
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String id [] = new String[]{"123456789","987654321","2112211221","2020202020","1112131415"};
        String name[]=new String[]{"Γιαννης","Μαριος","Πετρος","Κωστας","Αγγελος"};
        Random rand = new Random();
        TollDevice [] toll = new TollDevice[5];
        for(int i = 0; i<5; i++)
        {
            toll[i] =new TollDevice();
            toll[i].setDeviceID(id[i]);
            toll[i].setName(name[i]);
            toll[i].setBalance(0);
        }
        while(true)
        {
            for(int i = 0; i<5; i++)
            {
                System.out.println("Καλησπέρα " + toll[i].getName());
                System.out.println("Αριθμός Συσκευής " + toll[i].getDeviceID());
                System.out.println();
                System.out.println("Θα θέλατε να πιστώσετε λεφτά στην συσκευή σας?");
                System.out.println("Δώσε 1 για 'Ναι' ή 2 για 'Οχι'");
                int k = input.nextInt();
                input.nextLine();
                int bal=toll[i].getBalance();
                if(k==1)
                {
                    System.out.println("Δώσε ποσό");
                    k = input.nextInt();
                    input.nextLine();
                    bal=bal+k;
                    toll[i].setBalance(bal);
                }
                System.out.println();
                if(bal>=5)
                {
                    System.out.println("Το ποσό αφαιρέθηκε επιτυχώς από το λογαριασμό σας , σας ευχόμαστε καλό δρομό");
                    toll[i].setBalance(bal-5);
                    System.out.println();
                }
                else
                {
                    System.out.println("Το ποσό δεν επαρκεί για να πληρωσετε αντιτιμο");
                    System.out.println();
                }
            }
        }
    }
    
}

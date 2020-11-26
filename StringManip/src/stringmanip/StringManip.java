/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanip;

import java.util.Arrays;
import java.util.Scanner;


public class StringManip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //1
        System.out.println("Δώσε πλήθος συμβολοσειρών");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String tmp = input.nextLine();
        String array[] = new String [num];
        System.out.println();
        System.out.println("Δώσε σειμβολοσειρά");
        for(int d =0; d<num; d++ )
        {
            array[d]= input.nextLine();
        }
        
        //2
        String array2[] = new String [num];
        for(int i=0; i<array.length; i++)
        {
            array2[i] = array[i];
        }
        
        //3
        sortStrings(array2);
        
        //4
        System.out.println("Δώσε σειμβολοσειρά για αναζήτηση");
        String str = input.nextLine();
        System.out.println();
        System.out.println("Αναζηήτηση της σειμβολοσειράς " + str + " στο αρχικό πίνακα");
        System.out.println();
        for(int i = 0 ; i<array.length; i++)
        {
            int k=searchStrings(array[i],str);
            if(k==-1)
            {
                System.out.println("Η σειμβολοσειρά " + str + " δεν βρέθηκε στην γραμμή " + i + " του πίνακα " + "array");
            }
            else
            {
                System.out.println("Η σειμβολοσειρά " + str + " βρέθηκε στην γραμμή " + i + " του πίνακα " + "array");
                System.out.println("και βρέθηκε στην θέση της σειμβολοσειράς " + k);
            }
            System.out.println();
            
        }
    }
    public static void sortStrings(String array[]) 
    {
        Arrays.sort(array);
        System.out.println("Τα στοιχεία του πίνακα κατανεμημένα σε άυξουσα σειρά");
        for(String d : array)
        {
            System.out.println(d);
        }
        System.out.println();
    }
    public static int searchStrings(String array,String str) 
    {
        int k;
        k=array.indexOf(str,0);
        if(k==-1)
        {
            return -1;
        }
        else
        {
            return k;
        }
        
    }
}

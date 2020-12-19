package Main;

import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Random rnd = new Random(); 
        
        Scanner input = new Scanner(System.in);
        System.out.println("Δώσε πλήθος στοιχείων του πίνακα");
        
        int total=0;
        while(true)
        {
            try
            {
                total = input.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Λαθος εισοδος , δωσε ακεραιο");
                System.err.println("Not a integer number");
                input.nextLine();
            }
        }
        double array [] = null;
        try
        {
            array = new double [total];
        }
        catch(NegativeArraySizeException e)
        {
            System.err.println("Error: cannot create array with negative size");
            System.exit(1);
        }
        
        for(int i=0; i<total; i++)
        {
            array[i] = rnd.nextInt(100);
        }
        
        int index;
        int counter=0;
        while(counter<5)
        {
            index=0;
            try
            {
                System.out.println("Ποιο στοιχειο του πινακα θες να εκτυπωσεις?");
                index = input.nextInt();
                System.out.println("Array element" + index + ": " + array[index]);
                counter++;

            }
            catch(InputMismatchException e)
            {
                System.out.println("Λαθος εισοδος , δωσε ακεραιο");
                System.err.println("Not a integer number");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.err.println("Array index out of bounds");
            }
            input.nextLine();
        }
        System.out.println("Εxit");
    }
    
}

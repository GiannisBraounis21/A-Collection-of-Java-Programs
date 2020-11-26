/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;
import java.util.Scanner;

public class Exc2 {

    
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        
        System.out.println("Δωσε ονομα μαθητη");
        String name = input.nextLine();
        
        System.out.println("Δωσε αριθμο μητρωου μαθητη");
        int x = input.nextInt();
        input.nextLine();
        
        Student stud = new Student();
        
        stud.setName(name);
        stud.setId(x);
        
        stud.addQuiz(8.5);
        stud.addQuiz(7);
        stud.addQuiz(6.5);
        stud.addQuiz(9);
        
        System.out.println("Ποιο βαθμο της ασκησης θες να δεις?");
        x = input.nextInt();
        System.out.println("O βαθμος της ασκησης " + x + " ειναι: " + stud.getQuiz(x-1));
        
        System.out.println("Το πληθος των ασκησεων ειναι: " + stud.getNumberOfQuizzes());
        
        System.out.println("Αθροισμα των βαθμων: " + stud.getTotalScore());
        
        System.out.println("Μεσος ορος βαθμων: " + stud.getAverageScore());
                
        System.out.println(stud);
    }
    
}

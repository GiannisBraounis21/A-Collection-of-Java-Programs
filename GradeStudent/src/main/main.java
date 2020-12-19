package main;

import java.util.*;

public class main 
{
    public static void main(String[] args) 
    {
        String names [] = {"John" , "Paul" , "George" , "Angela" , "Samantha"};
        ArrayList<Student> stud = new ArrayList<Student>();
        
        Student stud1 = new Student(names[0]);
        Student stud2 = new Student(names[1]);
        Student stud3 = new Student(names[2]);
        Student stud4 = new Student(names[3]);
        Student stud5 = new Student(names[4]);
        
        stud.add(stud1);
        stud.add(stud2);
        stud.add(stud3);
        stud.add(stud4);
        stud.add(stud5);
        
        Scanner input = new Scanner(System.in);
        
        int grd = 0;
        for(Student x : stud)
        {
            while(true)
            {
                try
                {
                    System.out.println("Please enter grade for student:"+x.getName());    
                    grd = input.nextInt();
                    input.nextLine();
                    x.setGrade(grd);
                    break;
                }
                catch(GradeException e )
                {
                    System.err.println(e.getMessage());
                } 
            }
        }
        for(Student x : stud)
        {
            System.out.println(x.toString());
        }
    }
    
}

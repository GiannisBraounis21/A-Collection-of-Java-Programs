/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;

public class Student 
{
    private String name;
    private int grade;
    
    public Student(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setGrade(int grade) throws GradeException
    {
        if(grade>=0 && grade<=100)
        {
            this.grade = grade;
        }
        else
        {
            throw new GradeException("Invalid Grade",grade);
        }
    }
    
      
    @Override
    public String toString()
    {
        return  name + " " + grade;
    }
    
}

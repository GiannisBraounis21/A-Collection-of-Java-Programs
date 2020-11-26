/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author wwwbr
 */
public class Student 
{
    int id;
    double totalScore;
    String name;
    ArrayList<Double> scores = new ArrayList<>();
    
    public Student()
    {
        
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void addQuiz(double grade)
    {
        totalScore+=grade;
        scores.add(grade);
    }
    public double getQuiz(int i)
    {
        return scores.get(i);
    }
    public int getNumberOfQuizzes()
    {
        return scores.size();
    }
    public double getTotalScore()
    {
        return totalScore;
    }
    public double getAverageScore()
    {
        return totalScore/scores.size();
    }
    @Override
    public String toString()
    {
        return "Student information:" + name + " " + id + " " + totalScore + " " + getAverageScore() ;
    }
    
}

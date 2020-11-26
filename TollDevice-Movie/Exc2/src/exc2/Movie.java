/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;

public class Movie 
{
    String Title;
    int Total[] = {0,0,0,0,0};
    
    public Movie()
    {
        
    }
    
    public void setTitle(String title)
    {
        Title=title;
    }
    
    public void addRating(int rating)
    {
        if(rating>5)
        {
            System.out.println("Σφάλμα έδωσες " + rating + " ενώ έπρεπε να δώσεις από 1 εώς 5");
        }
        else
        {
            Total[rating-1]++;
        }
    }
    public int getRatingCount(int i)
    {
        return Total[i];
    }
    
    public double averageRating()
    {
        double k = (Total[0]*1 + Total[1]*2 + Total[2]*3 + Total[3]*4 + Total[4]*5)/(Total[0]+Total[1]+Total[2]+Total[3]+Total[4]);
        return k;
    }
}

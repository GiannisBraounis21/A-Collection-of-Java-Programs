/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc2;

/**
 *
 * @author John
 */
public class Exc2 
{
    public static void main(String[] args)
    {
        Movie joker = new Movie();
        joker.setTitle("Joker");
        
        joker.addRating(5);
        joker.addRating(6); // Δεν λαμβάνεται υπόψιν, επιστρέφει τιμή σφάλματος
        joker.addRating(2);
        joker.addRating(5);
        
        System.out.println("Ratings:");
        for (int i = 0; i < 5; i++) 
        {
            System.out.println(i+1 + ": " + joker.getRatingCount(i));
        }
        System.out.printf("Average rating: %.2f\n", joker.averageRating());
    }
}

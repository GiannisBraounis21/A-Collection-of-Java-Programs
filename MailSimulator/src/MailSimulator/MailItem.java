/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailSimulator;

public class MailItem 
{
    private String from;
    private String to;
    private String message;
    
    public MailItem(String from,String to,String message)
    {
        this.from=from;
        this.to=to;
        this.message=message;
    }
    
    public String getFrom()
    {
        return this.from;
    }
    
    public String getTo()
    {
        return this.to;
    }
    
    public String getMessage()
    {
        return this.message;
    }
    
    public void print()
    {
        System.out.println("From: " + this.from);
        System.out.println("To " + this.to);
        System.out.println("Message: " + this.message);
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
}

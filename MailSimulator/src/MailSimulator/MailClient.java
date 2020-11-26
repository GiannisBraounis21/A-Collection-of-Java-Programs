/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailSimulator;

public class MailClient 
{
    private String user;
    MailServer server;
    
    public MailClient(String user,MailServer server)
    {
        this.user=user;
        this.server=server;
    }
    
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    public void printNextMailItem()
    {
        getNextMailItem().print();
    }
    
    public void sendMailItem(String to , String message)
    {
        MailItem msg = new MailItem(this.user,to,message);
        server.post(msg);
    }
}

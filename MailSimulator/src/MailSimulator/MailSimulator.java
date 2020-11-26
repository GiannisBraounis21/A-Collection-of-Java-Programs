package MailSimulator;

/**
 *
 * @author John
 */
public class MailSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MailServer server = new MailServer();
        
        MailClient cl1 = new MailClient("John",server);
        MailClient cl2 = new MailClient("Paul",server);
        cl1.sendMailItem("Paul", "Hello Paul this is John , how are you?");
        cl2.sendMailItem("John", "Hello John im fine , how is your day through the quarantine?");
        cl1.sendMailItem("Paul", "Business as usual how about you?");
        cl2.sendMailItem("John", "Oh I see ,I've got great news to share with you , im going to be a father!!");
        System.out.println(server.howManyMessages("Paul"));
        System.out.println(server.howManyMessages("Ξοην"));
        System.out.println(server.howManyMessages("John"));
        cl1.printNextMailItem();
        cl2.printNextMailItem();
        cl2.printNextMailItem();
    }
    
}
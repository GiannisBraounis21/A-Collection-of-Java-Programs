package MailSimulator;

import java.util.ArrayList;

public class MailServer 
{
    ArrayList<MailItem> messages = new ArrayList<>();
    
    public MailServer()
    {
        
    }
    
    public void post(MailItem message)
    {
        messages.add(message);
        
    }
    
    public int howManyMessages(String who)
    {
        int k=0;
        for(MailItem x : messages) 
        {
            if((x.getTo()).equals(who))
            {
                k++;
            }
        }
        return k;
    }
    
    public MailItem getNextMailItem(String who)
    {
        int k=0;
        if(messages != null && !messages.isEmpty())
        {
            for(MailItem x : messages) 
            {
                k++;
                if((x.getTo()).equals(who))
                {
                    break;
                }
            }
            return messages.remove(k);
        }
        return null;
    }
}

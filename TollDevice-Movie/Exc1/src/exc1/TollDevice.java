/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc1;


/**
 *
 * @author John
 */
public class TollDevice 
{
    String DeviceID;
    int Balance ;
    String Name;
    
    public TollDevice()
    {
        
    }
    
    public void setDeviceID(String id)
    {
        DeviceID = id;
    }
    
    public void setBalance(int m)
    {
        Balance = m;
    }
    public void setName(String nm)
    {
        Name = nm;
    }
    
    public String getDeviceID()
    {
        return DeviceID; 
    }
    
    public int getBalance()
    {
        return Balance;
    }
    public String getName()
    {
        return Name;
    }
    
}    
    

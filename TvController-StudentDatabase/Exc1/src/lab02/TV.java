/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

public class TV 
{
    boolean tv ;
    int channel;
    int volume;
    int volError=0;
    
    public TV()
    {
        tv=false;
        channel=0;
        volume=0;
    }
    public void setTVDefaultSettings()
    {
        channel=30;
        volume=10;
    }
    public void turnTvOnOff(boolean tv)
    {
        this.tv=tv;
    }
    public boolean is0n()
    {
        return tv;
    }
    public void channel(String x)
    {
        if(tv==true)
        {
            if(x.equals("+ch"))
            {
            
                if(channel==100)
                {
                    channel=0;
                }
                channel++;
            }
            else if(x.equals("-ch"))
            {
                if(channel==1)
                {
                    channel=101;
                }
                channel--;
            }
        }
    }
    public void volume(String x)
    {
        if(tv==true)
        {
            if(x.equals("+vol"))
            {
            
                if(volume<50)
                {
                    volume++;
                    volError=0;
                }
                else
                {
                    volError=1;
                }
            }
            else if(x.equals("-vol"))
            {
                if(volume>0)
                {
                   volume--;
                   volError=0;
                }
                else if(volume<0)
                {
                    volError=1;
                }
            }
        }
    }
    public int getChannel()
    {
        return channel;
    }
    public int getVolume()
    {
        if(volError==1)
        {
            return 0;
        }
        return volume;
    }
}

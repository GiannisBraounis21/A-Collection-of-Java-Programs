package courierservice;

public class Package 
{
    private int weight;
    private String id;
    
    public Package(int weight , String id)
    {
        this.weight = weight;
        this.id = id;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public String getId()
    {
        return id;
    }
    
    public int computeCost()
    {
        int cost;
        if(weight<=3)
        {
           cost = 3;
        }
        else
        {
            cost = 3+ 3 * weight;
        }
        return cost;
    }
    
    
    
    @Override
    public String toString()
    {
        
        return "Id : " + id + " " + "Weight : " + weight + " " + "Cost : " + computeCost();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courierservice;

/**
 *
 * @author John
 */
public class InsuredPackage extends Package
{
    private int insurance_cost;
    
    public InsuredPackage(int weight , String id)
    {
        super(weight,id);
    }
    
    @Override
    public int computeCost()
    {
        int cost = super.computeCost();
        if(cost<=5)
        {
            insurance_cost=2;
        }
        else if(cost<=10)
        {
            insurance_cost=3;
        }
        else
        {
            insurance_cost=5;
        }
        cost+=insurance_cost;
        return cost;
    }
    
}

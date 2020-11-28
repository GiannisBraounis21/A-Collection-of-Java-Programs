
package courierservice;

import java.util.Scanner;
import java.util.ArrayList;

public class CourierService 
{
    public static void main(String[] args) 
    {
        
        ArrayList<Package> totalPackages = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        int x;
        do
        {
            System.out.println("1. Simple package");
            System.out.println("2. Insured package");
            System.out.println("3. Exit");
        
            System.out.print("Please enter a number: ");
            x = input.nextInt();
            input.nextLine();
            
            if(x==1)
            {
                int weight;
                System.out.print("Enter package id: ");
                String id = input.nextLine();
                System.out.print("Enter weight: ");
                weight = input.nextInt();
                Package pkg = new Package(weight,id);
                if(totalPackages.isEmpty())
                {
                    totalPackages.add(pkg);
                }
                else
                {
                    boolean found = false;
                    for(Package p : totalPackages)
                    {
                        if(p.getId().equals(id))
                        {
                            found = true;
                            System.out.println("Package with id: " + id + " is already in our system");
                        }
                    }
                    if(found==false)
                    {
                        totalPackages.add(pkg);
                    }
       
                }
            }
            if(x==2)
            {
                int weight;
                System.out.print("Enter package id: ");
                String id = input.nextLine();
                System.out.print("Enter weight: ");
                weight = input.nextInt();
                InsuredPackage pkg = new InsuredPackage(weight,id);
                Package pkgs = pkg;
                if(totalPackages.isEmpty())
                {
                    totalPackages.add(pkgs);
                }
                else
                {
                    boolean found = false;
                    for(Package p : totalPackages)
                    {
                        if(p.getId().equals(id))
                        {
                            found = true;
                            System.out.println("Package with id: " + id + " is already in our system");
                        }
                    }
                    if(found==false)
                    {
                        totalPackages.add(pkgs);
                    }
                }
            }
            else if(x==3)
            {
                for(Package p : totalPackages)
                {
                    if(p.getClass()==Package.class)
                    {
                        System.out.println("Package -> " + p.toString());
                    }
                    else
                    {
                        System.out.println("InsuredPackage -> " + p.toString());
                    }
                }
            }
        }while(x!=3);
    }
    
}

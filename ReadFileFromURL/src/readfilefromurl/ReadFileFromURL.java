package readfilefromurl;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ReadFileFromURL 
{
    public static void main(String[] args) 
    {
        System.out.println("Please give URL:");
        Scanner input = new Scanner(System.in);
        
        String urlInput = input.nextLine();
        
        try
        {
            URL url = new URL(urlInput);
            Scanner inp = new Scanner(url.openStream());
            
            PrintWriter urlOutput = new PrintWriter("Output.txt");
            
            while(inp.hasNext())
            {
                urlOutput.println(inp.nextLine()+" ");
            }
        }
        catch(MalformedURLException e )
        {
            System.err.println("URL is invalid");
        }
        catch(IOException io)
        {
            System.err.println("I/O Error : no such file");
        }
    }
    
}

package main;

public class utilsSlots 
{
    public int validateTextConvertInt(String text)
    {
        try 
        {
            //TODO add/fix check for null custom bet
            int convertedInt = Integer.parseInt(text);
            return convertedInt;
        }catch(Exception e)
        {   
            System.out.println("Naught String Detected in custom bet slot.");
            return 0;
        }

    }    
}

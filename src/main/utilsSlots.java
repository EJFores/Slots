package main;

public class utilsSlots 
{
    public int validateTextConvertInt(String text)
    {
        if (text.isEmpty())
            return 0;
        else{
            try 
            {
                int convertedInt = Integer.parseInt(text);
                return convertedInt;
            }catch(Exception e)
            {   
                System.out.println("Naught String Detected in custom bet slot.");
                return 0;
            }
        }

    }    
}

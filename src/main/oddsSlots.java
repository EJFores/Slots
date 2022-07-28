package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class oddsSlots 
{
    int slotOptionCount = 3;

    public int betCollectandReturn(int userAddBet, int bet)
    {
        return (userAddBet+bet);
    }    
    
    public int calcOdds()
    {
        return ((int)(Math.random()*slotOptionCount+1));
    }

    public List<Integer> slotOdds()
    {
        List<Integer> oddsList = new ArrayList<Integer>();

        for (int i=0;i>slotOptionCount;i++)
        {
            oddsList.add(i,calcOdds());
        }

        return oddsList;
    }

    public boolean luckySlotOdds(List<Integer> s)
    {
        boolean allEqual = s.isEmpty() || Collections.frequency(s, s.get(0)) == s.size();
        return allEqual;
    }
}

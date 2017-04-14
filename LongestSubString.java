import java.util.ArrayList;

public class LongestSubString 
{
    public int lengthOfLongestSubstring(String s) 
    {
        if (s.length() == 1)
            return 1;
        String result = "";
        String temp = "";
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (result.length() == 0)
                result = Character.toString(s.charAt(i));
            else 
            {
                if(!result.contains(Character.toString(s.charAt(i))))
                    result += Character.toString(s.charAt(i));
                else if (result.contains(Character.toString(s.charAt(i))))
                {
                    result += Character.toString(s.charAt(i));
                    result = result.substring(result.indexOf(Character.toString(s.charAt(i)))+1);    
                }
                list.add(result.length());
            }
        }
        
        if(!list.isEmpty())
        {
            int min = list.get(0);
            int max = list.get(0);
        
            for(Integer i: list) 
            {    
                if(i < min) 
                    min = i;
                if(i > max) 
                    max = i;
            }
            return max;
        }
        
        return 0;
    }
}
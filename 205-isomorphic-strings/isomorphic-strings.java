class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        int l1=s.length();
        int l2=t.length();
        if(l1==l2)
        {
            HashMap<Character,Character> map1 = new HashMap<Character,Character>();
            HashMap<Character,Character> map2 = new HashMap<Character,Character>();
            for(int i=0;i<l1;i++)
            {
                char c1=s.charAt(i);
                char c2=t.charAt(i);
                if(map1.containsKey(c1))
                {
                    if(map1.get(c1)!=c2) 
                        return false;
                }
                else
                    map1.put(c1,c2); 

                if(map2.containsKey(c2)) 
                {
                    if(map2.get(c2)!=c1)
                        return false;
                }
                else
                    map2.put(c2,c1); 
            }
            return true;
        }
        return false;
    }
}
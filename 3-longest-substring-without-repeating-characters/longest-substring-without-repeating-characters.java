class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashMap<Character,Integer>mp= new HashMap<>();
        int count=0,maxcount=0;
        int j=0;
            while(j<s.length())
            {
                if(mp.containsKey(s.charAt(j))){
                j=mp.get(s.charAt(j))+1;
                mp.clear();
                count=0;
                }
                else
                {
                    mp.put(s.charAt(j),j);
                    count++;
                    j++;
                }
            if(maxcount<count)
            {
                maxcount=count;
            }
            }
            return maxcount;
        }
    }
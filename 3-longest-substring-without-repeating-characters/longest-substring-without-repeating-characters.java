class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0 ;
        int j=0 ;
        int max= 0;
        HashSet<Character> set = new HashSet<>();
        while(i<s.length()&& j<s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max,j-i);

        }
        return max;
    }
}
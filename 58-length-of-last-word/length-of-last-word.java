class Solution {
    public int lengthOfLastWord(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        s = s.trim();
        int n = s.length();
        int count =0;
        for(int i=n-1; i>=0; i--){
            if(!map.containsKey(' ')){
                map.put(s.charAt(i), count++);
            }else{
                return count-1;
            }
        }

        return count;
    }
}
class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        int n = word.length();
        for(int i = 0;i<n;i++){
            char ch = word.charAt(i);
            int j = i+1;
            while(j<n && word.charAt(j)==ch){
                j++;
            }
            res+=(j-i-1);
            i = j-1;
        }
        return res;
    }
}
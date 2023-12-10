class Solution {
    public boolean isPalindrome(String s) {
        int low = 0 , high = s.length()-1;
        while(low<high){
           char l = s.charAt(low) , h = s.charAt(high);
           if(!Character.isLetterOrDigit(l)) low++;
           else if(!Character.isLetterOrDigit(h)) high--;
           else {
               if(Character.toLowerCase(l)!=Character.toLowerCase(h)) return false;
               low++; high--;
           }  
        }
        return true;
    }
}
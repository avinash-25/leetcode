class Solution {
    public boolean isPalindrome(String s) {
      StringBuilder cleandString = new StringBuilder();
      for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleandString.append(Character.toLowerCase(c));
            }
        }
      int j = cleandString.length()-1;
      for(int i=0;i<cleandString.length();i++){
           if(cleandString.charAt(i) != cleandString.charAt(j))
             return false;
            j--;
        }
      return true;      
    }
}
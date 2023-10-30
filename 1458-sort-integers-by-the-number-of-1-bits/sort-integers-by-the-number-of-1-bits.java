import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] arrInteger = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInteger[i] = arr[i];
        }

        Arrays.sort(arrInteger, (a, b) -> {
            int countA = Integer.bitCount(a); 
            int countB = Integer.bitCount(b); 
            
            if (countA != countB) {
                return countA - countB;
            } else {
                return a - b;
            }
        });

      
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrInteger[i];
        }
        
        return arr;
    }
}

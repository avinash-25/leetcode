class Solution {
    public int findSpecialInteger(int[] arr) {
        int res = (int)(arr.length * 0.25);
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1])
              count++;
            else
              count = 0;
            if(count >= res)
              return arr[i];
        }
        return 1;
    }
}
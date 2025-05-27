class Solution {
    public int differenceOfSums(int n, int m) {
        int divSum = 0;
        int notDivSum = 0;

        for(int i=1; i<=n; i++){
            if(i%m == 0)
                divSum += i;
            else
                notDivSum += i;
        }

        return notDivSum - divSum;
    
    }
}
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false; 
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}


// class Solution {
//     public boolean isPowerOfFour(int n) {       
//         if(n == 1 || n == 4)
//           return true;
//         int k=2,sq=1;
//         if(n %4 == 0){
//       while(k != 0 ){
//           sq = sq*4;
//           if(sq == n)
//            return true;
//           if(sq>n)
//            break;
//       }
//     }

//       return false;    
//     }
// }
// class Solution {
//     public int minOperations(String s) {
        
//        int count=0;
//        if(s.charAt(0) == '0'){
//        for(int i=0;i<s.length();i++){
//            if(i%2 == 0){
//                if(s.charAt(i) != '0')
//                  count++;
//            }else{
//                if(s.charAt(i) != '1')
//                  count++;
//            }
//        }
//        }else{
//         for(int i=0;i<s.length();i++){
//            if(i%2 == 0){
//                if(s.charAt(i) != '1')
//                  count++;
//            }else{
//                if(s.charAt(i) != '0')
//                  count++;
//            }
//        }
//     }
//     return count; 
//   }
// }

class Solution {
    public int minOperations(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != (i % 2 == 0 ? '0' : '1')) {
                count++;
            }
        }
        return Math.min(count, s.length() - count);
    }
}

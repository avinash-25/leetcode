class Solution {

    Map<String,Integer> map = new HashMap<>();
    public int getLengthOfOptimalCompression(String s, int k) {
        return getLengthOfOptimalCompression(s.toCharArray(), k, 0, ' ', 0);
    }

    public int getLengthOfOptimalCompression(char[] chArray, int k, int prevCount, char prevChar, int i) {
        
        String key = k + "," + prevCount + "," + prevChar + "," + i;
        if(map.containsKey(key)){
            return map.get(key);
        }

        if(k < 0){
            return Integer.MAX_VALUE;
        }

        if(i == chArray.length){
            return 0;
        }
        int res;
        if(chArray[i] == prevChar){
            int incr = (prevCount == 1 || prevCount == 9 || prevCount == 99) ? 1 : 0;
            res = incr + getLengthOfOptimalCompression(chArray, k, prevCount + 1, prevChar, i + 1);
        }else{
            res = Math.min(
                getLengthOfOptimalCompression(chArray, k - 1, prevCount, prevChar, i + 1), 

                1 + getLengthOfOptimalCompression(chArray, k, 1, chArray[i], i + 1)  
            );
        }

        map.put(key, res);

        return res;


    }
}
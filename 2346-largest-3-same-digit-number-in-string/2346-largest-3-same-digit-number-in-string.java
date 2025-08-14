class Solution {
    public String largestGoodInteger(String num) {
        int[] value = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            value[i] = Character.getNumericValue(num.charAt(i));
        }

        int goodInteger = -1;
        int temp = 0;

        for(int i=0; i < value.length-2; i++){
            if((value[i] == value[i+1]) & (value[i+1] == value[i+2])){
                temp = value[i] * 100 +  value[i] * 10 +  value[i];
                i += 2;

                if(temp >= goodInteger)
                  goodInteger = temp;
            }
             
        }
        
        if (goodInteger == -1) {
            return ""; 
        } else if (goodInteger == 0) {
            return "000";
        } else {
            return String.valueOf(goodInteger);
        }
    }
}
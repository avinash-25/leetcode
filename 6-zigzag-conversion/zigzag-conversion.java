class Solution {
public String convert(String s, int numRows) {
         if (numRows == 1) {
            return s;
        }

        String[] arr = new String[numRows];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        
        int count = 0;
        boolean flag = true;
		
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                arr[count++] += s.charAt(i);
                if (count == numRows - 1)
                    flag = false;
            } else {
                arr[count--] += s.charAt(i);
                if (count == 0)
                    flag = true;
            }
        }

        String string = "";
        for (String temp : arr) {
            string += temp;
        }
        return string;
    }
}
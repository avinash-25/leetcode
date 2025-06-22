class Solution 
{
    public String[] divideString(String s, int k, char fill) 
    {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i += k)
        {
            StringBuilder sb = new StringBuilder();

            int j = 0;
            while(j < k && j + i < s.length())
            {
                sb.append(s.charAt(j + i));
                j++;
            }

            while(sb.length() < k)
            {
                sb.append(fill);
            }

            list.add(sb.toString());
        }

        return list.toArray(new String[0]);
    }
}
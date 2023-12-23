class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> visit = new HashSet<>();
        visit.add("0,0");
        int x=0,y=0;
        for(int i=0;i<path.length();i++)
        {
            if(path.charAt(i)=='N')
            {
                y++;
            }
            else if(path.charAt(i)=='S')
            {
                y--;
            }
            else if(path.charAt(i)=='E')
            {
                x++;
            }
            else
            {
                x--;
            }
            String current = x + ","+y;
            if (visit.contains(current))
            {
                return true;
            }
            visit.add(current);
        }
        return false;
        
    }
}
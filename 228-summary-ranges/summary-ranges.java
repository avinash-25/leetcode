class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        int count =0;
        StringBuffer temp = new StringBuffer();

        for(int i = 0 ; i < nums.length; ++i){
            
           if(count == 0)temp.append(Integer.toString(nums[i]));
            count++;
            if(i<nums.length-1 && nums[i]+1 != nums[i+1] && count <= 1){
                ans.add(temp.toString());
                count=0;
                temp.delete(0, temp.length());
            }
            else if(i<nums.length-1 && nums[i]+1 != nums[i+1] && count >1){
            temp.append("->");
            temp.append(Integer.toString(nums[i]));
            ans.add(temp.toString());
            count=0;
            temp.delete(0, temp.length());
            continue;
            }
            if(i==nums.length-1 && count == 1)ans.add(temp.toString());
            else if(i==nums.length-1 && count > 1){
            temp.append("->");
            temp.append(Integer.toString(nums[i]));
            ans.add(temp.toString());
            }
        }
        return ans;
    }
}
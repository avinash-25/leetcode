class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < n; i ++){
            int currentNumber = nums[i];

            int difference = target - currentNumber;
            if (numsMap.containsKey(difference)){     
                return new int[]{numsMap.get(difference), i};
            }

            numsMap.put(currentNumber, i);            
        }

        return new int[0];
    }
}
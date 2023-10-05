class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Reset counts for the candidates
        count1 = 0;
        count2 = 0;

        // Count the occurrences of the candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if candidates appear more than ⌊ n/3 ⌋ times
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}

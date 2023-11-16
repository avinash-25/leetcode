class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet<>();

        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        for (int i = 0; i < Math.pow(2, n); ++i) {
            if (!integers.contains(i)) {
                return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            }
        }

        return "";
    }
}
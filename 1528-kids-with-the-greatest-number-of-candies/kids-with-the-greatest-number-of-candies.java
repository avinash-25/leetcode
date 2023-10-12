class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = findMaxCandies(candies);

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= maxCandies);
        }

        return result;
    }

    private int findMaxCandies(int[] candies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}

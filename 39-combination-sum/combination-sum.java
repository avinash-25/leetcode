import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return;
        } else if (remaining == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                // Recursively try the next candidate, but don't start from the current candidate to avoid duplicates.
                backtrack(result, currentList, candidates, remaining - candidates[i], i);
                // Remove the last added element to backtrack and explore other possibilities.
                currentList.remove(currentList.size() - 1);
            }
        }
    }

}
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] candidates = {2, 3, 6, 7};
//         int target = 7;
//         List<List<Integer>> combinations = solution.combinationSum(candidates, target);
//         System.out.println(combinations);
//     }
// }

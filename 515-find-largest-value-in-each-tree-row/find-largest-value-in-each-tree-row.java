import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxLevelValue = Integer.MIN_VALUE; 
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxLevelValue = Math.max(maxLevelValue, node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            result.add(maxLevelValue);
        }
        
        return result;
    }
}

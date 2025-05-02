import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Maps to store min and max coordinates
        Map<Integer, Integer> yToMinX = new HashMap<>();
        Map<Integer, Integer> yToMaxX = new HashMap<>();
        Map<Integer, Integer> xToMinY = new HashMap<>();
        Map<Integer, Integer> xToMaxY = new HashMap<>();
        
        // Preprocess buildings to find min/max x for each y and min/max y for each x
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            
            // Update min/max x for this y
            yToMinX.put(y, Math.min(yToMinX.getOrDefault(y, Integer.MAX_VALUE), x));
            yToMaxX.put(y, Math.max(yToMaxX.getOrDefault(y, Integer.MIN_VALUE), x));
            
            // Update min/max y for this x
            xToMinY.put(x, Math.min(xToMinY.getOrDefault(x, Integer.MAX_VALUE), y));
            xToMaxY.put(x, Math.max(xToMaxY.getOrDefault(x, Integer.MIN_VALUE), y));
        }
        
        int count = 0;
        
        // Check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            
            // Check four directions
            boolean hasAbove = yToMinX.getOrDefault(y, Integer.MAX_VALUE) < x; // Smaller x for same y
            boolean hasBelow = yToMaxX.getOrDefault(y, Integer.MIN_VALUE) > x; // Larger x for same y
            boolean hasLeft = xToMinY.getOrDefault(x, Integer.MAX_VALUE) < y;  // Smaller y for same x
            boolean hasRight = xToMaxY.getOrDefault(x, Integer.MIN_VALUE) > y; // Larger y for same x
            
            // If all directions have a building, increment count
            if (hasAbove && hasBelow && hasLeft && hasRight) {
                count++;
            }
        }
        
        return count;
    }
}
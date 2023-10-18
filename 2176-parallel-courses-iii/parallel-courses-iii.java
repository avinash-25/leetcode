class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[n];
        int[] earliestCompletion = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prevCourse = relation[0] - 1;
            int nextCourse = relation[1] - 1;
            graph.get(prevCourse).add(nextCourse);
            inDegrees[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                earliestCompletion[i] = 0;
            }
        }

        int minCompletionTime = 0;
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            minCompletionTime = Math.max(minCompletionTime, earliestCompletion[currentCourse] + time[currentCourse]);

            for (int nextCourse : graph.get(currentCourse)) {
                inDegrees[nextCourse]--;
                earliestCompletion[nextCourse] = Math.max(earliestCompletion[nextCourse], earliestCompletion[currentCourse] + time[currentCourse]);
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return minCompletionTime;
    }
}

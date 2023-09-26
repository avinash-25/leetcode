import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] lastIndex = new int[26]; // To store the last occurrence index of each character.

        // Populate the lastIndex array with the last occurrence index of each character in the string.
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26]; // To keep track of whether a character is in the stack.

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the current character is already in the stack, skip it.
            if (visited[currentChar - 'a']) {
                continue;
            }

            // While there are characters in the stack, and the current character is smaller
            // than the character at the top of the stack, and there are more occurrences of
            // the character at the top of the stack later in the string, pop the stack.
            while (!stack.isEmpty()
                   && currentChar < stack.peek()
                   && i < lastIndex[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            // Push the current character onto the stack and mark it as visited.
            stack.push(currentChar);
            visited[currentChar - 'a'] = true;
        }

        // Build the result string from the characters in the stack.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
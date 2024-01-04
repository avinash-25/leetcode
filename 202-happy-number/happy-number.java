class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    int sum(int n) {
        int sum = 0, rem;
        while (n > 0) {
            rem = n % 10;
            sum += rem * rem;
            n = n / 10;
        }
        return sum;
    }
}
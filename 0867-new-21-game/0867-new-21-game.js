/**
 * @param {number} n
 * @param {number} k
 * @param {number} maxPts
 * @return {number}
 */
var new21Game = function(n, k, maxPts) {
  if (k === 0 || n >= k + maxPts - 1) return 1.0;

  const dp = new Array(n + 1).fill(0);
  dp[0] = 1.0;
  let window = 1.0, ans = 0.0;

  for (let i = 1; i <= n; i++) {
    dp[i] = window / maxPts;
    if (i < k) window += dp[i];
    else ans += dp[i];
    if (i - maxPts >= 0) window -= dp[i - maxPts];
  }
  return ans;
};
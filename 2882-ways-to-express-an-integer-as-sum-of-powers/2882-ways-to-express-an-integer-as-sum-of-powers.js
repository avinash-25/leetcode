var numberOfWays = function(n, x) {
    if (n===1) return 1;
    const MOD = 1e9 + 7;
    let arr = []
    for (let i=1; ; i++) {
        let power = Math.pow(i, x);
        if (power > n) break;
        arr.push(Math.pow(i, x))
    }
    let dp = new Array(n+1).fill(0);
    dp[0] = 1;

    for (let num of arr) {
        for (let j=n; j>=num; j--) {
            dp[j] = (dp[j]+dp[j-num])%MOD;
        }
    }
    return dp[n]
};
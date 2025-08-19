/**
 * @param {number[]} nums
 * @return {number}
 */
var zeroFilledSubarray = function(nums) {
    let cnt = 0, streak = 0;
    for (let num of nums) {
        if (num === 0) streak++;
        else streak = 0;
        cnt += streak;
    }
    return cnt;
};
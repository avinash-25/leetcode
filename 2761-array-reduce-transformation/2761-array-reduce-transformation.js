var reduce = function(nums, fn, init) {
    let val = init; // Start with the initial value
    
    for (let i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]); // Apply the reducer function
    }
    
    return val; // Return the final accumulated value
};

// Example usage:
// const nums1 = [1, 2, 3, 4];
// const fn1 = (accum, curr) => accum + curr;
// console.log(reduce(nums1, fn1, 0)); // Output: 10

// const nums2 = [1, 2, 3, 4];
// const fn2 = (accum, curr) => accum + curr * curr;
// console.log(reduce(nums2, fn2, 100)); // Output: 130

// const nums3 = [];
// const fn3 = (accum, curr) => 0;
// console.log(reduce(nums3, fn3, 25)); // Output: 25

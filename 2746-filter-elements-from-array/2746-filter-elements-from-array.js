/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let filteredArr = [];
    
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) { // Apply function to check condition
            filteredArr.push(arr[i]); // If true, add to filtered array
        }
    }
    
    return filteredArr;
};

// // Example 1:
// console.log(filter([0,10,20,30], function greaterThan10(n) { return n > 10; })); 
// // Output: [20,30]

// // Example 2:
// console.log(filter([1,2,3], function firstIndex(n, i) { return i === 0; })); 
// // Output: [1]

// // Example 3:
// console.log(filter([-2,-1,0,1,2], function plusOne(n) { return n + 1; })); 
// // Output: [-2, 0, 1, 2]

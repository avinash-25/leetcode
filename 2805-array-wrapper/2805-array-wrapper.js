class ArrayWrapper {
    constructor(nums) {
        // Store the input array
        this.nums = nums;
    }

    // Override the valueOf method to handle addition
    valueOf() {
        // Calculate the sum of the array elements
        return this.nums.reduce((sum, num) => sum + num, 0);
    }

    // Override the toString method for string representation
    toString() {
        // Return the string representation of the array
        return `[${this.nums.join(',')}]`;
    }
}

// Example usage:
const obj1 = new ArrayWrapper([1, 2]);
const obj2 = new ArrayWrapper([3, 4]);
console.log(obj1 + obj2); 

const obj3 = new ArrayWrapper([23, 98, 42, 70]);
console.log(String(obj3)); 

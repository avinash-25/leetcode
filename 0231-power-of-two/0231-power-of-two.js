/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
  return n > 0 && Math.log2(n) % 1 === 0;
};
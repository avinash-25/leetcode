/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const result = [];

    const flatten = (currentArray, currentDepth) => {
        for (let item of currentArray) {
            if (Array.isArray(item) && currentDepth < n) {
                flatten(item, currentDepth + 1);
            } else {
                result.push(item);
            }
        }
    };

    flatten(arr, 0);
    return result;
};

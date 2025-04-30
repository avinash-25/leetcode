/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const grouped = {};

    for (const item of this) {
        const key = fn(item);  // key should be a string as per problem description
        if (!grouped[key]) {
            grouped[key] = [];
        }
        grouped[key].push(item);
    }

    return grouped;
};


/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    // Helper function to determine if a value is falsy
    const isFalsy = (value) => {
        return value === null || value === false || value === 0 || value === '' || Number.isNaN(value);
    };

    const compact = (item) => {
        if (Array.isArray(item)) {
            return item.map(compact).filter(value => !isFalsy(value));
        } else if (typeof item === 'object' && item !== null) {
            // Compact the object
            return Object.entries(item).reduce((acc, [key, value]) => {
                const compactedValue = compact(value);
                if (!isFalsy(compactedValue)) {
                    acc[key] = compactedValue;
                }
                return acc;
            }, {});
        }
        return item; // Return the value if it's neither an object nor an array
    };

    return compact(obj);
};

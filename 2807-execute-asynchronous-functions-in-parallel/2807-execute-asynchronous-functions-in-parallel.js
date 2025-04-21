/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const results = [];
        let resolvedCount = 0;
        const n = functions.length;

        functions.forEach((fn, i) => {
            try {
                fn().then((val) => {
                    results[i] = val;
                    resolvedCount++;
                    if (resolvedCount === n) {
                        resolve(results);
                    }
                }).catch((err) => {
                    reject(err);
                });
            } catch (err) {
                reject(err); // in case fn() throws synchronously
            }
        });
    });
};

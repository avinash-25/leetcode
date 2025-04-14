var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    let exists = false;
    
    // Check if key exists and is not expired
    if (this.cache.has(key)) {
        const { expiration } = this.cache.get(key);
        if (now < expiration) {
            exists = true;
        }
    }
    
    // Set new value and expiration time
    this.cache.set(key, {
        value: value,
        expiration: now + duration
    });
    
    return exists;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const now = Date.now();
    
    if (this.cache.has(key)) {
        const { value, expiration } = this.cache.get(key);
        if (now < expiration) {
            return value;
        }
        // Clean up expired key
        this.cache.delete(key);
    }
    
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let count = 0;
    
    // Iterate through cache to count non-expired keys
    for (const [key, { expiration }] of this.cache) {
        if (now < expiration) {
            count++;
        } else {
            // Clean up expired key
            this.cache.delete(key);
        }
    }
    
    return count;
};
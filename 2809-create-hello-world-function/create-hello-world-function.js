/**
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {
        return "Hello World";
    };
};

/**
 * Example Usage:
 */
const f = createHelloWorld();
console.log(f());            
console.log(f({}, null, 42));

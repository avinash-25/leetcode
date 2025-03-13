/**
 * @return {Function}
 */
var createHelloWorld = () => () => "Hello World";

/**
 * Example Usage:
 */
const f = createHelloWorld();
console.log(f());            // Output: "Hello World"
console.log(f({}, null, 42)); // Output: "Hello World"

class Calculator {
    /**
     * @param {number} value - Initial value for the calculator
     */
    constructor(value) {
        this.result = value; // Set the initial result
    }
    
    /**
     * Adds a value to the current result
     * @param {number} value - The value to add
     * @return {Calculator} - The updated Calculator instance
     */
    add(value) {
        this.result += value; // Update the result
        return this; // Return the instance for chaining
    }

    /**
     * Subtracts a value from the current result
     * @param {number} value - The value to subtract
     * @return {Calculator} - The updated Calculator instance
     */
    subtract(value) {
        this.result -= value; // Update the result
        return this; // Return the instance for chaining
    }

    /**
     * Multiplies the current result by a value
     * @param {number} value - The value to multiply by
     * @return {Calculator} - The updated Calculator instance
     */
    multiply(value) {
        this.result *= value; // Update the result
        return this; // Return the instance for chaining
    }

    /**
     * Divides the current result by a value
     * @param {number} value - The value to divide by
     * @return {Calculator} - The updated Calculator instance
     * @throws Will throw an error if dividing by zero
     */
    divide(value) {
        if (value === 0) {
            throw new Error("Division by zero is not allowed");
        }
        this.result /= value; // Update the result
        return this; // Return the instance for chaining
    }

    /**
     * Raises the current result to the power of a value
     * @param {number} value - The exponent
     * @return {Calculator} - The updated Calculator instance
     */
    power(value) {
        this.result = Math.pow(this.result, value); // Update the result
        return this; // Return the instance for chaining
    }

    /**
     * Returns the current result
     * @return {number} - The current result
     */
    getResult() {
        return this.result; // Return the result
    }
}

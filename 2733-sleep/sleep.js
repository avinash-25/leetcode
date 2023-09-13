/**
 * @param {number} millis
 * @returns {Promise<void>}
 */
function sleep(millis) {
    return new Promise((resolve) => {
        setTimeout(resolve, millis);
    });
}

let t = Date.now();
sleep(100).then(() => console.log(Date.now() - t)); // This will print approximately 100

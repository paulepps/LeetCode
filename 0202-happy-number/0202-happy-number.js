/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    const seen = new Set();

    while (true) {
        let num = 0;
        while (n !== 0) {
            const digit = n % 10;
            num += digit * digit;
            n = Math.floor(n / 10);
        }
        n = num;

        if (n === 1) {
            return true;
        }
        if (seen.has(n)) {
            return false;
        }
        seen.add(n);
    }
}


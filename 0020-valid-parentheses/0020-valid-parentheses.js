/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const pairs = {
        ')': '(',
        '}': '{',
        ']': '[',
    };

    const opening = new Set(Object.values(pairs));
    const stack = [];

    for (const c of s) {
        if (opening.has(c)) {
            stack.push(c);
        } else if (c in pairs) {
            if (stack.length === 0 || stack.pop() !== pairs[c]) {
                return false;
            }
        } else {
            // Optional: handle unexpected characters
            return false;
        }
    }

    return stack.length === 0;
}

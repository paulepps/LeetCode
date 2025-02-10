function isValid(s: string): boolean {
    let stack: string[] = [];

    for (let i: number = 0; i < s.length; i++) {
        const c: string = s[i];
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.length == 0 || !match(stack.pop(), c)) {
                return false;
            }
        }
    }
    return stack.length == 0;


};

function match(left: string, right: string): boolean {
    return (left == '(' && right == ')') ||
            (left == '{' && right == '}') ||
            (left == '[' && right == ']');
}

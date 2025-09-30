function decodeString(s: string): string {
    const countStack: number[] = [];
    const resultStack: string[] = [];
    let currentString: string[] = [];
    let k = 0;

    for (const ch of s) {
        if (/\d/.test(ch)) {
            k = k * 10 + parseInt(ch, 10);
        } else if (ch === '[') {
            countStack.push(k);
            resultStack.push(currentString.join(''));
            k = 0;
            currentString = [];
        } else if (ch === ']') {
            const repeatTimes = countStack.pop()!;
            const prevString = resultStack.pop()!;
            currentString = [(prevString + currentString.join('').repeat(repeatTimes))];
        } else {
            currentString.push(ch);
        }
    }

    return currentString.join('');
}

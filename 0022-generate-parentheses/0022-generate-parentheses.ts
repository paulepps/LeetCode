function generateParenthesis(n: number): string[] {
    const result: string[] = [];

    function backtrack(openCount: number, closeCount: number, currentString: string): void {
        if (openCount === n && closeCount === n) {
            result.push(currentString);
            return;
        }

        if (openCount < n) {
            backtrack(openCount + 1, closeCount, currentString + "(");
        }

        if (closeCount < openCount) {
            backtrack(openCount, closeCount + 1, currentString + ")");
        }
    }

    backtrack(0, 0, "");

    return result;   
};
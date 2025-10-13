function titleToNumber(columnTitle: string): number {
    let decimalValue = 0;
    let power = 0; // Represents 26^0, 26^1, 26^2, etc.

    // Iterate from the rightmost character (least significant digit)
    for (let i = columnTitle.length - 1; i >= 0; i--) {
        const digitChar = columnTitle[i];

        // Convert character to its numerical value (A=1, B=2, ..., Z=26)
        const digitValue = digitChar.charCodeAt(0) - 'A'.charCodeAt(0) + 1;

        // Add (digitValue * 26^power) to the decimal value
        decimalValue += digitValue * Math.pow(26, power);

        power++; // Increment power for the next digit
    }

    return decimalValue;
}

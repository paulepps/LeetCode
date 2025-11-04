function findComplement(num: number): number {
    // Create a mask with the same length as num's binary representation
    const mask = (1 << num.toString(2).length) - 1;
    return num ^ mask;
}

// Example usage:
console.log(findComplement(5)); // Output: 2 (binary 101 -> complement 010)
console.log(findComplement(1)); // Output: 0 (binary 1 -> complement 0)

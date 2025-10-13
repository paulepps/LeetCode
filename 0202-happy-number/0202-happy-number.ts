function isHappy(n: number): boolean {
    const seen = new Set<number>();

    function sumSquareDigits(n: number): number {
        let num = 0;
        while (n !== 0) {
            const digit = n % 10;
            num += digit * digit;
            n = Math.floor(n / 10);
        }
        return num;
    }

    while (true) {
        n = this.sumSquareDigits(n);
        if (n === 1) {
            return true;
        }
        if (seen.has(n)) {
            return false;
        }
        seen.add(n);
    }
}


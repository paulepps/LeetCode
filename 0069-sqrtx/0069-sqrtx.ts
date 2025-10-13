function mySqrt(x: number): number {
    if (x === 0) {
        return 0;
    }

    let n = x;
    let lo = 1, hi = x;
    let res = 1;

    while (lo <= hi) {
        const mid = Math.floor(lo + (hi - lo) / 2);

        if (mid * mid === n) {
            res = mid;
            break;
        }

        if (mid * mid < n) {
            res = mid;
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }

    return res;
}

function canPlaceFlowers(flowerbed: number[], n: number): boolean {
    let count = 0;
    const len = flowerbed.length;

    if (flowerbed[0] == 0 && (len == 1 || flowerbed[1] == 0)) {
        count++;
    } 

    for (let i = 2; i < len - 1; i += 2) {
        if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            count++;
        }
    }

    if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
        count++;
    } 
    return count >= n;
};
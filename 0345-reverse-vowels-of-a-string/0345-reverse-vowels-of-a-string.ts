function reverseVowels(s: string): string {
    const vowels = "aeiou";

    const arr: String[] = s.split('');
    const arrVowels: String[] = [];

    for (let char of arr) {
        if (vowels.includes(char.toLowerCase())) {
            arrVowels.push(char);
        }
    }

    arrVowels.reverse();

    for (let i = 0; i < arr.length; i++) {
        if (vowels.includes(arr[i].toLowerCase())) {
            arr[i] = arrVowels.shift();
        }
    }
    return arr.join('');
};
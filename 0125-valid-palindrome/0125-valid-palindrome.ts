function isPalindrome(s: string): boolean {
    let str: string = s.toLowerCase();
    str = str.replace(/[^a-z0-9]/g, "");

    if (str.length == 0) return true;

    const reversed: string[] = str.split("");
    reversed.reverse();
    const rstr: string = reversed.join("");
console.log(str, rstr)
    return str === rstr;
    
};
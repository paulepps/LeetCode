function gcdOfStrings(str1: string, str2: string): string {
    const l1 = str1.length;
    const l2 = str2.length;

    if(l1 > l2 && str1.slice(0, l2) === str2) {
        return gcdOfStrings(str1.slice(l2), str2);
    } else if(l1 < l2 && str2.slice(0, l1) === str1) {
        return gcdOfStrings(str1, str2.slice(l1));
    } else if(l1 === l2 && str1 === str2)
        return str1;
    
    return "";
};
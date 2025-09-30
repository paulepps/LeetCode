int strStr(char* haystack, char* needle) {

    int i = 0;
    int j = 0;
    int hayLen = strlen(haystack);
    int needleLen = strlen(needle);

    while (i + j < hayLen) {
        if (haystack[i + j] == needle[j]) {  
            if (j == needleLen - 1) return i;  
            j++;
        } else {
            i++;

            if (j > 0 && strncmp(haystack + i, needle, j) == 0)
                j--;
            else
                j = 0;
        }
    }
    return -1;  // No match found
}

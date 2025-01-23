import java.util.*;

class Solution {

    Hashtable<Character, Integer> numbers = new Hashtable<>();

    void loadNumbersTable() {
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);
    }

    public int romanToInt(String s) {
        
        loadNumbersTable();

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int s1 = numbers.get(s.charAt(i));

            if (i + 1 < s.length()) {
                int s2 = numbers.get(s.charAt(i + 1));

                if (s1 >= s2) {
                    total += s1;
                } else {
                    total += (s2 - s1);
                    i++;
                }
            } else {
                total += s1;
            }
        }
        return total;
    }
}
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);

            // Pure arithmetic: extract digits using % and / inside a stream
            int sum = IntStream.iterate(n, x -> x > 0, x -> x / 10)
                               .map(x -> (x % 10) * (x % 10))
                               .sum();

            n = sum;
        }

        return n == 1;    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int curr_line_start = 0;
        int num_words_curr_line = 0;
        int curr_line_length = 0;
 
        ArrayList<String> result = new ArrayList<>();
 
        for (int i = 0; i < words.length; i++) {
 
            ++num_words_curr_line;
 
            int lookahead_line_length
                    = curr_line_length
                    + words[i].length()
                    + (num_words_curr_line - 1);
 
            if (lookahead_line_length == maxWidth) {
 
                String ans
                        = joinALineWithSpaces(
                        words,
                        curr_line_start,
                        i,
                        i - curr_line_start);
 
                result.add(ans);
 
                curr_line_start = i + 1;
 
                num_words_curr_line = 0;
                curr_line_length = 0;
            }
 
            else if (lookahead_line_length > maxWidth) {
 
                String ans
                        = joinALineWithSpaces(
                        words,
                        curr_line_start,
                        i - 1,
                        maxWidth - curr_line_length);
 
                result.add(ans);
 
                curr_line_start = i;
 
                num_words_curr_line = 1;
 
                curr_line_length = words[i].length();
            }
 
            else {
                curr_line_length
                        += words[i].length();
            }
        }
 
        if (num_words_curr_line > 0) {
            StringBuilder line
                    = new StringBuilder(joinALineWithSpaces(
                    words,
                    curr_line_start,
                    words.length - 1,
                    num_words_curr_line - 1));
 
            line.append(
                    " ".repeat(
                            maxWidth - curr_line_length
                                    - (num_words_curr_line - 1)));
 
            result.add(line.toString());
        }
 
        return result;
    }

    String joinALineWithSpaces(
            String[] words,
            int start, int end,
            int num_spaces) {
 
        int num_words_curr_line
                = end - start + 1;
 
        StringBuilder line = new StringBuilder();
 
        for (int i = start; i < end; i++) {
 
            line.append(words[i]);
            --num_words_curr_line;
 
            int num_curr_space
                    = (int) Math.ceil((double) (num_spaces)
                    / num_words_curr_line);
 
            for (int j = 0; j < num_curr_space; j++) {
                line.append(' ');
            }
 
            num_spaces -= num_curr_space;
        }
 
        line.append(words[end]);
        for (int i = 0; i < num_spaces; i++) {
            line.append(' ');
        }
 
        return line.toString();
    }
}
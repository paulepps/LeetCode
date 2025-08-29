class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] dirs = path.split("/");

        for (String dir : dirs) {
            if (!dir.equals("") & !dir.equals(".")) {
                if (!dir.equals("..")) {
                    stack.add(dir);
                } else {
                    if(!stack.isEmpty()) {
                        stack.pollLast();
                    }
                }
            }
        }

        StringBuilder finalPath = new StringBuilder();
        if (stack.isEmpty()) {
            finalPath.append("/");
        } else {
            for (String dir : stack) {
                finalPath.append("/" + dir);
            }
        }
        return finalPath.toString();
    }
};

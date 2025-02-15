class Solution {

    private Map<String, String> parent;
    private Map<String, Double> weight;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        parent = new HashMap<>();
        weight = new HashMap<>();

        for (List<String> equation : equations) {
            parent.put(equation.get(0), equation.get(0));
            parent.put(equation.get(1), equation.get(1));
            weight.put(equation.get(0), 1.0);
            weight.put(equation.get(1), 1.0);
        }

        int equationCount = equations.size();
      
        for (int i = 0; i < equationCount; ++i) {
            List<String> equation = equations.get(i);
            String varA = equation.get(0), varB = equation.get(1);
            String parentA = find(varA), parentB = find(varB);
            if (!Objects.equals(parentA, parentB)) {
                parent.put(parentA, parentB);
                weight.put(parentA, weight.get(varB) * values[i] / weight.get(varA));
            }
        }

        int queryCount = queries.size();
        double[] answers = new double[queryCount];
      
        for (int i = 0; i < queryCount; ++i) {
            String varC = queries.get(i).get(0), varD = queries.get(i).get(1);
            if (!parent.containsKey(varC) || !parent.containsKey(varD) || 
                !Objects.equals(find(varC), find(varD))) {
                answers[i] = -1.0;
            } else {
                answers[i] = weight.get(varC) / weight.get(varD);
            }
        }
        return answers;
    }

    private String find(String x) {
        if (!Objects.equals(parent.get(x), x)) {
            String originalParent = parent.get(x);
            parent.put(x, find(parent.get(x))); // Path compression
            weight.put(x, weight.get(x) * weight.get(originalParent));
        }
        return parent.get(x);
    }
}
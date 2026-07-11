class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 将里面的每一个string编号，然后我们创建一个matrix，每一个cell存储i / j的结果
        // 然后通过floyd warshall去将每一个string作为mid，尝试fill in indirect connection的结果
        // 最后遍历queries，查询matrix的到结果
        int n = 0;
        Map<String, Integer> StringToInteger = new HashMap<>();
        for(List<String> pair : equations) {
            for(String s : pair){
                if(!StringToInteger.containsKey(s)) {
                    StringToInteger.put(s, n++);
                }
            }
        }

        double[][] precompute = new double[n][n];
        for(int i = 0; i < n; i++) {
            precompute[i][i] = 1.0;
        }

        for(int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);
            int x = StringToInteger.get(pair.get(0));
            int y = StringToInteger.get(pair.get(1));
            precompute[x][y] = values[i];
            precompute[y][x] = 1.0 / values[i];
        }

        for(int mid = 0; mid < n; mid++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(precompute[i][j] == 0.0 && precompute[i][mid] > 0 && precompute[mid][j] > 0) {
                        precompute[i][j] = precompute[i][mid] * precompute[mid][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        int i = 0;
        for(List<String> q : queries) {
            if(!StringToInteger.containsKey(q.get(0)) || !StringToInteger.containsKey(q.get(1))) res[i++] = -1.0;
            else{
                double val = precompute[StringToInteger.get(q.get(0))][StringToInteger.get(q.get(1))];
                res[i++] = val == 0.0 ? -1.0 : val;
            }
        }
        return res; 
    }
}
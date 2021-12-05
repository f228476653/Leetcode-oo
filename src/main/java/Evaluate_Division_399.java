
import java.util.*;

class Evaluate_Division_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    Map <String,Map<String, Double>> g = new HashMap<>();
    for (int i = 0; i < equations.size(); ++i) {
      String x = equations.get(i).get(0);
      String y = equations.get(i).get(1);
      g.put(x, new HashMap<String, Double>());
      g.put(y, new HashMap<String, Double>());
    }
    this.fill(g, equations, values);
    double[] ans = new double[queries.size()];
    
    for (int i = 0; i < queries.size(); ++i) {      
      String x = queries.get(i).get(0);
      String y = queries.get(i).get(1);
      if (!g.containsKey(x) || !g.containsKey(y)) {
        ans[i] = -1.0;
      } else {        
        ans[i] = divide(g ,x, y, new HashSet<String>());
      }
    }    
    return ans;
  }
  private void fill(Map <String,Map<String, Double>> g,List<List<String>> equations,double[] values){
      for(int i=0;i<equations.size(); i++){
          g.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
          g.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);
      }
  }
  private double divide(Map <String,Map<String, Double>> g ,String x, String y, Set<String> visited) {
    if (x.equals(y)) return 1.0;
    visited.add(x);
    if (!g.containsKey(x)) return -1.0;
    for (String n : g.get(x).keySet()) {
      if (visited.contains(n)) continue;
      visited.add(n);
      double d = divide(g,n, y, visited);
      if (d > 0) return d * g.get(x).get(n);
    }
    return -1.0;
  }
}
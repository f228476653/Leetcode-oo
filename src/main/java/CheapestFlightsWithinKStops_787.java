import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Time Limit Exceeded
public class CheapestFlightsWithinKStops_787 {
    int step;
    Map<Integer, List<Destination>> adj;
    int cheapest =Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        step = k;
        adj = new HashMap<Integer,List<Destination>>();
        for(int[] f: flights){
            adj.putIfAbsent(f[0],new ArrayList<>());
            adj.get(f[0]).add(new Destination(f[1], f[2]));
        }
        bfs(src,dst,0,0);
        return cheapest ==Integer.MAX_VALUE?-1:cheapest;
    }
    public void bfs(int src, int dst, int currentStep, int currCost){
        if (src==dst){
            cheapest=currCost;
            return;
        }
        if(currentStep > step)
            return;
        if(!adj.containsKey(src))
            return;
        List<Destination> d =adj.getOrDefault(src, new ArrayList<Destination>());
        currentStep++;
        for(int i=0;i<d.size(); i++){
            //If it's greater then the ans so far, continue
            if(currCost+d.get(i).price>cheapest) continue;
            bfs(d.get(i).destination,dst,currentStep, currCost+d.get(i).price);
        }
    }
    public static void main(String[] args) {
        int[][] flight ={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int cost = new CheapestFlightsWithinKStops_787().findCheapestPrice(4,flight,0,3,1);
    }
}

class Destination{
    int destination;
    int price;
    public Destination(int _des, int _price) {
        this.destination = _des;
        this.price = _price;
    }
}


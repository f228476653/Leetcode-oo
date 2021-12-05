import java.awt.*;
import java.util.*;
import java.util.List;

public class Network_Delay_Time_743 {

    public static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        //from index,<to index, weight>
        Map<Integer, Integer> node = new HashMap();
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> a.weight - b.weight);
        for (int[] time : times) {
            if (graph.containsKey(time[0])) {
                node = graph.get(time[0]);
                node.put(time[1], time[2]);
                graph.put(time[0], node);
            } else {
                graph.put(time[0], new HashMap<Integer, Integer>());
                graph.get(time[0]).put(time[1], time[2]);
            }
        }
        boolean[] visited = new boolean[n + 1];
        q.add(new Pair(k, 0));
        int count = 0;
        int[] distance = new int[n + 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        //System.out.print(Arrays.toString(distance));
        graph.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach(e -> {
                System.out.println("from "+entry.getKey() +"to "+e.getKey() + "value " + e.getValue());
            });

        });
        while (q.size() > 0) {
            Pair p = q.poll();
            int currWeight = p.weight;
            if (visited[p.node]) {
                continue;
            }
            visited[p.node] = true;
            if (graph.containsKey(p.node)) {
                for (Map.Entry<Integer, Integer> entry : graph.get(p.node).entrySet()) {

                    q.add(new Pair(entry.getKey(), entry.getValue() + currWeight));
                    if(entry.getKey() == 1){
                        System.out.println("currWeight + entry.getValue()" +currWeight + entry.getValue());
                        System.out.println("distance[entry.getKey()" +distance[entry.getKey()]);
                    }
                    distance[entry.getKey()] = Math.min(currWeight + entry.getValue(), distance[entry.getKey()]);
                }
            }
            //System.out.println(Arrays.toString(q.toArray()));
        }
        System.out.println(Arrays.toString(distance));
        int ans = -1;
        for (int temp = 1; temp < distance.length; temp++) {
            if (temp != k) {
                if (distance[temp] < Integer.MAX_VALUE) {
                    ans = Math.max(ans, distance[temp]);
                } else {
                    ans = -1;
                    break;
                }
            }
        }

        return ans;
//public static int networkDelayTime(int[][] times, int n, int k) {
//
//    // init and fill distance array with infinity
//    int [] distance = new int[n];
//    Arrays.fill(distance, Integer.MAX_VALUE);
//
//    List<List<int [] []>> adj = new ArrayList<>();
//    for(int i = 0 ; i<n; i++) {
//        adj.add(i,new ArrayList<>());
//    }
//
//    // make the Kth node as 0. Array is 0 index based so K-1
//    distance[k-1] = 0;
//
//    // by default its min-heap. We need this to return lowest value in distance array
//    Queue<Integer> heap = new PriorityQueue<>();
//    heap.add(k-1);
//
//    //Build adj list
//    for(int i= 0 ; i < times.length ;i++) {
//        int source = times[i][0];
//        int dest = times[i][1];
//        int weight = times[i][2];
//
//        adj.get(source-1).add(new int [] [] {{dest-1 , weight}});
//    }
//
//    while(! heap.isEmpty()) {
//        // perform djikstra on smallest weight
//        int currentVertex = heap.poll();
//        // get neighbours
//        List<int [] []> neighbours = adj.get(currentVertex);
//
//        for(int i = 0 ; i  < neighbours.size() ; i++) {
//            int [] [] neighbouringVertexDetails = neighbours.get(i);
//            int neighbouringVertex = neighbouringVertexDetails[0][0];
//            int edgeWeight = neighbouringVertexDetails[0][1];
//
//            /*
//             * Update the distance array when currentVertex weight + weight of edge < neighbouring vertex weight update distance array
//             *
//             */
//            if(neighbouringVertex ==0){
//                System.out.println(edgeWeight);
//                System.out.println( distance[currentVertex]);
//            }
//            if(distance[currentVertex] + edgeWeight < distance[neighbouringVertex]) {
//                distance[neighbouringVertex] = distance[currentVertex] + edgeWeight;
//                /*neighbouringVertex might became less than infinity. Now for next iteration we need smallest value in distance array
//                 * Thats why we use PriorityQueues this will always return smallest value (min-heap)
//                 */
//                heap.add(neighbouringVertex);
//            }
//        }
//    }
//    // return max value from distance array
//
//    System.out.println(Arrays.toString(distance));
//    Arrays.sort(distance);
//    return distance[distance.length-1] == Integer.MAX_VALUE ? -1 : distance[distance.length-1];
//
//}
    }

    public static void main(String[] args){
        int [][] times= {{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},{1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},{2,4,77},{5,2,74}};
        Network_Delay_Time_743 temp = new Network_Delay_Time_743();
        temp.networkDelayTime(times,5,3);
    }
}

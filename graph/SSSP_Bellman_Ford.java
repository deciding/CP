import java.util.*;
import java.io.*;
//Bellman Ford can check negative cycle
//original Dijkstra can give us wrong answer if there is a negative edge
//modified Dijkstra can give us right answer if there is a negative edge but can raise to 2^n
// it will also give us infinite loop if there is a negative cycle
public class SSSP_bellman_ford {
  public static final int INF = 1000000000;
  private static Vector< Vector< IntegerPair > > AdjList =
             new Vector< Vector< IntegerPair > >();
	  
  public static void main(String[] args) throws Exception {
    int V, E, s, a, b, w;


    File f = new File("in_06.txt");
    Scanner sc = new Scanner(f);

    V = sc.nextInt();
    E = sc.nextInt();
    s = sc.nextInt();

    AdjList.clear();
    for (int i = 0; i < V; i++) {
      Vector< IntegerPair > Neighbor = 
        new Vector < IntegerPair >();
      AdjList.add(Neighbor); // add neighbor list to Adjacency List
    }

    for (int i = 0; i < E; i++) {
      a = sc.nextInt();
      b = sc.nextInt();
      w = sc.nextInt();
      AdjList.get(a).add(new IntegerPair(b, w)); // first time using weight
    }
    
    // as an example, we start from this source (see Figure 1.15)
    Vector< Integer > dist = new Vector< Integer >();
    dist.addAll(Collections.nCopies(V, INF));
    dist.set(s, 0);

    // Bellman Ford routine
    for (int i = 0; i < V - 1; i++) // relax all E edges V-1 times, O(V)
      for (int u = 0; u < V; u++) { // these two loops = O(E)
        Iterator it = AdjList.get(u).iterator();
        while (it.hasNext()) { // relax these edges
          IntegerPair v = (IntegerPair)it.next();
          dist.set(v.first(), 
            Math.min(dist.get(v.first()), dist.get(u) + v.second()));
        }
      }

    boolean negative_cycle_exist = false;
    for (int u = 0; u < V; u++) { // one more pass to check
      Iterator it = AdjList.get(u).iterator();
      while (it.hasNext()) { // relax these edges
        IntegerPair v = (IntegerPair)it.next();
        if (dist.get(v.first()) > dist.get(u) + v.second()) // should be false, but if possible
          negative_cycle_exist = true;            // then negative cycle exists!
      }
    }
    System.out.printf("Negative Cycle Exist? %s\n", negative_cycle_exist ? "Yes" : "No");

    if (!negative_cycle_exist)
      for (int i = 0; i < V; i++)
        System.out.printf("SSSP(%d, %d) = %d\n", s, i, dist.get(i));
  }
}

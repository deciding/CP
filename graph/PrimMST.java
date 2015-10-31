//different from bfs, set visited when popped
Vector < Vector < IntegerPair > > AdjList;
Vector < Boolean > taken;
PriorityQueue < IntegerPair > pq;

void process(int vtx) {
  taken.set(vtx, true);
  for (int j = 0; j < AdjList.get(vtx).size(); j++) {
    IntegerPair v = AdjList.get(vtx).get(j);
    if (!taken.get(v.first()))
      // we sort by weight then by adjacent vertex
      pq.offer(new IntegerPair(v.second(), v.first()));
  }
}
//inside main
public static void main(String[] args) throws Exception {
  Scanner sc = new Scanner(System.in);
  int V = sc.nextInt(), E = sc.nextInt();
  AdjList = new Vector < Vector < IntegerPair > >();

  for (int i = 0; i < V; i++) {
    Vector < IntegerPair > Neighbor = new Vector < IntegerPair >(); // create vector of Integer pair 
    AdjList.add(Neighbor); // store blank vector first
  }
  
  for (int i = 0; i < E; i++) { // store graph information in Adjacency List
    // we decrease index by 1 to change input to 0-based indexing
    int u = sc.nextInt() - 1, v = sc.nextInt() - 1, w = sc.nextInt();
    AdjList.get(u).add(new IntegerPair(v, w)); // bi-directional
    AdjList.get(v).add(new IntegerPair(u, w));
  }

  taken = new Vector < Boolean >(); 
  taken.addAll(Collections.nCopies(V, false));
  pq = new PriorityQueue < IntegerPair > ();
  // take any vertex of the graph, for simplicity, vertex 0, to be included in the MST
  process(0);
  int mst_cost = 0;
  
  while (!pq.isEmpty()) { // we will do this until all V vertices are taken (or E = V-1 edges are taken)
    IntegerPair front = pq.poll();
    if (!taken.get(front.second())) { // we have not connected this vertex yet
      mst_cost += front.first(); // add the weight of this edge
      process(front.second());
    }
  }
}



class IntegerPair implements Comparable<IntegerPair> {
  Integer _first, _second;

  public IntegerPair(Integer f, Integer s) {
    _first = f;
    _second = s;
  }

  public int compareTo(IntegerPair o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else
      return this.second() - o.second();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
}

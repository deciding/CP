//Bipartite graph check
//use BFS, change d[] to color[], add isBipartite
void bipartiteCheck(int u){
	ArrayList<Integer> color= new ArrayList<Integer>(Collections.nCopies(V,INF));
	color.get(s)=0;
	LinkedList<Integer> q=new LinkedList<Integer>();
	q.offer(s);
	boolean isBipartite=true;

	while(!q.isEmpty()&&isBipartite){
		u=q.poll();
		for(int j=0;j<AdjList.get(u).size();j++){
			IntegerPair v=AdjList.get(u).get(j);
			if(color.get(v.first())==INF){
				color.set(v.first(),1-color.get(u));//reverse color
				q.offer(v.first());
			}
			else if(color.get(u)==color.get(v.first())){
				isBipartite=false;
				break;
			}
		}
			
	}
	System.out.println("Is Bipartite? "+isBipartite);
}
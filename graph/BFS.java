//BFS
void bfs(int u){
	ArrayList<Integer> d= new ArrayList<Integer>(Collections.nCopies(V,INF));
	d.get(s)=0;
	LinkedList<Integer> q=new LinkedList<Integer>();
	q.offer(s);

	while(!q.isEmpty()){
		u=q.poll();
		for(int j=0;j<AdjList.get(u).size();j++){
			IntegerPair v=AdjList.get(u).get(j);
			if(d.get(v.first())==INF){
				d.set(v.first(),d.get(u)+1);
				q.offer(v.first());
			}
		}
			
	}
}
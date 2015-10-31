//DFS
ArrayList<Integer> dfs_num= new ArrayList<Integer>(Collections.nCopies(V,UNVISITED));
void dfs(int u){
	dfs_num.set(u,VISITED);
	for(int j=0;j<AdjList.get(u).size();j++){
		IntegerPair v=AdjList.get(u).get(j);
		if(dfs_num.get(v.first())!=VISITED)
			dfs(v.first());
	}
}
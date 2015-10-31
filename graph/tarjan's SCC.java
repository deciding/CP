//tarjan's SCC
//we can contract connected SCCs to DAG
//still use dfs_low, but not so that meaningful
//visited means in stack, in stack means they may form a SCC
void tarjanSCC(int u){
	dfs_low.set(u,dfsNumberCounter);
	dfs_num.set(u,dfsNumberCounter);
	dfsNumberCounter++;
	S.push(u);
	visited.set(u,true);
	for(int j=0;j<AdjList.get(u).size();j++){
		IntegerPair v=AdjList.get(u).get(j);
		if(dfs_num.get(v.first())==UNVISITED)
			tarjanSCC(v.first());
		if(visited.get(v.first()))
		//mainly for back edge, for forward edge, there will be no update for dfs_low
		// for cross edge there's no possibility to have a visited one
			dfs_low.set(u,Math.min(dfs_low.get(u),dfs_low.get(v.first())));
	}
	//after processing all children, see whether this node can be the start of a SCC
	if(dfs_low.get(u)==dfs_low.get(u)){
		numSCC++;
		while(1){
			int v=S.pop();
			visited.set(v,false);
			System.out.println(v+" ");
			if(u==v) break;
		}
		System.out.println("\n");
	}
}

//inside main
public static void main(String[] args) {
	ArrayList<Integer> dfs_num= new ArrayList<Integer>(Collections.nCopies(V,UNVISITED));
	ArrayList<Integer> dfs_low= new ArrayList<Integer>(Collections.nCopies(V,0));
	ArrayList<Boolean> visited= new ArrayList<Integer>(Collections.nCopies(V,false));
	ArrayList<Integer> S= new ArrayList<Integer>();
	int dfsNumberCounter=0;
	int numSCC=0;
	for(int i=0;i<V;i++)
		if(dfs_num==UNVISITED)
			tarjanSCC(i);
}
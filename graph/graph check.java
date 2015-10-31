//graph check: back edge, forward edge, cross edge
//add EXPLORED, means haven't finish checking all its neighbors
ArrayList<Integer> dfs_num= new ArrayList<Integer>(Collections.nCopies(V,UNVISITED));
ArrayList<Integer> dfs_parent= new ArrayList<Integer>(Collections.nCopies(V,0));//0 or -1 ok
void graphCheck(int u){
	dfs_num.get(u)=EXPLORED;
	for(int j=0;j<AdjList.get(u).size();j++){
		IntegerPair v=AdjList.get(u).get(j);
		if(dfs_num.get(v.first())==UNVISITED){
			dfs_parent.set(v.first(),u);
			graphCheck(v.first());
		}
		else if(dfs_num.get(v.first())==EXPLORED){//check cyclic
			if(v.first()==dfs_parent.get(u))
				System.out.format("Two ways (%d,%d)-(%d,%d)\n",v.first(),u,u,v.first());
			else 
				System.out.format("Back Edge (%d,%d)\n",u,v.first());
		}
		else if(dfs_num.get(v.first())==VISITED)
			System.out.format("Forward/Cross Edge (%d,%d)\n",u,v.first());
	}
	dfs_num.get(u)=VISITED;
}
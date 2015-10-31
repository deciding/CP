//find articulation point,edge UNdirected
//Here has the concept of "tree"
//dfs_num means the dfs step, it is unique
//dfs_low means the lowest dfs step number this node's "children" can reach, only cycle can make
// it smaller than dfs_num
void articulationPointAndBridge(int u){
	dfs_low.set(u,dfsNumberCounter);
	dfs_num.set(u,dfsNumberCounter);
	dfsNumberCounter++;
	for(int j=0;j<AdjList.get(u).size();j++){
		IntegerPair v=AdjList.get(u).get(j);
		if(dfs_num.get(v.first())==UNVISITED){
			dfs_parent.set(v.first(),u);//in case two way edge
			if(u==dfsRoot)
				rootChildren++;//special case: root must have more than one children to be AP
			articulationPointAndBridge(v.first());
			//only compare with children, because parent won't have a higher dfs_low than
			// children's dfs_num
			if(dfs_num.get(u)<=dfs_low.get(v.first()))
				articulation_vertex.set(u,true);
			if(dfs_num.get(u)<dfs_low.get(v.first()))
				System.out.format("Edge (%d,%d) is a Bridge",u,v.first());
			dfs_low.set(u,Math.min(dfs_low.get(u),dfs_low.get(v.first())));//as defined
		}
		//there's only back edge in undirected graph, no forward/cross edge
		else if(dfs_parent.get(u)!=v.first())
			//dfs_num because we only want to get children's lowest, if it is dfs_low
			// we may get also the parent's lowest. think of '8' shaped graph which
			// contains a subcycle
			dfs_low.set(u,Math.min(dfs_low.get(u),dfs_num.get(v.first())));
	}
}

//inside main
public static void main(String[] args) {
	ArrayList<Integer> dfs_num= new ArrayList<Integer>(Collections.nCopies(V,UNVISITED));
	ArrayList<Integer> dfs_low= new ArrayList<Integer>(Collections.nCopies(V,0));
	ArrayList<Integer> dfs_parent= new ArrayList<Integer>(Collections.nCopies(V,0));
	ArrayList<Integer> articulation_vertex= new ArrayList<Integer>(Collections.nCopies(V,0));
	int dfsNumberCounter=0;
	for(int i=0;i<V;i++)
		if(dfs_num==UNVISITED){
			int dfsRoot=i;
			int rootChildren=0;
			articulationPointAndBridge(i);
			articulation_vertex.get(i)=(rootChildren>1);//if root has more than 1 chidren, they
			// must not be connected, thus root must be AP
		}
}
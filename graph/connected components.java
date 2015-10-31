//find connected components
//only work for undirected
//counter example:  3 => 1 , it is connected but our method will show it as two components
//					2 =>
int numCC=0;
Vector<Integer> dfs_num= new Vector<Integer>(Collections.nCopies(V,UNVISITED));
for(int i=0;i<V;i++)
	if(dfs_num.get(i)==UNVISITED){
		numCC++;
		dfs(i);
	}
//topological sort
//post order traversal is the right order, but reversed

//DFS
//  => 4
//1 => 2 => 3
//output: 1 2 3 4
ArrayList<Integer> stack= new ArrayList<Integer>();
ArrayList<Integer> dfs_num= new ArrayList<Integer>();
void dfs2(int u){
	dfs_num.get(u)=VISITED;
	for(int j=0;j<AdjList.get(u).size();j++){
		IntegerPair v=AdjList.get(u).get(j);
		if(dfs_num.get(v.first())!=VISITED)
			dfs(v.first());
	}
	stack.add(u);
}

public static void main(String[] args) {
	stack.clear();
	dfs_num=new ArrayList<Integer>(Collections.nCopies(V,UNVISITED));
	for(int i=0;i<V;i++)
		if(dfs_num[i]==UNVISITED)
			dfs2(i);
	for(int i=stack.size()-1;i>=0;i--)
		System.out.println(stack.get(i)+" ");
}

//BFS
//  => 4
//1 => 2 => 3
//output: 1 4 2 3
LinkedList<Integer> q= new LinkedList<Integer>();
void bfs(int u){
	ArrayList<Integer> in_count=new ArrayList<Integer>(Collections.nCopies(V,0));

	for(int i=0;i<V;i++)
		for(int j=0;j<AdjList.get(i).size();j++)
	  		in_count[AdjList.get(i).get(j).first()]++;
	for(int i=0;i<V;i++)
		if(in_count[i]==0)
		    q.offer(i);

	while(!q.isEmpty()){
	  	int cur = q.poll();
	  	System.out.println(cur+" ");
	  	for(int j=0;j<AdjList.get(cur).size();j++){
	  		IntegerPair v= AdjList.get(cur).get(j);
	    	in_count[v.first()]--;
	    	if(in_count[v.first()]==0)
	      		q.offer(v.first());
	  	}
	}
}
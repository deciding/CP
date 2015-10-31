//flood fill
int[] dr={1,1,0,-1,-1,-1,0,1};
int[] dc={0,1,1,1,0,-1,-1,-1};

//return the size of this CC
//find CC of c1 and change to c2
int floodfill(int r, int c, char c1,char c2){
	if(r<0||c<0||r>=R||c>=C) return 0;
	if(grid[r][c]!=c1) return 0;

	grid[r][c]=c2;//avoid cycling
	int ans =1;//already have one c1
	for(int i=0;i<8;i++)
		ans+=floodfill(r+dr[i],c+dc[i],c1,c2);
	return ans;
}
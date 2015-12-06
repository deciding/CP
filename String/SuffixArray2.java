int wa[maxn],wb[maxn],wv[maxn],ws[maxn];
int cmp(int *r,int a,int b,int l)
{return r[a]==r[b]&&r[a+l]==r[b+l];}
void da(int *r,int *sa,int n,int m)//double algorithm, r is T initially
{
	int i,j,p,*x=wa,*y=wb,*t;
	for(i=0;i<m;i++) ws[i]=0;//sum
	for(i=0;i<n;i++) ws[x[i]=r[i]]++;
	for(i=1;i<m;i++) ws[i]+=ws[i-1];
	for(i=n-1;i>=0;i--) sa[--ws[x[i]]]=i;//from back to front, make it stable
	for(j=1,p=1;p<n;j*=2,m=p)//p<n early break!!
	{
		//#:j
		for(p=0,i=n-j;i<n;i++) y[p++]=i;//y:sa[i+k], all empty ones should at front.
		//#:n-j
		for(i=0;i<n;i++) if(sa[i]>=j) y[p++]=sa[i]-j;//(sa[i]-j)+j->(sa[i]-j)

		for(i=0;i<n;i++) wv[i]=x[y[i]];//y[i] SA i: rank in second key, y: who is it
										//x[i] RA i: who is it, x: rank in first key(previous)
										//wv[i] i:rank in second key, wv:rank in first
										//second rank are unique, first rank x can have same because of last 2lines process
		for(i=0;i<m;i++) ws[i]=0;
		for(i=0;i<n;i++) ws[wv[i]]++;
		for(i=1;i<m;i++) ws[i]+=ws[i-1];
		for(i=n-1;i>=0;i--) sa[--ws[wv[i]]]=y[i];//--ws[wv] change from maybe duplicate rank wv
									//to unique rank 
									//i is rank in second key, which means when wv rank same
									//--ws[wv] will assign bigger unique rank to bigger i !
									//y[i] who is it

		//y is useless, but we still need x for update x, so we change y to x
		//but need to swap because they are pointers
		for(t=x,x=y,y=t,p=1,x[sa[0]]=0,i=1;i<n;i++)
			x[sa[i]]=cmp(y,sa[i-1],sa[i],j)?p-1:p++;//same as that table! x:RA
	}
	return;
}
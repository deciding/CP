import java.util.*;
public class Solution {
	static int count=0;
	static int n;
	static BitSet rw=new BitSet(15);
	static BitSet ld=new BitSet(29);
	static BitSet rd=new BitSet(29);
	public static void nQueens(int c) {
        // write your code here
		if(c==n) {
			count++;
			return;
		}
		for(int r=0;r<n;r++){//row indexed array traversal is faster!
			if(!rw.get(r)&&!ld.get(n-1+r-c)&&!rd.get(r+c)) {
				rw.set(r);ld.set(n-1+r-c);rd.set(r+c);
				nQueens(c+1);
				rw.clear(r);ld.clear(n-1+r-c);rd.clear(r+c);//must have!!
			}
		}
        
    }
    
    public static void main(String args[]){
    	Scanner sc= new Scanner(System.in);
    	n=sc.nextInt();
    	nQueens(0);
    	System.out.println(count);
    	sc.close();
    }
}

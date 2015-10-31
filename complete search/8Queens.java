import java.util.*;
public class Solution {
	static int count=0;
	static int[] row=new int[8];
	public static boolean valid(int r,int c){
		for(int i=0;i<c;i++){
			if(row[i]==r||Math.abs(i-c)==Math.abs(row[i]-r))
				return false;
		}
		return true;
	}
	public static void Queens(int c) {
        // write your code here
		if(c==8) {
			count++;
			return;
		}
		for(int r=0;r<8;r++){
			if(valid(r,c)) {
				row[c]=r;//no need to renew row[] at c==8, because of this line
				Queens(c+1);
			}
		}
        
    }
    
    public static void main(String args[]){
    	Queens(0);
    	 System.out.println(count);
    }
}

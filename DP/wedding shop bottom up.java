import java.util.*;
public class Solution {
	static int M,C;
	static boolean[][] reachable= new boolean[21][201];
	static int[][] price= new int[21][21];
	
	static int shop(){
		for(int i=1;i<=price[0][0];i++){
			if(M-price[0][i]>=0)
				reachable[0][M-price[0][i]]=true;
		}
		for(int g=1;g<C;g++)
			for(int money=0;money<=M;money++)if(reachable[g-1][money])//early pruning
				for(int model=1;model<=price[g][0];model++)if(money-price[g][model]>=0&&!reachable[g][money-price[g][model]])
						reachable[g][money-price[g][model]]=true;
		for(int money=0;money<=M;money++)
			if(reachable[C-1][money]){
				return M-money;
			}
		return -1;
	}
    public static void main(String args[]){
    	int TC;
    	Scanner sc=new Scanner(System.in);
    	TC=sc.nextInt();
    	while(TC--!=0){
    		M=sc.nextInt();
    		C=sc.nextInt();
    		for(int i=0;i<C;i++){
    			price[i][0]=sc.nextInt();
    			for(int k=1;k<=price[i][0];k++){
    				price[i][k]=sc.nextInt();
    			}
    		}
    		for(int i=0;i<21;i++)
                for(int j=0;j<201;j++)
                    reachable[i][j]=false;
    		System.out.println(shop());
    	}
    	sc.close();
    }
}
//1
//20 3
//3 6 4 9
//2 5 10
//4 1 5 3 5
//9 3
//3 6 4 8
//2 5 10
//4 1 5 3 5
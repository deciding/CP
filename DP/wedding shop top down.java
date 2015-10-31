import java.util.*;
public class Solution {
    static int M,C;
    static int[][] state= new int[21][201];
    static int[][] price= new int[21][21];
    
    static int shop(int money, int g){
        if(money<0)return -1;//that's why we need max, and then we need how much we spent
        if(g==C){
            state[g][money]=M-money;
            return M-money;
        }
        if(state[g][money]!=-1) return state[g][money];
        int num=price[g][0];//price g is one offset behind
        int ans=-1;
        for(int i=1;i<=num;i++){
            ans=Math.max(ans, shop(money-price[g][i],g+1));
        }
        state[g][money]=ans;
        return ans;
    }
    static void print_shop(int money, int g){
        if(g==C)return;
        for(int i=1; i<=price[g][0];i++){
            if(money-price[g][i]>=0&&state[g+1][money-price[g][i]]==state[g][money]){
                System.out.println(price[g][i]);
                print_shop(money-price[g][i],g+1);
                break;
            }
        }
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
                    state[i][j]=-1;
            System.out.println(shop(M,0));
            print_shop(M,0);
        }
        sc.close();
    }
}
//1
//20 3
//3 6 4 8
//2 5 10
//4 1 5 3 5
//9 3
//3 6 4 8
//2 5 10
//4 1 5 3 5
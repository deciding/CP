import java.util.*;
//can be used if there are redundant chars in between(subsequence)
//can also be used if there must be no redundant chars, just modify last line
//return table[l][r]=len(l+1,r-1);
class longest_palindrome {
  static char[] A = "RACEF1CARFAST".toCharArray();
  static int[][] table = new int[20][20];
  static int len(int l,int r){
    if(l==r) return 1;
    if(l+1==r) return A[l]==A[r]?2:1;
    if(table[l][r]!=0) return table[l][r];
    if(A[l]==A[r]) return table[l][r]=2+len(l+1,r-1);
    return table[l][r]=Math.max(len(l+1,r),len(l,r-1));
  } 
  public static void main(String[] args){
    
    System.out.printf("Maximum Alignment Score: %d\n", len(0,A.length-1));
  }
}

import java.util.*;
//if using DP, we need bottom up, LIS(i) means if use i as last element 
//what is the length of LIS. O(n^2)

//if Greedy & D&C, O(nlogk). every time find the last one smaller than i(binary search) and insert
//into L behind i, go for each item once, at last the length of L is result
class LIS {
  //if the last element index in subsequense is end, what is the LIS
  static void reconstruct_print(int end, int[] a, int[] p) {
    int x = end;
    Stack<Integer> s = new Stack();
    for (; p[x] >= 0; x = p[x]) s.push(a[x]);
    System.out.printf("[%d", a[x]);
    for (; !s.isEmpty(); s.pop()) System.out.printf(", %d", s.peek());
    System.out.printf("]\n");
  }

  public static void main(String[] args) {
    final int MAX_N = 100000;

    int n = 11;
    int[] A = new int[] {-7, 10, 9, 2, 3, 8, 8, 1, 2, 3, 4};
    int[] L_id = new int[MAX_N], P = new int[MAX_N];
    Vector<Integer> L = new Vector<Integer>();

    int lis = 0, lis_end = 0;
    for (int i = 0; i < n; ++i) {
      int pos = Collections.binarySearch(L, A[i]);
      if (pos < 0) pos = -(pos + 1); // some adjustments are needed
      if (pos >= L.size()) L.add(A[i]);
      else                 L.set(pos, A[i]);
      L_id[pos] = i;//index in origarr of every element in L, used to support P
      P[i] = pos > 0 ? L_id[pos - 1] : -1;//parent element in LIS for every element in origarr
      if (pos + 1 > lis) {
        lis = pos + 1;//result
        lis_end = i;// in LIS, last element index of origarr
      }

      System.out.printf("Considering element A[%d] = %d\n", i, A[i]);
      System.out.printf("LIS ending at A[%d] is of length %d: ", i, pos + 1);
      reconstruct_print(i, A, P);
      System.out.println("L is now: " + L);
      System.out.printf("\n");
    }

    System.out.printf("Final LIS is of length %d: ", lis);
    reconstruct_print(lis_end, A, P);
  }
}
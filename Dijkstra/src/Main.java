 import java.util.Scanner;

 public class Main {

     static int cost[][];
     static int size;
     public static void main(String[] args) {
         System.out.println("Dijstra Algorithm to find shortest path");
         Scanner in = new Scanner(System.in);
         System.out.println("Enter Size of the Grap");
         size = in.nextInt();
         cost = new int[size][size];
         System.out.println("Enter cost matrix");
         for(int i=0;i<size;i++) {
             for (int j = 0; j < size; j++) {
                 cost[i][j] = in.nextInt();
                 if(cost[i][j]==0){
                     cost[i][j]=9999;
                 }
             }
         }
         System.out.println("Enter source node");
         int s = in.nextInt();
         dijktra(s);
     }
     public static void dijktra(int s){
         int[] v = new int[size];
         int[] shortestpath= new int[size];
         for(int i=0;i<size;i++){
             v[i]=0;
             shortestpath[i] = cost[s][i];
         }
         v[s]=1;
         shortestpath[s]=0;
         int g=1;
         int minindex;
         while(g<size){
             g++;
             minindex = getminimun(v,shortestpath);
             v[minindex]=1;
             for(int i=0;i<size;i++){
                 if(shortestpath[minindex]+cost[minindex][i]<shortestpath[i]&&v[i]==0)
                     shortestpath[i]=shortestpath[minindex]+cost[minindex][i];
             }
         }
         for(int i=0;i<size;i++){
             if(i!=s){
                 System.out.println("min path to "+ i +" is : " + shortestpath[i]);
             }
         }

     }
     public static int getminimun(int[] v,int[] shortestpath){
         int min=9999;
         int minindex=0;
         for(int i=0;i<size;i++){
             if(min>shortestpath[i]&&v[i]==0) {
                 minindex = i;
                 min = shortestpath[i];
             }
         }
         return minindex;
     }
 }
//import java.util.*;
//public class Main {
//    final static int MAX = 20;
//    final static int infinity = 9999;
//    static int n;// No. of vertices of G
//    static int a[][];// Cost matrix
//    static Scanner scan = new Scanner(System.in);
//    public static void main(String[] args) {
//        ReadMatrix();
//        int s = 0; // starting vertex
//        System.out.println("Enter starting vertex: ");
//        s = scan.nextInt();
//        Dijkstras(s); // find shortest path
//    }
//    static void ReadMatrix() {
//        a = new int[MAX][MAX];
//        System.out.println("Enter the number of vertices:");
//        n = scan.nextInt();
//        System.out.println("Enter the cost adjacency matrix:");
//        for (int i = 1; i <= n; i++)
//            for (int j = 1; j <= n; j++)
//                a[i][j] = scan.nextInt();
//    }
//    static void Dijkstras(int s) {
//        int S[] = new int[MAX];
//        int d[] = new int[MAX];
//        int u, v;
//        int i;
//        for (i = 1; i <= n; i++) {
//            S[i] = 0;
//            d[i] = a[s][i];
//        }
//        S[s] = 1;
//        d[s] = 1;
//        i = 2;
//        while (i <= n) {
//            u = Extract_Min(S, d);
//            S[u] = 1;
//            i++;
//            for (v = 1; v <= n; v++) {
//                if (((d[u] + a[u][v] < d[v]) && (S[v] == 0)))
//                    d[v] = d[u] + a[u][v];
//            }
//    }
//    for (i = 1; i <= n; i++)
//        if (i != s)
//            System.out.println(i + ":" + d[i]);
//    }
//    static int Extract_Min(int S[], int d[]) {
//        int i, j = 1, min;
//        min = infinity;
//        for (i = 1; i <= n; i++) {
//            if ((d[i] < min) && (S[i] == 0)) {
//                min = d[i];
//                j = i;
//            }
//        }
//        return (j);
//    }
//}
 //INPUT
 /*
0
18
1
9999
9999
18
0
9999
6
4
1
9999
0
2
9999
9999
6
2
0
20
9999
4
9999
20
0
*/
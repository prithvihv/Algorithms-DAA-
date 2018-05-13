import java.util.Scanner;

public class Main {

    static int cost[][];
    static int parent[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Size of the Matrix");
        int size = in.nextInt();
        cost = new int[size][size];
        parent = new int[size];
        System.out.println("Enter cost matrix");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cost[i][j] = in.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }


        int ne =1;
        int a=0,b=0;
        int totalcost = 0;
        while(ne< size){
            //find minimum first
            for(int i =0,min=cost[0][0];i<size;i++){
                for(int j=0;j<size;j++){
                    if(cost[i][j]<min){
                        min  = cost[i][j];
                        a=i;
                        b=j;
                    }
                }
            }
            int i = find(a);
            int j = find(b);
            if(i!=j){
                totalcost = totalcost+cost[a][b];
                ne++;
                union(a,b);
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("totalcost :" + totalcost);
    }
    static  int find(int a){
        int i=a;
        while(parent[i]!=0)
            i = parent[i];
        return i;
    }

    static void union(int i,int j){
        parent[i]=parent[j];
    }

}

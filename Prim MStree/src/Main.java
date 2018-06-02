import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Size of the cost Matrix");
        int size = in.nextInt();
        System.out.println("Enter the cost Matrix");
        int[][] cost= new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                cost[i][j] = in.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }
        int a=0;
        int b=0;
        int ne=1;
        boolean[] visited = new boolean[size];
        for(boolean vis:visited){
            vis = false;
        }
        int mincost=0;
        while(ne<size){
            for(int i=0,min=999;i<size;i++){
                for(int j=0;j<size;j++) {
                    if(!visited[i]){
                        if(cost[i][j]<min){
                            min = cost[i][j];
                            a=i;
                            b=j;
                        }
                    }
                }
            }
            if(!visited[a]||!visited[b]){
                ne++;
                visited[b]=true;
                mincost=mincost + cost[a][b];
            }
            cost[a][b]= cost[a][b]= 999;
        }
        System.out.println(mincost);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HamiltonianCycle obj=new HamiltonianCycle();
        obj.getHCycle(1);
    }
}
class HamiltonianCycle
{
    //n Total number of nodes
    private int adj[][],x[],n;

    public HamiltonianCycle() {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        n=src.nextInt();
        x=new int[n];
        x[0]=0;
        for (int i=1;i<n; i++)
            x[i]=-1;
        adj=new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for (int i=0;i<n; i++)
            for (int j=0; j<n; j++)
                adj[i][j]=src.nextInt();
    }

    public void nextValue (int k)
    {
        int i=0;
        while(true)
        {
            x[k]=x[k]+1;
            if (x[k]==n)
                x[k]=-1;
            if (x[k]==-1)
                return;
            if (adj[x[k-1]][x[k]]==1)
                for (i=0; i<k; i++)
                    if (x[i]==x[k])
                        break;
            if (i==k)
                if (k<n-1 || k==n-1 && adj[x[n-1]][0]==1)
                    return;
        }
    }
    public void getHCycle(int k)
    {
        while(true)
        {
            nextValue(k);
            if (x[k]==-1)
                return;
            if (k==n-1)
            {
                System.out.println("\nSolution : ");
                for (int i=0; i<n; i++)
                    System.out.print((x[i]+1)+" ");
                System.out.println(1);
            }
            else getHCycle(k+1);
        }
    }
}
//Input
//0 1 1 1
//1 0 1 1
//1 1 0 1
//1 1 1 0
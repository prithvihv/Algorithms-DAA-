import java.util.Scanner;

public class Main {

    static KPobject[] ArrayObjects;
    static int M;
    static Scanner in;
    static int SIZE;

    public static void main(String[] args) {
        System.out.println("KnapSack Greedy algorithm");
        System.out.println("Enter the number of objects present");
        in = new Scanner(System.in);
        SIZE = in.nextInt();
        //remove +1 for greedy
        ArrayObjects = new KPobject[SIZE+1];
        for(int i=0;i<SIZE+1;i++){
            ArrayObjects[i] = new KPobject();
        }
        System.out.println("Enter the Size of knapsack");
        M = in.nextInt();
        //Greedy();
        Dynamic();
    }
    static void Greedy(){
        float Totalweight = M;
        float profit=0;
        int breaker=0;
        float result[] = new float[SIZE];
        System.out.println("Enter Weight then profit:");
        for(int i=0;i<SIZE;i++){
            ArrayObjects[i].weight = in.nextFloat();
            ArrayObjects[i].profit = in.nextFloat();
            ArrayObjects[i].calculateValue();
        }
        KPobject temp = new KPobject();
        for(int i=0;i<SIZE-1;i++)
            for(int j=0;j<SIZE-i-1;j++){
                if(ArrayObjects[j].value<ArrayObjects[j+1].value){
                    temp= ArrayObjects[j];
                    ArrayObjects[j]=ArrayObjects[j+1];
                    ArrayObjects[j+1]=temp;
                }
            }
        for(int i=0;i<SIZE;i++){
            if(ArrayObjects[i].weight>Totalweight){
                breaker=i;
                break;
            }else{
                result[i]=1;
                Totalweight= Totalweight - ArrayObjects[i].weight;
                profit = profit + (int)ArrayObjects[i].profit;
            }
        }
        if(Totalweight!=0){
            result[breaker] = Totalweight/ArrayObjects[breaker].weight;
            profit = profit + ArrayObjects[breaker].profit*result[breaker];
        }
        System.out.println();
        System.out.print("Result Array is given by [");
        for(int i=0;i<result.length;i++){
            System.out.print(" " + result[i] +"");
        }
        System.out.print("]");
        System.out.println("Profit is :" + profit);
    }
    static void Dynamic(){
        System.out.println("Enter Weight then profit:");
        for(int i=1;i<=SIZE;i++){
            ArrayObjects[i].weight = in.nextFloat();
            ArrayObjects[i].profit = in.nextFloat();
            ArrayObjects[i].calculateValue();
        }
        int[][] DynamicTable= new int[SIZE+1][M+1];
        int[][] keep = new int[SIZE+1][M+1];
        for(int i=0;i<=SIZE;i++){
            DynamicTable[i][0]=0;
        }
        for(int i=0;i<=M;i++){
            DynamicTable[0][i]=0;
        }
        for (int i=1;i<=SIZE;i++){
            for(int j=1;j<=M;j++){
                    if((j>=ArrayObjects[i].weight)&&DynamicTable[i-1][j]<(ArrayObjects[i].profit + DynamicTable[i-1][j-(int)ArrayObjects[i].weight])) {
                        DynamicTable[i][j]= (int)ArrayObjects[i].profit + DynamicTable[i-1][j-(int)ArrayObjects[i].weight];
                        keep[i][j]=1;
                    }else{
                        DynamicTable[i][j]= DynamicTable[i-1][j];
                        keep[i][j]=0;
                    }
            }
        }
        int TottalWeight = M;
        System.out.println("Object to be included are :");
        for(int n=SIZE ;n>=0;n--){
            if(keep[n][TottalWeight]==1){
                System.out.println(n);
                TottalWeight =TottalWeight - (int)ArrayObjects[n].weight;
            }
        }
        System.out.println("Optimal solution is given by:" + DynamicTable[SIZE][M]);
    }

}
class KPobject{
    float weight;
    float profit;
    float value;
    void calculateValue(){
        this.value = this.profit/this.weight;
    }
}
/*
------Input------
4
5
1 15
2 20
2 10
1 12
 */

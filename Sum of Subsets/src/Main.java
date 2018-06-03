import java.util.Scanner;

public class Main {

    static int[] set;
    static int[] sO_o;
    static int SIZE;
    static int M;

    public static void main(String[] args) {
        System.out.println("Sum of SubSets");
        System.out.println("Enter the number elements in the set ");
        Scanner in = new Scanner(System.in);
        SIZE = in.nextInt();
        System.out.println("Enter the Sum CAP");
        M = in.nextInt();
        set = new int[SIZE+1];
        sO_o = new int[SIZE+1];
        System.out.println("Enter the elements of the set");
        int sum=0;
        for(int i=1;i<=SIZE;i++){
            set[i]= in.nextInt();
            sum=set[i]+sum;
        }

        SumofSet(0,0,sum);
    }
    public static void SumofSet(int i,int weight,int total){
        if(BoundingFunction(i,weight,total)){
            if(weight==M){
                for(int g=1;g<=SIZE;g++){
                    if(sO_o[g]==1){
                        System.out.print(set[g]);
                    }
                }
                System.out.println();
            }else{
                sO_o[i+1]=1;
                SumofSet(i+1,weight+set[i+1],total-set[i+1]);
                sO_o[i+1]=0;
                SumofSet(i+1,weight,total-set[i+1]);
            }
        }
    }
    public static Boolean BoundingFunction(int i,int weight,int total){
        return ((weight+total>=M)&&(weight==M||weight+set[i+1]<=M));
    }
}

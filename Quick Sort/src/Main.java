import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //int arr[] = {10, 7, 12, 9, 1, 5};
        //int n = arr.length;
        int arr[] = new int[100000];
        System.out.println("Enter the number of elements ");
        Scanner in = new Scanner(System.in);
        Random r  = new Random();
        int total = in.nextInt();
        for(int i=0;i<total;i++){
            int temp = r.nextInt(10000);
            arr[i]=temp;
        }
        long stime = System.nanoTime();
        QD(arr,0,total-1);
        long etime = System.nanoTime();
        System.out.println("Total number of elements is given by: " + total);
        for(int i=0;i<total;i++){
            System.out.println(arr[i]);
        }
        long totaltime = etime-stime;
        System.out.println((double)totaltime/1000000);
    }
    public static int partition(int[] Array,int start,int end){
        int pivot= Array[end];
        int pivotindex=start;
        for(int i = start;i<end;i++){
            if(pivot>=Array[i]){
                //swap
                swap(Array,pivotindex,i);
                pivotindex++;
            }
        }
        swap(Array,pivotindex,end);
        return pivotindex;
    }
    public static void swap(int[] Array,int pos1,int pos2){
        int temp = Array[pos1];
        Array[pos1] = Array[pos2];
        Array[pos2] = temp;
    }

    public static  void QD(int[] Array,int start,int end){
        if(start<end){
            int partitionIndex=partition(Array,start,end);
            QD(Array,start,partitionIndex-1);
            QD(Array,partitionIndex+1,end);
        }
    }
}

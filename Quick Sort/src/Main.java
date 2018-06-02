public class Main {

    public static void main(String[] args) {
        int arr[] = {10, 7, 12, 9, 1, 5};
        int n = arr.length;
        QD(arr,0,n-1);
        System.out.println("sorted array : ");
        for(int a:arr){
            System.out.println(a);
        }
    }
    public static int partition(int[] Array,int start,int end){
        int pivot= Array[end];
        int pivotindex=start;
        for(int i = start;i<end;i++){
            if(pivot>=Array[i]){
                //swap
                int temp = Array[pivotindex];
                Array[pivotindex]=Array[i];
                Array[i]=temp;
                pivotindex++;
            }
        }
        int temp = Array[pivotindex];
        Array[pivotindex]=Array[end];
        Array[end]=temp;
        return pivotindex;
    }

    public static  void QD(int[] Array,int start,int end){
        if(start<end){
            int partitionIndex=partition(Array,start,end);
            QD(Array,start,partitionIndex-1);
            QD(Array,partitionIndex+1,end);
        }
    }
}

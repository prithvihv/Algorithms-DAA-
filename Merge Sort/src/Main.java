import java.util.Scanner;

public class Main {

    static Scanner in;

    public static void main(String[] args) {
        System.out.println("-----Merge Sort-----");
        in = new Scanner(System.in);
        System.out.println("Enter number of elements :");
        int t = in.nextInt();
        int[] itemsToSort= new int[t];
        for(int i=0;i<t;i++){
            itemsToSort[i]= in.nextInt();
        }
        long starttime= System.nanoTime();
        mergeSort(itemsToSort,0,t-1);
        long stoptime = System.nanoTime();
        for(int i=0;i<t;i++){
            System.out.println(itemsToSort[i]);
        }
        System.out.println(starttime + " : " +stoptime);
    }



    public static void mergeSort(int[] unSortedArray,int low, int high){
        if(low<high){
            int mid = (low + high)/2;
            mergeSort(unSortedArray,low,mid);
            mergeSort(unSortedArray,mid+1,high);
            merge(unSortedArray,low,high,mid);
        }
    }


    public static void merge(int[] Array,int low ,int high,int mid){
        int l=low;
        int ll=low;
        int gg=mid+1;
        int[] temp=new int[high+1];
        int index=0;
        while(l<=mid&&gg<=high){
            if(Array[l]>Array[gg]){
                temp[index]=Array[l];
                index++;
                l++;
            }else {
                temp[index] = Array[gg];
                index++;
                gg++;
            }
        }
        if(l>mid){
            for(int i=gg;i<=high;i++){
                temp[index]=Array[i];
                index++;
            }
        }else{
            for(int i=l;i<=mid;i++){
                temp[index]=Array[i];
                index++;
            }
        }
        for(int i=0;i<index;i++){
            Array[ll]=temp[i];
            ll++;
        }
    }
}

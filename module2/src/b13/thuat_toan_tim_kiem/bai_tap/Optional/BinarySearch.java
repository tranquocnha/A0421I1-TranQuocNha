package b13.thuat_toan_tim_kiem.bai_tap.Optional;

public class BinarySearch {
    public int binarySearch(int array[],int x,int low,int high){
        if (high>=low){
            int mid=(high+low)/2;
            if (array[mid]==x){
                return mid;
            }else if (array[mid]>x){
                return binarySearch(array,x,low,mid-1);
            }else {
                return binarySearch(array,x,mid+1,high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binary=new BinarySearch();
        int[] array={2,3,4,5,6,7,8,9};
        int size=array.length;
        int x=9;
        System.out.println(binary.binarySearch(array,x,0,size-1));
    }
}

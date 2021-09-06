package b14.thuat_toan_sap_xep.bai_tap.InsertionSort;

public class InsertionSort {
    void sort(int array[]){
        int size=array.length;
        for (int i=1;i<size;i++){
            int key=array[i];
            int j=i-1;
            System.out.println("bat dau so sanh key "+key);
            while (j>=0&&array[j]>key){
                System.out.println("thay doi vi tri cua phan tu "+array[j+1]+" voi phan tu "+array[j]);
                array[j+1]=array[j];
                j=j-1;

            }
            array[j+1]=key;
        }
    }
    static void printArray(int[] array){
        int size=array.length;
        for (int i=0;i<size;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array={1,5,3,77,56,3,17,32,7,9};
        System.out.println("mang ban dau");
        printArray(array);
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.sort(array);
        System.out.println("mang sau khi sap xep");
        printArray(array);
    }
}

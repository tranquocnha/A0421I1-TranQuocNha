package b14.thuat_toan_sap_xep.bai_tap.SetUpInsertionSort;

public class SetUpInsertionSort {
    void sortArray(int array[]) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;

            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        SetUpInsertionSort setUpInsertionSort = new SetUpInsertionSort();
        int[] array = {2, 5, 4, 33, 1, 7, 6, 4, 88, 34};
        System.out.println("mang truoc khi sap xep");
        for (int element : array
        ) {
            System.out.printf("%d ",element);
        }
        System.out.println();
        setUpInsertionSort.sortArray(array);
        System.out.println("sau khi da sap xep");
        for (int element : array
        ) {
            System.out.printf("%d ",element);
        }
    }
}

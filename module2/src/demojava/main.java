package demojava;

public class main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,15};
        int[] arr1 = {2,9,6,8};
//        for(int i=0,j=arr1.length-1;i<arr1.length/2;i++,j--){
//            int temp = arr1[i]+arr1[j];
//            int max = temp;
//            System.out.println("bằng nhau "+max);
//        }
//        int max =0;
//        int max2=0;
//        for(int i=0;i<arr1.length;i++){
//            if(arr1[i]>max){
//                max2=max;
//                max=arr1[i];
//            }else if(arr1[i]>max2){
//                max2=arr1[i];
//            }
//        }
//        System.out.println(max +":" +max2);

        int temp=0;
        for(int i=0,j=arr.length-1;i<arr.length/2;i++,j--){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}

package b10.DSA_danh_sach.bai_tap.ArrayListMethod;

public class MainMyList {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);
        myList.add(3, 4);
        myList.remove(1);
        myList.remove(2);
        System.out.println(myList.getSize());
        System.out.println(myList.get(1));
        System.out.println(myList.contains(3));
        System.out.println(myList.indexOf(3));
        System.out.println(myList.add(3));

        System.out.println("///////");
        MyList<Integer> myClone = myList.clone();
        myClone.add(0, 1);
        myClone.add(1, 2);
        myClone.add(2, 3);
        myClone.add(3, 4);
        System.out.println(myClone.get(2));
    }
}

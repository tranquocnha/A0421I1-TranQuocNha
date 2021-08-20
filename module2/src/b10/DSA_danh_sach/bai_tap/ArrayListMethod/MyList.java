package b10.DSA_danh_sach.bai_tap.ArrayListMethod;

import java.util.ArrayList;
import java.util.Arrays;


public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 0;
    Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity(int minCapacity) throws IllegalAccessException {
        if (minCapacity >= 0) {
            elements = Arrays.copyOf(elements, minCapacity);
        } else {
             throw new IllegalAccessException("Mincapacity:" + minCapacity);
        }
    }

    public void add(int index, E element) throws IllegalAccessException {
        if (index >=size || index<0) {
            throw new ArrayIndexOutOfBoundsException("Index "+ index + " don't corrent");
        }
        if(size== elements.length){
            ensureCapacity(elements.length *2 );
        }
        for (int temp = size; index < temp; temp--) {
            elements[temp] = elements[temp - 1];
        }
        elements[index] = element;
        size++;

    }

    //    public void add(int index, E element) {
//        size = elements.length;
//
//        if (index > elements.length) {
//            try {
//                throw new IllegalAccessException("index :" + index);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } else if (elements.length == size) {
//            ensureCapacity(size);
//        }
//        if(elements[index]==null){
//            elements[index] = element;
//            size++;
//        }else if (index < size) {
//            for (int temp = size; index < temp; temp--) {
//                elements[temp] = elements[temp - 1];
//            }
//            elements[index] = element;
//            elements[size++] = element;
//        }
//    }
    public E remove(int index) throws IllegalAccessException {
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        int sizeArray = elements.length;
        ensureCapacity(sizeArray--);
        return (E) elements;
    }

    public int getSize() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> newlist = new MyList<>(elements.length);
        newlist.elements = Arrays.copyOf(elements,size);
        newlist.size = size;
        return newlist;
    }

    public boolean contains(E element) {
        int sizeCurent = elements.length;
        if (sizeCurent == 0) {
            return false;
        } else {
            for (int i = 0; i < sizeCurent; i++) {
                if (elements[i] == element) {
                    return true;
                }
            }
        }

        return false;
    }


    public int indexOf(E element) {
        int sizeCurent = elements.length;
        if (sizeCurent == 0) {
            return -1;
        } else {
            for (int i = 0; i < sizeCurent; i++) {
                if (elements[i] == element) {
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean add(E element) throws IllegalAccessException {

        if (!contains(element)) {
            ensureCapacity(elements.length+1);
            elements[size++] = element;
            return true;
        }
        return false;
    }

    public E get(int index) {
        if(index>=size ||index<0){
            throw new ArrayIndexOutOfBoundsException("Index "+ index + " don't corrent");
        }
        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}

package b10.DSA_danh_sach.bai_tap.ArrayListMethod;

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

    private void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }

    public void add(int index, E element) {
        size = elements.length;
        ensureCapacity(size + 1);
        if (index < size) {
            for (int temp = size; index < temp; temp--) {
                elements[temp] = elements[temp - 1];
            }
            elements[index] = element;
            elements[size++] = element;
        }
    }

    public E remove(int index) {
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        int sizeArray = elements.length;
        ensureCapacity(sizeArray--);
        return (E) elements;
    }

    public int getSize() {
        return elements.length;
    }

    public MyList<E> clone() {
        return this;
    }

    public boolean contains(E o) {
        int sizeCurent = elements.length;
        if (sizeCurent == 0) {
            return false;
        } else {
            for (int i = 0; i < sizeCurent; i++) {
                if (elements[i] == o) {
                    return true;
                }
            }
        }

        return false;
    }


    public int indexOf(E o) {
        int sizeCurent = elements.length;
        if (sizeCurent == 0) {
            return -1;
        } else {
            for (int i = 0; i < sizeCurent; i++) {
                if (elements[i] == o) {
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean add(E e) {
        int sizeCurent = elements.length;
        if (!contains(e)) {
            ensureCapacity(sizeCurent + 1);
            elements[sizeCurent++] = e;
            return true;
        }
        return false;
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}

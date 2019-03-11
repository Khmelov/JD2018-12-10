package by.it.titkovskaya.jd01.jd01_11;
/*
TaskA. Свой ListA. Напишите класс ListA<T>, который реализует 3 метода
add(T e), remove(int index), get(int index) из интерфейса List<T> (реализация остальных –
фиктивная) и плюс к этому реализует toString() как в ArrayList.
 */

import java.util.*;

class ListA<E> implements List<E> {

    private E[] elements = (E[]) new Object[0];
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements,elements.length*3/2+1);
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
        size++;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E remove(int index) {
        E ret = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return ret;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
            return true;
        } else
            return false;
    }

    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null)
                    return i;
            }
        }
        else
            for (int i = 0; i < size; i++) {
            if (elements[i].equals(o))
                return i;
            }
        return -1;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            out.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }

    //=====================================================================================================
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

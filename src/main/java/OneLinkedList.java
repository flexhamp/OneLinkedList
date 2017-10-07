import java.util.*;

/**
 * Created by Admin on 06.10.2017.
 */
public class OneLinkedList<T> implements List<T> {
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <K> K[] toArray(K[] a) {
        return null;
    }

    public boolean add(T t) {
        size++;
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public T get(int index) {
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {

    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class Box<T> {
        Box<T> next;
        T data;

        public Box(Box<T> next, T data) {
            this.next = next;
            this.data = data;
        }
    }
}

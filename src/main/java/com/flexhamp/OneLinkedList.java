package com.flexhamp;

import java.lang.reflect.Array;
import java.util.*;

/**
 * One-linked list implementation of the {@code List}
 * elements (including {@code null}).
 * <p>
 * <p>All of the operations perform as could be expected for a one-linked list.</p>
 * <p><strong>Note that this implementation is not synchronized.</strong>
 *
 * @param <T> the type of elements held in this collection
 * @author Kuzmenko Nikita
 */


public class OneLinkedList<T> implements List<T> {
    private int size;
    private Box<T> head;
    private Box<T> tail;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (T find : this) {
            if (o.equals(find)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new Iterator() {
            private Box<T> current = null;

            public boolean hasNext() {
                if (current == null) {
                    return head != null;
                } else {
                    return current.next != null;
                }
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (current == null) {
                    return (current = head).data;
                } else {
                    return (current = current.next).data;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Object[] toArray() {
        Object[] objects = new Object[size];
        int i = 0;

        for (T t : this) {
            objects[i++] = t;
        }
        return objects;
    }

    public <K> K[] toArray(K[] a) {
        if (a.length < size) {
            a = (K[])Array.newInstance(a.getClass().getComponentType(), size);
        }
        Object[] aArray = a;
        int i = 0;

        for (T t : this) {
            aArray[i++] = t;
        }
        return a;
    }

    public boolean add(T t) {
        Box<T> tBox = new Box<T>(null, t);
        if (head == null || tail == null) {
            if (head != tail) {
                throw new IllegalStateException();
            }
            head = tail = tBox;
        } else {
            tail = tail.next = tBox;
        }
        size++;
        return true;
    }

    public boolean remove(Object o) {
        Box<T> findBox = head;
        Box<T> tmpBox = new Box<>(null, null);
        for (int i = 0; i < this.size(); i++) {
            if (o.equals(findBox.data)) {
                tmpBox.next = findBox.next;
                size--;
                return true;
            }
            tmpBox = findBox;
            findBox = findBox.next;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (c.size() == 0) {
            return false;
        }
        Box<T> oldHead = head;
        Box<T> boxElement;

        if (index != 0) {
            Box<T> box = head;
            for (int i = 0; i < index - 1; i++) {
                box = box.next;
            }
            oldHead = box.next;
            Iterator<? extends T> iterator = c.iterator();
            box.next = boxElement = new Box<>(null, iterator.next());
            size++;

            while (iterator.hasNext()) {
                boxElement.next = new Box<>(null, iterator.next());
                boxElement = boxElement.next;
                size++;
            }
            boxElement.next = oldHead;
        } else {
            Iterator<? extends T> iterator = c.iterator();
            boxElement = new Box<>(null, iterator.next());
            size++;
            head = boxElement;
            while (iterator.hasNext()) {
                boxElement.next = new Box<>(null, iterator.next());
                boxElement = boxElement.next;
                size++;
            }
            boxElement.next = oldHead;
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Box<T> box = head;
        for (int i = 0; i < index; i++) {
            box = box.next;
        }
        return box.data;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Box<T> box = head;
        Box<T> tmpBox = new Box<>(null, null);
        for (int i = 0; i < index; i++) {
            box = box.next;
        }
        tmpBox.data = box.data;
        box.data = element;
        return tmpBox.data;
    }

    public void add(int index, T element) {
        Box<T> boxElement = new Box<>(null, element);
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index != 0) {
            Box<T> box = head;
            for (int i = 0; i < index - 1; i++) {
                box = box.next;
            }
            boxElement.next = box.next.next;
            box.next = boxElement;
            size++;
        } else {
            boxElement.next = head;
            head = boxElement;
            size++;
        }
    }

    public T remove(int index) {
        Box<T> box = head;
        for (int i = 0; i < index - 1; i++) {
            box = box.next;
        }
        Box<T> tmpBox = box.next;
        box.next = box.next.next;
        size--;
        return tmpBox.data;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (T find : this) {
            if (o.equals(find)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = 0;
        int indexLast = -1;
        for (T find : this) {
            if (o.equals(find)) {
                indexLast = index;
            }
            index++;
        }
        return indexLast;
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private void swap(Box<T> first, Box<T> second) {
        if (first == null) {
            tail = second;
        }
        if (second.next != null) {
            swap(second, second.next);
        } else {
            head = second;
        }
        second.next = first;
    }

    /**
     * Данный метод преобразует список N1->N2->N3->...->Nn в Nn->Nn-1->Nn-2->...->N1
     */
    public void reverse() {
        swap(null, head);
    }

    private static class Box<T> {
        Box<T> next;
        T data;

        public Box(Box<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "next=" + next +
                    ", data=" + data +
                    '}';
        }
    }
}

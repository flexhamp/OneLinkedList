package com.flexhamp;

import java.util.*;

/**
 * Created by Admin on 06.10.2017.
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
        for (Object find: this){
            if(o.equals(find)) {
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
        return new Object[0];
    }

    public <K> K[] toArray(K[] a) {
        return null;
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
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        for (T t : c) {
            this.add(t);
            size++;
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

            while (iterator.hasNext()) {
                boxElement.next = new Box<>(null, iterator.next());
                boxElement = boxElement.next;
                size++;
            }
            boxElement.next = oldHead;
        } else {
            Iterator<? extends T> iterator = c.iterator();
            boxElement = new Box<>(null, iterator.next());
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
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
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
        return null;
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

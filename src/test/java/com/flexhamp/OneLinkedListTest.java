package com.flexhamp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Admin on 07.10.2017.
 */
public class OneLinkedListTest {

    @Test
    public void testAdd() throws Exception {
        List<String> list = new OneLinkedList<>();
        list.add("Hello");
        list.add("World");
        Assert.assertEquals(2, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIterator() throws Exception {
        List<String> list = new OneLinkedList<>();
        Iterator<String> iterator = list.iterator();
        Assert.assertTrue(!iterator.hasNext());
        list.add("Hello");
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("Hello", iterator.next());
        Assert.assertTrue(!iterator.hasNext());
        iterator.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertEquals(0, list.get(0).intValue());
        Assert.assertEquals(9, list.get(9).intValue());

        //Ожидаем IndexOutOfBoundsException
        Assert.assertEquals(9, list.get(10).intValue());
    }

    @Test
    public void testReverse() throws Exception {
        OneLinkedList<String> list = new OneLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");

        OneLinkedList<String> list1 = new OneLinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("f");

        list.reverse();

        for(int i=0; i<list.size(); i++) {
            Assert.assertEquals(list1.get(i), list.get(list.size()-i-1));
        }
    }

    @Test
    public void testAddAll() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        List<Integer> list1 = new OneLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Assert.assertTrue(list1.addAll(list));

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list1.get(i), list.get(i));
        }
    }
}
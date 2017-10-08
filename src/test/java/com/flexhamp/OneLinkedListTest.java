package com.flexhamp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Admin on 07.10.2017.
 */
public class OneLinkedListTest {

    @Test
    public void testAdd() throws Exception {
        List<String> list = new OneLinkedList<>();

        Assert.assertEquals(0, list.size());

        Assert.assertTrue(list.add("Hello"));

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

        //Ожидаем NoSuchElementException
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

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list1.get(i), list.get(list.size() - i - 1));
        }

        Assert.assertEquals(list1.size(), list.size());
    }

    @Test
    public void testAddAll() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        List<Integer> list1 = new OneLinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Assert.assertEquals(100, list.size());
        Assert.assertEquals(0, list1.size());

        Assert.assertTrue(list1.addAll(list));

        Assert.assertEquals(100, list1.size());

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list1.get(i), list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testClear() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Assert.assertEquals(0, list.get(0).intValue());

        Assert.assertEquals(100, list.size());

        list.clear();

        Assert.assertEquals(0, list.size());

        Assert.assertTrue(list.isEmpty());

        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsert() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.add(0, 99);
        Assert.assertEquals(101, list.size());
        Assert.assertEquals(99, list.get(0).intValue());
        list.add(15, 124);
        Assert.assertEquals(102, list.size());
        Assert.assertEquals(124, list.get(15).intValue());

        //Ожидаем IndexOutOfBoundsException
        list.add(-1, 94);
    }

    @Test
    public void testInsetAll() throws Exception {
        List<Integer> list = new OneLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Assert.assertEquals(5, list.size());

        List<Integer> list1 = new OneLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list1.add(100 + i);
        }

        Assert.assertEquals(100, list1.size());

        list.addAll(3, list1);

        System.out.println(list.size());

        Assert.assertEquals(105, list.size());

        Assert.assertEquals(2, list.get(2).intValue());

        Assert.assertEquals(100, list.get(3).intValue());
    }

    @Test
    public void testRemoveObject() throws Exception {
        List<String> list = new OneLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Assert.assertEquals(6, list.size());

        Assert.assertTrue(list.remove("d"));

        Assert.assertEquals("e", list.get(3));

        Assert.assertTrue(!list.remove("h"));

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void testRemoveIndex() throws Exception {
        List<String> list = new OneLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Assert.assertEquals(6, list.size());

        Assert.assertEquals("d", list.remove(3));

        Assert.assertEquals("e", list.get(3));

        Assert.assertEquals(5, list.size());

        //list.remove(8);
    }

    @Test
    public void testSet() throws Exception {
        List<String> list = new OneLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("f");

        Assert.assertEquals("b", list.set(1, "g"));
        Assert.assertEquals("g", list.get(1));
    }

    @Test
    public void testIndexOf() throws Exception {
        List<String> list = new OneLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("d");
        list.add("e");
        list.add("a");
        list.add("f");

        Assert.assertEquals(1, list.indexOf("b"));

        Assert.assertEquals(5, list.lastIndexOf("a"));
    }
}
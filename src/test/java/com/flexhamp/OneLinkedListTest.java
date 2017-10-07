package com.flexhamp;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(0, list.get(9).intValue());
        Assert.assertEquals(9, list.get(10).intValue());
    }
}
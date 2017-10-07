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
}
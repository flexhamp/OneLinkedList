package com.flexhamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 13.10.2017.
 */
public class OneLinkedSubListTest {
    private List list = new OneLinkedList();

    @Before
    public void setUpList() {
        for (int i = 0; i < 20; i++) {
            list.add("a" + i);
        }
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(list.subList(1, 9).contains("a1"));

        Assert.assertTrue(list.subList(1, 9).contains("a8"));

        Assert.assertTrue(!list.subList(1, 9).contains("a0"));

        Assert.assertTrue(!list.subList(1, 9).contains("a9"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator() throws Exception {

        Iterator iteratorList = list.iterator();
        List list1 = list.subList(0, 9);
        Iterator iterator = list1.iterator();

        while (iterator.hasNext()) {
            Assert.assertEquals(iterator.next(), iteratorList.next());
        }

        Assert.assertEquals(9, list1.size());

        list.add("b1");
        //Ожидаем ConcurrentModificationException
        list1.size();
    }

    @Test
    public void testToArray() throws Exception {

        List list1 = list.subList(0, 9);
        Object[] array = list.subList(0, 9).toArray();

        Assert.assertEquals(9, array.length);
        Assert.assertEquals(array.length, list1.size());

        int i = 0;
        for (Object o : list1) {
            Assert.assertEquals(o, array[i]);
            i++;
        }
    }

    @Test
    public void testToArrayK() throws Exception {

        List list1 = list.subList(0, 17);
        String[] stringArray = new String[15];

        stringArray = (String[]) list.subList(0, 17).toArray(stringArray);
        Assert.assertEquals(17, stringArray.length);

        Assert.assertEquals(stringArray.length, list1.size());
        int i = 0;
        for (Object o : list1) {
            Assert.assertEquals(o, stringArray[i]);
            i++;
        }
    }

    @Test
    public void testClear() throws Exception {
        list.subList(0, 9).clear();

        Assert.assertEquals(11, list.size());

        Assert.assertEquals("a9", list.get(0));

        Assert.assertEquals("a19", list.get(10));

        list.subList(1, 5).clear();
        Assert.assertEquals(7, list.size());

        list.subList(2, 4).clear();
        Assert.assertEquals(5, list.size());

        list.subList(0, 5).clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testSubList() throws Exception {

        List list1 = list.subList(1, 10).subList(1, 7).subList(0, 6).subList(1, 3).subList(0, 1);
        Assert.assertEquals(1, list1.size());
        Assert.assertEquals("a3", list1.get(0));

        list1.clear();

        Assert.assertEquals("a4", list.get(3));

        //Ожидаем ConcurrentModificationException
        list1.size();
    }
}

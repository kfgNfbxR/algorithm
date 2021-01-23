package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author mouxh 2021/1/23 12:17
 */
public class MockLinkedListTest {

    @Test
    public void testAdd() {
        MockLinkedList<Integer> integers = new MockLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}

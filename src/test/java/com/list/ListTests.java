package com.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListTests {
    @Test
    void testAddAndGet() {
        List<String> list = new ArrayList<>();

        // TODO: list에 "apple", "banana", "cherry"를 순서대로 추가하라.
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        assertEquals(3, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("cherry", list.get(2));
    }

    @Test
    void testSet() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));

        // TODO: 인덱스 1의 값을 99로 변경하라.
        list.set(1, 99);

        assertEquals(99, list.get(1));
    }

    @Test
    void testRemove() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "two"));

        // TODO: list에서 첫 번째 "two" 값을 삭제하라.
        list.remove("two");

        assertEquals(3, list.size());
        // 첫번째 삭제 후 "two"가 다시 리스트에 남아 있어야 함
        assertEquals("two", list.get(2));
    }

    @Test
    void testContains() {
        List<String> list = new ArrayList<>(Arrays.asList("red", "green", "blue"));

        // TODO: list에 "green"이 포함되어 있는지 검증하라.
        boolean contains = list.contains("green");

        assertTrue(contains);
    }

    @Test
    void testIndexOfAndLastIndexOf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 7, 3, 9));

        // TODO: list에서 숫자 3의 첫번째 인덱스와 마지막 인덱스를 각각 구하라.
        int firstIndex = list.indexOf(3);
        int lastIndex = list.lastIndexOf(3);

        // 첫번째 3은 인덱스 1, 마지막 3은 인덱스 3
        assertEquals(1, firstIndex);
        assertEquals(3, lastIndex);
    }

    @Test
    void testClear() {
        List<String> list = new ArrayList<>(Arrays.asList("dog", "cat", "bird"));

        // TODO: list의 모든 요소를 제거하라.
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    void testSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(42, 7, 19, 34, 7));

        // TODO: list를 오름차순으로 정렬하라.
        Collections.sort(list);

        List<Integer> expected = Arrays.asList(7, 7, 19, 34, 42);
        assertEquals(expected, list);
    }

    @Test
    void testSubList() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // TODO: list에서 인덱스 1부터 4 미만까지의 서브리스트를 추출하라.
        List<String> subList = list.subList(1, 4);

        List<String> expected = Arrays.asList("b", "c", "d");
        assertEquals(expected, subList);
    }

    @Test
    void testToArray() {
        List<String> list = new ArrayList<>(Arrays.asList("x", "y", "z"));

        // TODO: list를 배열로 변환하라.
        String[] array = list.toArray(new String[0]);

        String[] expected = {"x", "y", "z"};
        assertArrayEquals(expected, array);
    }
}
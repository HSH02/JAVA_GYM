package com.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class arrayTest {


    @Test
    void testArraysSort() {
        // Display: Arrays.sort() 테스트
        int[] input = new int[]{3, 2, 1};
        int[] answer = new int[]{1, 2, 3};
        Arrays.sort(input);

        assertArrayEquals(answer, input);
    }

    @Test
    void testArraysBinarySearch() {
        // Display: Arrays.binarySearch() 테스트
        int[] input = new int[]{3, 2, 1};
        Arrays.sort(input);

        int index = Arrays.binarySearch(input, 3);
        assertEquals(2, index);
    }

    @Test
    void testArraysToString() {
        // Display: Arrays.toString() 테스트
        String[] strArr = new String[]{"Hello ", "World!"};

        String str = Arrays.toString(strArr);

        assertEquals("[Hello , World!]", str);
    }

    @Test
    void testArraysCopyOf() {
        // Display: Arrays.copyOf() 테스트
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr, 5);

        assertArrayEquals(arr, arr2);

        int[] arr3 = Arrays.copyOfRange(arr, 0, 2);

        assertArrayEquals(new int[]{1, 2}, arr3);
    }

    @Test
    void testArraysEquals() {
        // Display: Arrays.equals() 테스트
        boolean[] arr = new boolean[]{true};
        boolean[] arr2 = new boolean[]{true};

        boolean result = Arrays.equals(arr, arr2);

        assertTrue(result);
    }

    @Test
    void testArraysFill() {
        // Display: Arrays.fill() 테스트

        int[] arr = new int[5];
        Arrays.fill(arr, 10);

        assertEquals(10, arr[4]);
    }

    @Test
    void testArraysAsList() {
        // Display: Arrays.asList() 테스트
        int[] arr = new int[5];
        Arrays.fill(arr, (int) (Math.random() * 5) + 1);

        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .toList();


        System.out.println("list = " + list);
    }

    @Test
    void testDeepToString() {
        // 중첩 배열의 문자열 변환을 테스트합니다.
        int[][] matrix = {{1, 2}, {3, 4}};
        String expected = "[[1, 2], [3, 4]]";
        String actual = Arrays.deepToString(matrix);
        assertEquals(expected, actual);
    }

    @Test
    void testDeepEquals() {
        // 중첩 배열의 동일 여부를 테스트합니다.
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2}, {3, 4}};
        int[][] arr3 = {{1, 2}, {4, 3}};

        // 동일한 경우
        assertTrue(Arrays.deepEquals(arr1, arr2));
        // 다른 경우
        assertFalse(Arrays.deepEquals(arr1, arr3));
    }

    @Test
    void testHashCodes() {
        // 단일 배열의 hashCode 테스트
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        assertEquals(Arrays.hashCode(arr1), Arrays.hashCode(arr2));

        // 중첩 배열의 deepHashCode 테스트
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        assertEquals(Arrays.deepHashCode(matrix1), Arrays.deepHashCode(matrix2));
    }

    @Test
    void testMismatch() {
        // 두 배열에서 일치하지 않는 첫 번째 인덱스를 찾는 mismatch() 메서드 테스트
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 5, 3, 4};
        int expectedMismatchIndex = 1;  // 인덱스 1에서 차이가 있음.
        int actualMismatchIndex = Arrays.mismatch(a, b);
        assertEquals(expectedMismatchIndex, actualMismatchIndex);

        // 완전히 동일한 경우 -1 반환
        int[] c = {1, 2, 3};
        int[] d = {1, 2, 3};
        assertEquals(-1, Arrays.mismatch(c, d));
    }

    @Test
    void testSetAll() {
        // setAll()을 사용하여 각 인덱스에 값을 설정하는 테스트
        int[] arr = new int[5];
        // 각 인덱스에 index * 3의 값을 할당 (예: 0, 3, 6, 9, 12)
        Arrays.setAll(arr, index -> index * 3);
        int[] expected = {0, 3, 6, 9, 12};
        assertArrayEquals(expected, arr);
    }

}


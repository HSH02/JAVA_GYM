package com.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class arraysTest2 {

    @Test
    void testArraysSort() {
        int[] input = {5, 3, 8, 1, 9};
        int[] expected = {1, 3, 5, 8, 9};

        // TODO: Arrays.sort를 사용하여 input 배열을 오름차순 정렬하라.
        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testArraysBinarySearch() {
        int[] input = {12, 5, 7, 3, 9};

        // TODO: 먼저 input 배열을 정렬한 후, 특정 값(예: 7)의 인덱스를 구하는 코드를 작성하라.
        Arrays.sort(input);
        int index = Arrays.binarySearch(input, 7);

        // 정렬된 배열: {3, 5, 7, 9, 12}
        // 값 7의 인덱스는 2
        assertEquals(2, index);
    }

    @Test
    void testArraysToString() {
        String[] input = {"Java", "Arrays", "Test"};

        // TODO: Arrays.toString()을 사용해서 문자열로 변환한 후 결과를 비교하라.
        String result = Arrays.toString(input);

        String expected = "[Java, Arrays, Test]";
        assertEquals(expected, result);
    }

    @Test
    void testArraysCopy() {
        int[] original = {10, 20, 30, 40, 50};

        // TODO: Arrays.copyOf를 사용하여 original 배열을 복사한 후, 복사본이 동일한지 검증하라.
        int[] copy = Arrays.copyOf(original, original.length);
        assertArrayEquals(original, copy);

        // TODO: Arrays.copyOfRange를 사용하여 index 1부터 4 직전까지 복사한 결과를 검증하라.
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 4);
        int[] expectedRange = {20, 30, 40};
        assertArrayEquals(expectedRange, rangeCopy);
    }

    @Test
    void testArraysEquals() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 5};

        // TODO: Arrays.equals()를 사용하여 arr1과 arr2는 같고, arr1과 arr3는 다름을 검증하라.
        boolean result1 = Arrays.equals(arr1, arr2);
        boolean result2 = Arrays.equals(arr1, arr3);

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void testArraysFill() {
        int[] arr = new int[5];

        // TODO: Arrays.fill()을 사용하여 arr 배열의 모든 요소에 100을 채워 넣으라.
        Arrays.fill(arr, 100);

        for (int value : arr) {
            assertEquals(100, value);
        }
    }

    @Test
    void testArraysAsList() {
        String[] arr = {"a", "b", "c"};

        // TODO: Arrays.asList() 혹은 스트림을 사용하여 배열을 List로 변환한 후, 결과 List를 검증하라.
        List<String> list = Arrays.asList(arr);

        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, list);
    }

    @Test
    void testArraysDeepToString() {
        int[][] matrix = {{1, 2}, {3, 4}};

        // TODO: Arrays.deepToString()을 사용하여 2차원 배열의 문자열 표현을 얻은 후 검증하라.
        String result = Arrays.deepToString(matrix);

        String expected = "[[1, 2], [3, 4]]";
        assertEquals(expected, result);
    }

    @Test
    void testArraysDeepEquals() {
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2}, {3, 4}};
        int[][] arr3 = {{1, 2}, {4, 3}};

        // TODO: Arrays.deepEquals()를 사용하여 arr1과 arr2는 같고, arr1과 arr3는 다름을 검증하라.
        boolean deepEqual1 = Arrays.deepEquals(arr1, arr2);
        boolean deepEqual2 = Arrays.deepEquals(arr1, arr3);

        assertTrue(deepEqual1);
        assertFalse(deepEqual2);
    }

    @Test
    void testArraysHashCodes() {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {2, 4, 6};

        // TODO: Arrays.hashCode()를 사용하여 두 배열의 해시코드가 동일함을 검증하라.
        int hash1 = Arrays.hashCode(arr1);
        int hash2 = Arrays.hashCode(arr2);

        assertEquals(hash1, hash2);

        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};

        // TODO: Arrays.deepHashCode()를 사용하여 두 2차원 배열의 해시코드가 동일함을 검증하라.
        int deepHash1 = Arrays.deepHashCode(matrix1);
        int deepHash2 = Arrays.deepHashCode(matrix2);

        assertEquals(deepHash1, deepHash2);
    }

    @Test
    void testArraysMismatch() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 99, 3, 4};

        // TODO: Arrays.mismatch()를 사용하여 a와 b에서 첫 번째 다른 인덱스를 구하라.
        int mismatchIndex = Arrays.mismatch(a, b);

        // a와 b의 첫번째 다른 인덱스는 1이다.
        assertEquals(1, mismatchIndex);

        int[] c = {5, 6, 7};
        int[] d = {5, 6, 7};

        // TODO: Arrays.mismatch()를 사용하여 c와 d가 모두 동일함을 확인하라.
        int mismatchSame = Arrays.mismatch(c, d);
        assertEquals(-1, mismatchSame);
    }

    @Test
    void testArraysSetAll() {
        int[] arr = new int[5];

        // TODO: Arrays.setAll()을 사용하여 각 인덱스에 index * 2의 값을 할당하라.
        Arrays.setAll(arr, index -> index * 2);

        int[] expected = {0, 2, 4, 6, 8};
        assertArrayEquals(expected, arr);
    }
}
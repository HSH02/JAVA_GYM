package com;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAllAssertions() {
        // 기본 연산 및 기본 assert 검증
        int a = 1 + 4;
        assertEquals(5, a, "1과 4를 더하면 5가 되어야 합니다.");
        assertNotEquals(6, a, "1과 4를 더한 결과는 6이 아니어야 합니다.");
        assertTrue(true, "true 상태를 검증합니다.");
        assertFalse(false, "false 상태를 검증합니다.");
        assertNull(null, "null인 것을 검증합니다.");
        assertNotNull(a, "null이 아님을 검증합니다.");

        // 객체 및 배열 관련 검증
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertEquals(obj1, obj2, "동일한 인스턴스를 참조해야 합니다.");
        assertNotSame(obj1, a, "서로 다른 객체임을 확인합니다.");
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = arr1;
        assertArrayEquals(arr1, arr2, "배열의 내용이 동일해야 합니다.");

        // 예외 관련 검증
        // 1. fail 메서드는 호출 시 즉시 AssertionError를 발생시킵니다.
        assertThrows(AssertionError.class, () -> {
            fail("강제로 실패");
        }, "fail 메서드는 AssertionError를 발생시켜야 합니다.");

        // 2. 지정한 예외가 발생하는지 검증 (assertThrows)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("예외 발생");
        }, "IllegalArgumentException이 발생해야 합니다.");
        assertEquals("예외 발생", thrown.getMessage(), "예외 메시지가 일치해야 합니다.");

        // 3. 정확히 지정한 예외 클래스가 발생하는지 검증 (assertThrowsExactly)
        IllegalArgumentException thrownExact = assertThrowsExactly(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("정확한 예외 발생");
        }, "정확한 예외가 발생해야 합니다.");
        assertEquals("정확한 예외 발생", thrownExact.getMessage(), "예외 메시지가 일치해야 합니다.");

        // 시간 제한 검증
        // 지정 시간 내에 실행이 완료되는지 (assertTimeout)
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50); // 100ms보다 짧은 시간 대기
        }, "100ms 내에 실행되어야 합니다.");

        // 지정 시간 내에 실행이 완료되지 않으면 강제 중단 (assertTimeoutPreemptively)
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
        }, "100ms 내에 실행되어야 합니다.");

        // 타입 검증
        Object number = Integer.valueOf(10);
        Integer result = assertInstanceOf(Integer.class, number, "객체가 Integer 타입이어야 합니다.");
        assertEquals(10, result, "정확한 값이어야 합니다.");

        // 여러 어서션을 하나의 그룹으로 묶어서 실행 (assertAll)
        assertAll("여러 어서션 검증",
                () -> assertEquals(2, 1 + 1, "덧셈 결과가 2여야 합니다."),
                () -> assertTrue("hello".startsWith("h"), "문자열은 'h'로 시작해야 합니다.")
        );

        // Iterable 및 문자열 라인 검증
        List<String> expectedList = Arrays.asList("a", "b", "c");
        List<String> actualList = Arrays.asList("a", "b", "c");
        assertIterableEquals(expectedList, actualList, "리스트의 내용이 일치해야 합니다.");

        List<String> expectedLines = Arrays.asList("Hello", "World");
        List<String> actualLines = Arrays.asList("Hello", "World");
        assertLinesMatch(expectedLines, actualLines, "각 줄이 일치해야 합니다.");

        // Supplier<String> 사용 예 (메시지는 조건 실패 시에만 평가됨)
        assertTrue(3 > 2, () -> "이 메시지는 조건이 false일 때만 평가됩니다.");

        // 예외가 발생하지 않아야 하는지 검증 (assertDoesNotThrow)
        assertDoesNotThrow(() -> {
            int b = 10;
        }, "예외 없이 정상적으로 실행되어야 합니다.");
    }
}
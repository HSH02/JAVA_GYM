package com.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class strTest {

    String abc = "abc";
    String blank = "";

//    @BeforeEach
//    void setUp() {
//
//    }

    @Test
    void lengthTest() {
        assertEquals(blank.length(), 0);
    }

    @Test
    void isEmptyTest() {
        String a = "";
        assertEquals(blank.isEmpty(), a.isEmpty());
    }

    @Test
    void charAtTest() {
        assertEquals(abc.charAt(0), 'a');
    }

    @Test
    void codePointAtTest() {
        String text = "ABCDabcd, 1234678910";
        for (int i = 0; i < text.length(); ) {
            int cp = text.codePointAt(i);
            // cp에 대해 원하는 처리 수행
            System.out.printf("코드 포인트: %X%n", cp);
            // 보조 평면 문자인 경우, 두 개의 char가 사용됨.
            i += Character.charCount(cp);
        }
    }

    @Test
    void getCharsTest() {
        String str = "Hello World!";
        char[] buffer = new char[6];
        str.getChars(0, 5, buffer, 1);
        for (int i = 0; i < buffer.length; i++) {
            System.out.println("buffer[i] = " + buffer[i]);
        }
    }

    @Test
    void getCharsTest2() {
        String str = "Hello World!";
        char[] buffer = new char[7];
        str.getChars(6, str.length(), buffer, 1);
        for (int i = 0; i < buffer.length; i++) {
            System.out.println("buffer[i] = " + buffer[i]);
        }
    }

    @Test
    void contentEqualsTest() {
        String str = "Hello, World!";
        StringBuilder sb = new StringBuilder("Hello, World!");

        boolean result = str.contentEquals(sb); // 결과: true
        assertTrue(result);
    }

    @Test
    void contentEqualsTest2() {
        String str = "ABC";
        StringBuilder sb = new StringBuilder("ABC");

        boolean result = str.contentEquals(sb); // 결과: true
        assertTrue(result);
    }

    @Test
    void contentEqualsTest3() {
        String str = "123";
        StringBuilder sb = new StringBuilder("123");

        boolean result = str.contentEquals(sb);
        assertTrue(result);
    }

    @Test
    void equalsIgnoreCaseTest1() {
        String ABC = "ABC";

        boolean result = ABC.equalsIgnoreCase(abc);

        assertTrue(result);
    }

    @Test
    void equalsIgnoreCaseTest2() {
        String Hello = "Hello";
        String hello = "hello";

        boolean result = Hello.equalsIgnoreCase(hello);

        assertTrue(result);
    }

    @Test
    void compareToTest() {
        String Alice = "Alice";
        String Bob = "Bob";

        boolean result = Alice.compareTo(Bob) == -1;

        assertTrue(result);
    }

    @Test
    void regionMatchesTest() {
        String str1 = "Hello, World!";
        String str2 = "World";
        String str3 = "WORLD";

        boolean result1 = str1.regionMatches(7, str2, 0, 5);
        boolean result2 = str1.regionMatches(true, 7, str3, 0, 5);

        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void WithTest() {
        String str1 = "Hello, World!";

        boolean result = str1.startsWith("He");
        boolean result2 = str1.startsWith("World", 7);
        boolean result3 = str1.endsWith("World!");

        assertTrue(result);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    void indexOfTest() {
        String str = "hello world, hello!"; // 인덱스:  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
        // 문자:   h e l l o   w o r l d  ,    h  e  l  l  o  !

        // indexOf(String) : "hello"의 첫 등장 위치
        assertEquals(0, str.indexOf("hello"));

        // indexOf(String) : "hello"의 첫 등장 위치
        assertEquals(14, str.indexOf("e", 10, str.length() - 1));

        // indexOf(String, int) : 인덱스 5 이후에 나타나는 "hello"
        assertEquals(13, str.indexOf("hello", 5));

        // indexOf(int) : 문자 'o'의 첫 등장 위치 (문자에 대한 아스키 코드 전달 가능)
        assertEquals(4, str.indexOf('o'));

        // indexOf(int, int) : 인덱스 5 이후에 나타나는 'o'
        assertEquals(7, str.indexOf('o', 5));

        // lastIndexOf(String) : "hello"의 마지막 등장 위치
        assertEquals(13, str.lastIndexOf("hello"));

        // lastIndexOf(String, int) : 인덱스 12부터 역방향 검색 시 "hello"의 위치 (12보다 작거나 같은 인덱스 중 마지막)
        assertEquals(0, str.lastIndexOf("hello", 12));

        // lastIndexOf(int) : 문자 'o'의 마지막 등장 위치
        assertEquals(17, str.lastIndexOf('o'));

        // lastIndexOf(int, int) : 인덱스 10부터 역방향 검색 시 'o'의 위치
        assertEquals(7, str.lastIndexOf('o', 10));
    }

    @Test
    void subStringTest() {
        String str = "abcdefg";

        assertEquals("bcdefg", str.substring(1));
        assertEquals("cdef", str.substring(2, str.length() - 1));
    }

    @Test
    void concatTest() {
        String str = "Hello";

        System.out.println("str.concat(\"World\") = " + str.concat("World"));
    }

    @Test
    void replaceTest() {
        String str = "Hello, tmp";

        System.out.println("str.replace(\"tmp\", \"world\") = " + str.replace("tmp", "world"));
    }

    @Test
    void testReplaceFirst() {
        String original = "apple banana apple grape apple";
        // replaceFirst는 정규표현식을 사용하여 첫 번째 일치 항목만 치환합니다.
        String result = original.replaceFirst("apple", "orange");
        // 첫 번째 "apple"만 "orange"로 바뀝니다.
        assertEquals("orange banana apple grape apple", result);
    }

    @Test
    void testReplaceAll() {
        String original = "apple banana apple grape apple";
        // replaceAll은 정규표현식을 사용하여 모든 일치 항목을 치환합니다.
        String result = original.replaceAll("apple", "orange");
        // 모든 "apple"이 "orange"로 바뀝니다.
        assertEquals("orange banana orange grape orange", result);
    }

    @Test
    void testReplace() {
        String original = "apple banana apple grape apple";
        // replace는 정규표현식이 아닌 단순 문자열 치환으로, 모든 일치 항목을 바꿉니다.
        String result = original.replace("apple", "orange");
        // 모든 "apple"이 "orange"로 바뀝니다.
        assertEquals("orange banana orange grape orange", result);
    }

    @Test
    void splitTest() {
        String text = "apple,banana;cherry";

        // 1. split 메서드 사용: 구분자(여기서는 쉼표와 세미콜론)는 결과에 포함되지 않음.
        String[] tokens = text.split("[,;]");
        System.out.println("Using split: " + Arrays.toString(tokens));
        // 출력: [apple, banana, cherry]
    }

    @Test
    void joinArrayTest() {
        // 배열을 결합하는 경우
        String[] fruits = {"apple", "banana", "cherry"};
        String result = String.join(", ", fruits);
        System.out.println("result = " + result);
    }

    @Test
    void joinIterableTest() {
        // Iterable (List 등)을 결합하는 경우
        List<String> colors = Arrays.asList("red", "green", "blue");
        String expected = "red - green - blue";
        String result = String.join(" - ", colors);
        System.out.println("result = " + result);
    }

    @Test
    void joinWithNullTest() {
        // 배열 내 null 값이 있을 경우, "null" 문자열로 처리됨
        String[] words = {"hello", null, "world"};
        String result = String.join(", ", words);
        System.out.println("result = " + result);
    }

    @Test
    void testTrimVsStripWithUnicodeWhitespace() {
        // U+2000 (EN QUAD) 공백은 trim()에서는 제거되지 않음
        String original = "\u2000Hello World\u2000";

        // trim()은 U+2000을 제거하지 못하므로 원본과 동일하게 남음
        String trimmed = original.trim();
        // strip()은 모든 유니코드 공백 문자를 제거하므로 "Hello World"만 남음
        String stripped = original.strip();

        // trim() 결과는 원본과 동일해야 함
        assertEquals(original, trimmed, "trim()은 U+2000 공백을 제거하지 않습니다.");
        // strip() 결과는 "Hello World"가 되어야 함
        assertEquals("Hello World", stripped, "strip()은 모든 유니코드 공백을 제거합니다.");
    }

    @Test
    void testTrimVsStripWithRegularSpace() {
        // 일반 공백 (U+0020)인 경우, trim()과 strip() 모두 동일하게 동작
        String original = "  Hello World  ";
        String trimmed = original.trim();
        String stripped = original.strip();

        // 둘 다 "Hello World"가 되어야 함
        assertEquals("Hello World", trimmed, "trim()은 일반 공백을 제거합니다.");
        assertEquals("Hello World", stripped, "strip()도 일반 공백을 제거합니다.");
    }

    @Test
    void testStripLeading() {
        String original = "   Hello World!   ";
        String expected = "Hello World!   ";
        String result = original.stripLeading();
        assertEquals(expected, result, "stripLeading()은 문자열의 앞쪽 공백만 제거해야 합니다.");
    }

    @Test
    void testStripTrailing() {
        String original = "   Hello World!   ";
        String expected = "   Hello World!";
        String result = original.stripTrailing();
        assertEquals(expected, result, "stripTrailing()은 문자열의 뒤쪽 공백만 제거해야 합니다.");
    }

    @Test
    void isBlankTest() {
        System.out.println("\"\".isBlank() = " + "".isBlank());
    }


    @Test
    void testLines() {
        // lines()는 문자열을 줄 단위로 분리하여 스트림으로 반환합니다.
        String input = "line1\nline2\r\nline3";
        List<String> expected = List.of("line1", "line2", "line3");
        List<String> result = input.lines().toList();
        assertIterableEquals(expected, result, "lines()는 문자열을 줄 단위로 분리해야 합니다.");
    }

    @Test
    void testStripIndent() {
        // stripIndent(): 여러 줄의 문자열에서 공통적으로 존재하는 앞쪽 공백을 제거합니다.
        String input = "    Hello\n    World";
        String expected = "Hello\nWorld";
        String result = input.stripIndent();
        assertEquals(expected, result, "stripIndent()는 각 줄의 공통된 들여쓰기를 제거해야 합니다.");
    }

    @Test
    void testTranslateEscapes() {
        // translateEscapes(): 문자열 내의 이스케이프 시퀀스(예: \n, \t)를 실제 문자로 변환합니다.
        String input = "Hello\\nWorld\\t!";
        String expected = "Hello\nWorld\t!";
        String result = input.translateEscapes();
        assertEquals(expected, result, "translateEscapes()는 이스케이프 시퀀스를 실제 문자로 변환해야 합니다.");
    }

    @Test
    void testTransform() {
        // transform(): 함수형 인터페이스를 전달받아 문자열을 변환한 결과를 반환합니다.
        String input = "Hello";
        String expected = "HELLO";
        String result = input.transform(s -> s.toUpperCase());
        assertEquals(expected, result, "transform()은 주어진 람다 함수에 따라 문자열을 변환해야 합니다.");
    }


    @Test
    void testCopyValueOf() {
        // copyValueOf: 문자 배열 전체 또는 일부를 복사하여 문자열을 생성
        char[] data = {'J', 'a', 'v', 'a'};

        // 배열 전체 복사
        String full = String.copyValueOf(data);
        assertEquals("Java", full);

        // 배열의 부분 복사 (offset: 1, count: 2 -> "av")
        String sub = String.copyValueOf(data, 1, 2);
        assertEquals("av", sub);
    }

    @Test
    void testIntern() {
        // intern: 동일한 내용을 가진 문자열의 경우, 문자열 상수 풀에서 동일 인스턴스를 반환
        String s1 = new String("InternTest");
        String s2 = new String("InternTest");

        // 기본적으로 두 객체는 서로 다른 인스턴스임
        assertNotSame(s1, s2);

        // intern() 호출 후에는 동일한 상수풀의 객체를 참조함
        String interned1 = s1.intern();
        String interned2 = s2.intern();
        assertSame(interned1, interned2);
    }

    @Test
    void testDescribeConstable() {
        // describeConstable: 문자열의 상수 표현(ConstantDesc)을 Optional로 반환
        // 문자열이 상수풀에 존재하면 해당 Optional이 값이 채워져 있음
        String s = "HelloConstant";
        Optional<?> described = s.describeConstable();

        assertTrue(described.isPresent(), "상수 표현이 있어야 합니다.");
        // 실제 반환 값은 String의 상수 표현으로, s와 동일한 문자열 값을 갖습니다.
        assertEquals("HelloConstant", described.get().toString());
    }

    @Test
    void repeatTest() {
        String s = "s";
        String fiveS = s.repeat(5);

        assertEquals("sssss", fiveS);
    }

}


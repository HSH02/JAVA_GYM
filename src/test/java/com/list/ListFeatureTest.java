package com.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListFeatureTest {

    private List<String> list;
    private ArrayList<String> arrayList;
    private LinkedList<String> linkedList;

    @BeforeEach
    void setUp() {
        // 각 테스트마다 새 인스턴스를 생성
        list = new ArrayList<>();       // List 인터페이스 타입 (구현체: ArrayList)
        arrayList = new ArrayList<>();  // ArrayList 자체 타입
        linkedList = new LinkedList<>();// LinkedList 자체 타입
    }

    // ---------------------
    // 1) List 메서드 테스트
    // ---------------------

    @Test
    void testListAddAndRemove() {
        // List 인터페이스 - add, remove
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // TODO: 예시) list.remove(0);
        // fail("TODO: remove(0)에 해당하는 로직을 작성한 후, 아래 assertEquals(2, list.size())가 성립하는지 확인하세요.");
        list.remove(0);

        // 문제의 '답' 정의 - 최종적으로 요소가 2개여야 함
        assertEquals(2, list.size());
    }

    @Test
    void testListContains() {
        // List 인터페이스 - contains
        list.add("Apple");
        list.add("Banana");
        list.add("Content");

        // 문제의 '답' 정의
        assertTrue(list.contains("Content"));

        // fail("TODO: 필요하다면 list.remove(\"Apple\") 등을 구현하여 contains() 결과가 달라지는지 확인하세요.");
    }

    // ---------------------------------
    // 2) ArrayList 고유 메서드 테스트
    // ---------------------------------

    @Test
    void testArrayListEnsureCapacity() {
        // ArrayList 전용 메서드 ensureCapacity()
        arrayList.ensureCapacity(3);
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        // 문제의 '답' 정의 (현재 size는 3이어야 함)
        assertEquals(3, arrayList.size());

        // TODO: arrayList.ensureCapacity(10);
        // 내부 용량이 늘었는지 여부를 확인해야 하지만, 직접 확인하기는 어려움
        // 확장 여부를 로그나 다른 방식으로 검증하는 로직을 작성해볼 수 있음
        // fail("TODO: ensureCapacity() 호출 후 내부 용량을 확인하거나, 추가 요소 삽입 후 성능 등을 검증하세요.");
    }

    @Test
    void testArrayListTrimToSize() {
        // ArrayList 전용 메서드 trimToSize()
        // arrayList.ensureCapacity(16);
        arrayList.add("Dog");
        arrayList.add("Elephant");
        arrayList.add("Fox");

        // 문제의 '답' 정의
        assertEquals(3, arrayList.size());

        // TODO: arrayList.trimToSize();
        // fail("TODO: trimToSize() 호출 후 내부 용량이 size와 같아졌는지 테스트 로직 작성하세요.");
    }

    // ----------------------------------
    // 3) LinkedList 고유 메서드 테스트
    // ----------------------------------

    @Test
    void testLinkedListAddFirstAndGetFirst() {
        // LinkedList만의 addFirst, getFirst
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");

        linkedList.addFirst("Cat");

        // TODO: linkedList.addFirst("Cat");
        // 문제의 '답' 정의: getFirst() 결과는 "Cat"이어야 함
        // fail("TODO: addFirst(\"Cat\"); 후 getFirst()가 \"Cat\"인지 확인하세요.");

        // 예시 (사용자가 실제 로직 작성 후 살릴 수 있음)
        assertEquals("Cat", linkedList.getFirst());
    }

    @Test
    void testLinkedListRemoveLast() {
        // LinkedList만의 removeLast
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        // TODO: linkedList.removeLast();
        linkedList.removeLast();
        System.out.println("linkedList = " + linkedList);
        // fail("TODO: removeLast() 후 마지막 요소가 제거되었는지, 최종 크기가 2인가를 확인하세요.");

        // 예시 (사용자가 실제 로직 작성 후 살릴 수 있음)
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.contains("Cherry"));
    }

    @Test
    void testLinkedListPushPopAsStack() {
        // LinkedList의 push, pop - 스택처럼 사용
        linkedList.push("Monkey");
        linkedList.push("Tiger");
        linkedList.push("Lion");

        // fail("TODO: pop() 결과가 LIFO 순서로 잘 나오는지, 최종 리스트 상태가 올바른지 확인하세요.");

        // 예시
        String popped = linkedList.pop();
        assertEquals("Lion", popped);
        assertEquals(2, linkedList.size());
    }

    @Test
    void testLinkedListOfferPollPeekAsQueue() {
        // LinkedList의 offer, poll, peek - 큐처럼 사용
        linkedList.offer("Hippo");
        linkedList.offer("Zebra");

        // 요소가 2개 들어 있는 상태
        assertEquals(2, linkedList.size());

        // fail("TODO: peek(), poll() 결과가 FIFO 순서대로 동작하는지 확인하세요.");
        // 예시
        assertEquals("Hippo", linkedList.peek()); // 첫 요소 확인
        assertEquals("Hippo", linkedList.poll()); // 첫 요소 제거
        assertEquals("Zebra", linkedList.peek()); // 다음 요소 확인
    }

    // -------------------------------------------
    // 4) ListMethod 예시 관련 메서드들 테스트
    // -------------------------------------------

    @Test
    void testListMethodRemoveIf() {
        System.out.println(list.size());

        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(i));
        }

        list.removeIf(s -> Integer.parseInt(s) % 2 == 0);
        // removeIf() - 특정 조건을 만족하는 요소 제거
        // 예를 들어 5보다 큰 숫자 제거 등
        // fail("TODO: removeIf()로 특정 조건에 맞는 요소가 제거되는지 검증하는 테스트를 작성하세요.");
        // 문제의 '답' 정의 예시:
        assertFalse(list.contains(6));
    }

    @Test
    void testListMethodContainsAll() {
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listB.add("Element" + i);
        }
        
        listA.addAll(listB);
        // 예시:
        assertTrue(listA.containsAll(listB));
    }

    @Test
    void testListMethodRetainAll() {
        // retainAll() - 교집합(공통 요소)만 남기기
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listB.add("Element" + i);
        }

        listA.addAll(listB);
        listB.removeIf(s -> s.endsWith("3"));

        listA.retainAll(listB);
        // 예시:
         assertEquals(4, listA.size());
         assertFalse(listA.contains("Element 3")); // 가정
    }
}
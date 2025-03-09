package com.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        /*
         * List 인터페이스로 선언하더라도 실제로 LinkedList 객체를 생성하면
         * 연결 리스트 구조의 장점을 누릴 수 있습니다.
         */
        List<String> listInterface = new LinkedList<>();

        // 요소 추가
        listInterface.add("Apple");
        listInterface.add("Banana");
        listInterface.add("Cherry");

        System.out.println("[List 인터페이스 참조]");
        System.out.println("초기 List: " + listInterface);
        System.out.println("크기: " + listInterface.size());
        System.out.println("첫 번째 요소: " + listInterface.get(0));

        /*
         * 이번에는 LinkedList 타입 자체를 직접 변수에 할당해봅니다.
         * LinkedList만의 메서드 사용도 가능해집니다.
         */
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");

        System.out.println("\n[LinkedList 타입 참조]");
        System.out.println("초기 LinkedList: " + linkedList);
        System.out.println("크기: " + linkedList.size());

        /*
         * LinkedList에만 존재하는 대표적인 메서드들:
         * - addFirst(E e), addLast(E e)
         * - removeFirst(), removeLast()
         * - getFirst(), getLast()
         * - offer(E e), poll(), peek() 등
         * (Deque 인터페이스 구현)
         */
        System.out.println("\nLinkedList 전용 메서드 사용 예시:");

        // 가장 앞에 요소 추가
        linkedList.addFirst("Cat");
        linkedList.addFirst("Bird");
        // 가장 뒤에 요소 추가
        linkedList.addLast("Giraffe");
        linkedList.addLast("Zebra");

        System.out.println("addFirst, addLast 후: " + linkedList);

        // 가장 앞, 뒤의 요소 조회 (삭제 안 함)
        System.out.println("getFirst(): " + linkedList.getFirst());
        System.out.println("getLast(): " + linkedList.getLast());

        // 가장 앞의 요소 제거 후 반환
        String removedFirst = linkedList.removeFirst();
        System.out.println("removeFirst() -> " + removedFirst);
        System.out.println("removeFirst() 호출 후: " + linkedList);

        // offer, poll, peek (Queue 스타일)
        linkedList.offer("Hippo");
        System.out.println("\noffer(\"Hippo\") 후: " + linkedList);
        System.out.println("peek() -> " + linkedList.peek());
        String polled = linkedList.poll();
        System.out.println("poll() -> " + polled);
        System.out.println("poll() 호출 후: " + linkedList);

        // 스택처럼 활용 가능한 메서드 (push, pop)
        linkedList.push("Monkey");
        System.out.println("\npush(\"Monkey\") 후: " + linkedList);
        String popped = linkedList.pop();
        System.out.println("pop() -> " + popped);
        System.out.println("pop() 호출 후: " + linkedList);

        /*
         * LinkedList는 양방향 연결 리스트이므로
         * 중간 삽입/삭제에 유리하며, 큐 또는 스택처럼도 쓸 수 있다는 점이 특징입니다.
         */
    }
}
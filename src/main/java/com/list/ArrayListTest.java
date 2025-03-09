package com.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {

        /*
         * List 인터페이스로 선언하더라도 실제로 ArrayList 객체를 생성하면
         * 동적 배열의 장점을 누릴 수 있습니다.
         */
        List<String> listInterface = new ArrayList<>();

        // 요소 추가
        listInterface.add("Apple");
        listInterface.add("Banana");
        listInterface.add("Cherry");

        System.out.println("[List 인터페이스 참조]");
        System.out.println("초기 List: " + listInterface);
        System.out.println("크기: " + listInterface.size());
        System.out.println("첫 번째 요소: " + listInterface.get(0));

        // List 인터페이스에는 없는 메서드는 당연히 접근 불가
        // listInterface.ensureCapacity(20); // 컴파일 에러! (List에는 정의돼 있지 않음)

        /*
         * 이번에는 ArrayList 타입 자체를 직접 변수에 할당해봅니다.
         * ArrayList만의 메서드 사용도 가능해집니다.
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Dog");
        arrayList.add("Elephant");
        arrayList.add("Fox");

        System.out.println("\n[ArrayList 타입 참조]");
        System.out.println("초기 ArrayList: " + arrayList);
        System.out.println("크기: " + arrayList.size());

        /*
         * ArrayList에만 존재하는 대표적인 메서드: ensureCapacity, trimToSize
         * - ensureCapacity(int minCapacity): 내부 배열(버퍼)의 최소 용량을 보장
         * - trimToSize(): 현재 사용 중인 요소에 맞춰 내부 배열 용량을 줄임
         * (메모리 사용은 절약할 수 있으나, 자주 trim 하면 오히려 부하가 증가할 수도 있음)
         */
        System.out.println("\nArrayList 전용 메서드 사용 예시:");

        System.out.println("- ensureCapacity(10) 호출 전");
        // 내부용으로만 영향이 있어서 이 호출 직후 별도 출력값은 없습니다.
        arrayList.ensureCapacity(10);

        System.out.println("- trimToSize() 호출, 현재 size=" + arrayList.size());
        arrayList.trimToSize();
        // 마찬가지로 내부 용량 조정이므로 직접적인 출력 변화는 없지만,
        // 많은 데이터를 다룰 때 메모리 최적화 측면에서 쓸 수 있음

        /*
         * ArrayList는 RandomAccess 인터페이스를 구현하여 인덱스 접근이 빠릅니다.
         * 하지만 중간 삽입/삭제 시에는 LinkedList보다 성능이 떨어질 수 있습니다.
         * 반면, List는 이러한 세부 구현(동적 배열, 링크드 구조, 트리 등)에 대한 기술적 내용을
         * 알아야 할 필요는 없고, "추상화된 메서드"를 일관되게 사용할 수 있게 해줍니다.
         */
        arrayList.add("Giraffe");
        System.out.println("추가 후 ArrayList: " + arrayList);
    }
}
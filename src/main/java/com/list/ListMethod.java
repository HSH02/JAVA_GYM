package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        // 리스트 생성
        List<Integer> list = new ArrayList<>();

        // 초기 상태 확인
        System.out.println("초기 list.isEmpty() = " + list.isEmpty());

        // 리스트에 0부터 9까지 추가
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println("==========================================");
        System.out.println("추가 후 list.size() = " + list.size());

        // 인덱스 0 요소 제거
        list.remove(0);
        System.out.println("인덱스 0 제거 후 list = " + list);
        System.out.println("제거 후 list.size() = " + list.size());

        // 특정 요소 포함 여부
        System.out.println("list.contains(1) = " + list.contains(1));

        System.out.println("==========================================");

        // Iterator 사용 예 (5 제거)
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == 5) {
                iterator.remove();
            }
        }

        // forEach로 리스트 상태 확인
        System.out.println("[After Iterator] list 내용:");
        list.forEach(System.out::println);

        // removeIf 사용 예 (위에서 이미 5는 제거되었지만 예시로 다시)
        list.removeIf(element -> element == 5);

        // toArray(T[] a) 사용
        System.out.println("list.toArray(new Integer[0]) = " + Arrays.toString(list.toArray(new Integer[0])));

        // int 배열로 변환
        int[] intArray = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("intArray = " + Arrays.toString(intArray));

        // int 배열 합계
        int sum = Arrays.stream(intArray).sum();
        System.out.println("intArray 원소 합계 = " + sum);

        // 문자열 배열로 변환
        String[] stringArray = list.stream()
                .map(Object::toString)
                .toArray(String[]::new);
        System.out.println("stringArray = " + Arrays.toString(stringArray));

        // 리스트 비우기
        list.clear();
        System.out.println("list.clear() 후 list.isEmpty() = " + list.isEmpty());

        System.out.println("==========================================");

        // 다른 예시 리스트들
        List<String> listA = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        List<String> listB = new ArrayList<>(Arrays.asList("Banana", "Ba", "Date", "Eggplant"));

        // containsAll
        boolean containsAll = listA.containsAll(listB);
        System.out.println("listA.containsAll(listB) = " + containsAll);

        // addAll
        listA.addAll(listB);
        System.out.println("addAll 후 listA = " + listA);

        // containsAll 재확인
        boolean containsAll2 = listA.containsAll(listB);
        System.out.println("다시 확인한 listA.containsAll(listB) = " + containsAll2);

        // removeAll
        listA.removeAll(listB);
        System.out.println("removeAll 후 listA = " + listA);

        // removeIf ("B"로 시작하는)
        listB.removeIf(str -> str.startsWith("B"));
        System.out.println("removeIf 후 listB = " + listB);

        // listA에 요소 추가 후 retainAll
        listA.add("Date");
        listA.add("Kiwi");
        System.out.println("새 요소 추가 후 listA = " + listA);

        listA.retainAll(listB);
        System.out.println("retainAll 후 listA = " + listA);
    }
}
package com.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args) {
        final int SIZE = 100_000;
        
        // ArrayList와 LinkedList 생성
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        // 요소 추가 시간 측정
        long startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList 추가 시간: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 추가 시간: " + (endTime - startTime) + " ns");

        // 임의 접근(get) 시간 측정
        // ArrayList는 인덱스를 통한 접근이 빠르지만, LinkedList는 순차 검색으로 느림
        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 임의 접근 시간: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedList.get(i);  // LinkedList에서는 매번 처음부터 순차 검색
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 임의 접근 시간: " + (endTime - startTime) + " ns");

        // 중간 삽입 시간 측정
        // ArrayList는 내부 배열 복사 비용이 발생하지만, LinkedList는 연결 포인터만 조정하면 됨
        startTime = System.nanoTime();
        arrayList.add(SIZE / 2, -1);
        endTime = System.nanoTime();
        System.out.println("ArrayList 중간 삽입 시간: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.add(SIZE / 2, -1);
        endTime = System.nanoTime();
        System.out.println("LinkedList 중간 삽입 시간: " + (endTime - startTime) + " ns");
    }
}
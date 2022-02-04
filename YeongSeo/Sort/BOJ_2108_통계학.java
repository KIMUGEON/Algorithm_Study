package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2108
 * 걸린 시간 : 60분 이상
 * 리뷰 : 산술평균, 중앙값, 범위는 금방 구했지만 최빈값을 구하는 것이 오래 걸렸다.
 * 배열값이 양수였으면 배열 index를 통해 간단하게 구할 수 있었을 테지만, 음수를 포함하였기에
 * hashMap을 통해 숫자를 key로 그 숫자가 나온 횟수를 value로 하여 따로 저장하였다.
 * 그리고 최빈값 중 두번째로 작은 값을 출력하기 위한 방법도 고민하였는데,
 * hashMap을 key를 기준으로 정렬한 후 최빈값이 나오는 두번째로 작은 key를 출력하도록 구현하였다.
 * 자바로 hashMap을 다루는 것이 처음이라 생각보다 오래 걸렸는데 익숙해져야겠다..!!
*/
public class BOJ_2108_통계학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수의 개수
		int[] arr = new int[N];
		double sum=0.0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		double average = sum / N;
		
		Arrays.sort(arr); // 배열 오름차순 정렬
	
		Map<Integer, Integer> hMap = new HashMap<>();
		
		// key: 숫자 value: 숫자가 배열에 몇번 나왔는지 count
		for(int i=0; i<N; i++) {
			if(hMap.containsKey(arr[i])) { // key가 이미 있으면 이미 저장된 value 값에 +1
				int temp = hMap.get(arr[i]);
				hMap.put(arr[i], temp+1);
			} else { // key가 없으면 value를 1로 하여 해쉬맵에 새로 추가
				hMap.put(arr[i], 1);
			}
		}
		
		int max = 0; // 최빈도 횟수 (value)
		int maxKey = Integer.MAX_VALUE; // 최빈값 (key)
		
		List<Integer> mapKey = new ArrayList<>(hMap.keySet()); // key 정렬을 위한 ArrayList
		Collections.sort(mapKey); // key 정렬
		
		// 가장 많이 나온 횟수(value) 구하기
		for(int key : mapKey) {
			if(max < hMap.get(key)) {
				max = hMap.get(key);
			}
		}

		int cnt = 0;
		for(int key : mapKey) { // 최빈도 횟수(value)를 가지는 최빈값(key) 구하기
			if(max == hMap.get(key)) {
				maxKey = key;
				cnt++;
				if(cnt == 2) // cnt가 2이면 최빈값 중에서 두번째로 작은 값이므로 break;
					break;
			}
		}
		
		System.out.printf("%.0f\n", average); // 산술평균 출력
		System.out.println(arr[arr.length / 2]); // 중앙값 출력
		System.out.println(maxKey); //최빈값 출력
		System.out.println(arr[arr.length-1]-arr[0]); // 범위 출력
	}

}

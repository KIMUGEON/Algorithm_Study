package Brute_Force;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/7568
 * 걸린 시간 : 20분
 * 느낀 점 : 예제 케이스는 통과했지만 반례를 찾지 못해서 틀렸다고 나왔는데,
 * 문제를 다시 이해하니 자신보다 키와 몸무게가 하나라도 같아도 카운트하지 않아야 한다는 조건을 빼먹었다.
 * 구현 자체는 어렵지 않았지만 문제 조건을 꼼꼼히 읽어야겠다..!! 
 */
public class BOJ_7568_덩치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 사람의 수
		int[][] bulks = new int[N][2]; // 각 사람의 덩치를 저장하는 배열 (몸무게, 키)
		int[] ranks = new int[N]; // 각 사람의 덩치 등수를 저장하는 배열

		for (int i = 0; i < N; i++) {
			bulks[i][0] = sc.nextInt(); // 몸무게 저장
			bulks[i][1] = sc.nextInt(); // 키 저장
		}
		
		
		for (int i = 0; i < N; i++) {
			int cnt = 0; // 자신보다 큰 덩치의 사람을 카운트하는 변수
			for (int j = 0; j < N; j++) {
				if (j == i) // 자기 자신과의 비교는 불필요하니 continue
					continue;

				if ((bulks[i][0] < bulks[j][0]) && (bulks[i][1] < bulks[j][1])) { 
					// 자신보다 키와 몸무게 둘 다 더 큰 사람이면 카운트 +1
					cnt++;
				}
			}
			ranks[i] = cnt + 1; // 덩치 등수 저장
		}

		for (int rank : ranks) {
			System.out.print(rank + " ");
		}

	}

}

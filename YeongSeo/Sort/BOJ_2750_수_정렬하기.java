package Sort;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2750
 * 걸린 시간 : 10분
 * 느낀 점 : 시간복잡도 O(n^2)인 버블정렬로 풀었다.
 * 이중 for문 안에 이웃한 두 값을 비교하는 코드에서 비교를 몇번 해야하는지에 대한
 * 범위를 -1 해주지 않아서 index 범위초과 오류가 났지만, 다시 차근차근 비교 횟수에 대해 생각하고 -1을 해줬다.
 * 정렬문제는 반복문의 범위를 제대로 설정하는 것이 정말 중요..!!
*/
public class BOJ_2750_수_정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<N-1; i++) { // 총 수행해야하는 round 수 만큼 반복
			for(int j=0; j<N-i-1; j++) { // 이미 정렬된 부분을 제외하고 이웃한 두 값끼리 비교
				
				if(arr[j] > arr[j+1]) { // 왼쪽 값이 오른쪽 값보다 크면 swap(오름차순 정렬)
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		// 정렬된 배열값 출력
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
	}

}

package Implementation;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2477
 * 걸린 시간 : 45분
 * 리뷰 : 처음에는 입력받은 길이의 너비와 높이의 max, min 값을 저장해서 각각 max와 min 값을 곱해서 큰 사각형과 작은 사각형의 차로 참외밭의 넓이를 구하려했다.
 * 하지만 항상 min값이 작은 사각형의 변의 길이가 된다는 보장이 없다는걸 간과한 풀이였다.
 * max값의 양옆을 한번씩 건너뛴 변의 길이가 작은 사각형의 변의 길이가 되므로 이를 구해주기 위해서,
 * max값의 인덱스를 기억한뒤 max값이 존재하는 인덱스의 양옆을 지워줘서 배열에 작은 사각형의 변의 길이만 남게 해주었다.
 * 그리고 각각 이를 곱해서 작은 사각형의 넓이를 구해줘서 큰 사각형 넓이-작은 사각형 넓이로 참외밭의 넓이를 구해주었다. 
 */
public class BOJ_2477_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 1 제곱미터에서 자라는 참외의 개수
		int[] length = new int[6]; // 참외밭의 변의 길이를 저장하는 배열
		int widthMax = 0; // 가장 큰 너비의 길이
		int heightMax = 0; // 가장 큰 높이의 길이
		int widthIdx = 0; // 가장 큰 너비의 인덱스
		int heightIdx = 0; // 가장 큰 높이의 인덱스
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt(); // 변의 방향
			int len = sc.nextInt(); // 변의 길이
			
			length[i] = len; // 배열에 길이 저장
			
			switch(dir) {
			case 1: case 2: // 동쪽,서쪽 (너비)
				if(widthMax < len) { // 가장 큰 너비로 길이와 갱신
					widthMax = len;
					widthIdx = i;
				}
				break;
			case 3: case 4: // 남쪽,북쪽 (높이)
				if(heightMax < len) { // 가장 큰 높이로 갱신
					heightMax = len;
					heightIdx = i;
				}
				break;
			}
		}
		
		// 가장 큰 너비와 높이의 양옆의 길이는 지우기 (0으로 대입) 
		for (int i = 0; i < 6; i++) {
			if(i == widthIdx || i == heightIdx) {
				if (i-1 >= 0) length[i-1] = 0;
				else length[5] = 0;
				
				if (i+1 < 6) length[i+1] = 0;
				else length[0] = 0;
			}
		}
		
		int bigArea = widthMax*heightMax; // 큰 사각형의 넓이
		int smallArea = 1; // 작은 사각형의 넓이
		
		// length에는 작은 사각형의 가로 세로 길이만 남아있음 -> 서로 곱하기
		for (int i = 0; i < 6; i++) { 
			if(length[i] != 0) smallArea *= length[i];
		}
		
		int area = bigArea-smallArea; // 참외밭의 넓이
		
		System.out.println(area*K); // 결과 출력
	}

}

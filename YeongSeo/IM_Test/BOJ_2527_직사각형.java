package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2527
 * 걸린 시간 : 60분
 * 리뷰 : 우선 직사각형의 각 좌표 정보를 저장하기 위해서 직사각형 클래스를 만들었다. 
 * 직사각형 객체에 입력받은 꼭짓점 좌표를 입력받아 차례대로 if-else 조건 분기문을 통해 두 직사각형의 꼭짓점 좌표를 비교해서
 * 점, 공통부분X, 선분을 검사하였다. 직사각형(면)을 제일 마지막 else 문으로 뺀 이유는 이 조건이 제일 경우의 수가 많고 복잡하기에
 * 위 세가지 특성이 아니면 자동으로 면 특성이 되도록 유도하였다.
*/
public class BOJ_2527_직사각형 {
	public static class Rectangle { // 직사각형의 꼭짓점을 저장하는 객체
		int x, y, p, q;

		public Rectangle(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 직사각형1 객체 생성
			Rectangle rt1 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// 직사각형2 객체 생성
			Rectangle rt2 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 점
			if ((rt1.p == rt2.x && rt1.q == rt2.y) || (rt1.x == rt2.p && rt1.q == rt2.y) || (rt1.p == rt2.x && rt1.y == rt2.q)
					|| (rt1.x == rt2.p && rt1.y == rt2.q)) {
				sb.append("c");
			
			// 공통부분이 없음
			} else if (rt1.p < rt2.x || rt2.p < rt1.x || rt1.q < rt2.y || rt2.q < rt1.y) {
				sb.append("d");

			// 선분
			} else if ((rt1.p == rt2.x) || (rt1.x == rt2.p) || (rt1.y == rt2.q) || (rt1.q == rt2.y)) {
				sb.append("b");

			// 직사각형(면)
			} else {
				sb.append("a");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb); // 결과 출력
	}

}

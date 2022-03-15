package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 사각형 좌표 입력받기
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			// 확인하기
			// 직사각형 a, 선분 b, 점 c, 공통부분 없음 d
			if(q1<y2 || q2<y1 || p2<x1 || x2>p1) sb.append("d").append("\n");
			else if((x1==p2&&q1==y2)||(x2==p1&&q1==y2)||
					(x1==p2&&q2==y1)||(x2==p1&&q2==y1)) sb.append("c").append("\n");
			else if((x1==p2&&q1>y2)||(x1==p2&&q2>y1)||
					(x2==p1&&q1>y2)||(x2==p1&&q2>y1)||
					(x1>p2&&q1==y2)||(x2<p1&&q1==y2)||
					(x1>p2&&q2==y2)||(x2<p1&&q2==y1)) sb.append("b").append("\n");
			
			else sb.append("a").append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}
package IM_Test.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫줄에는 w와 h가 공백을 사이에 두고 주어진다. 그 다음 줄에는 초기 위치의 좌표값 p와 q가 공백을 사이에 두고 주어진다. 3번째 줄에는 개미가 움직일 시간 t가 주어진다. 

  [출력]
출력은 t 시간 후에 개미의 위치 좌표 (x,y)의 값 x와 y를 공백을 사이에 두고 출력한다. 
 */
public class Main_10158 { //개미

	public static void main(String[] args) throws IOException {
//		===============================  입력   =====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken()); //가로길이
		int h = Integer.parseInt(st.nextToken()); //세로길이
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); //개미 초기위치 x
		int q = Integer.parseInt(st.nextToken()); //개미 초기위치 y
		int t = Integer.parseInt(br.readLine()); //개미가 움직일 시간

//		===============================  풀이   =====================================
		int x = (p+t)%(2*w); //(개미좌표 + 시간)%2w 
		int y = (q+t)%(2*h);
		
		x = w - Math.abs(w-x); //최종좌표
		y = h - Math.abs(h-y);
		
//		===============================  출력   =====================================
		System.out.println(x+" "+y);
	}

}

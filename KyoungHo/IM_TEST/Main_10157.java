package IM_Test.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
  [입력]
첫 줄에는 공연장의 격자 크기를 나타내는 정수 C와 R이 하나의 공백을 사이에 두고 차례대로 주어진다. 
두 값의 범위는 5 ≤ C, R ≤ 1,000이다. 그 다음 줄에는 어떤 관객의 대기번호 K가 주어진다. 단 1 ≤ K ≤ 100,000,000이다.

  [출력]
입력으로 제시된 대기번호 K인 관객에게 배정될 좌석번호 (x,y)를 구해서 두 값, x와 y를 하나의 공백을 사이에 두고 출력해야 한다. 
만일 모든 좌석이 배정되어 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우에는 0(숫자 영)을 출력해야 한다.
 */
public class Main_10157 { //자리배정
	static int deltas[][] = { //상 우 하 좌
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()); //가로
		int R = Integer.parseInt(st.nextToken()); //세로
		int K = Integer.parseInt(br.readLine()); //대기번호
		
		int map[][] = new int[R][C]; //공연장
		
		int x = R-1; //초기 시작 위치
		int y = 0; //초기 시작위치
		int d = 0; //진행방향
		int cnt = 1; //좌석번호 1부터
		
		if(C*R<K) { //대기번호가 공연장 크기보다 크면 0
			System.out.println(0);
			return;
		}else
			while(cnt !=K) { 
				map[x][y] = cnt; //초기위치 1부터 시작
				int dx = x+deltas[d][0];
				int dy = y+deltas[d][1];
				
				if(dx<0 || dy<0 || dx>=R || dy>=C || map[dx][dy] != 0) { //방향전환 조건,상우좌하 순서
					d++;
					if(d==4) { //4방향 다 돌면 처음 방향부터 다시
						d=0;
					}
					dx = x + deltas[d][0];
					dy = y + deltas[d][1];
				}
				x = dx;
				y = dy;
				cnt++;
			}
		
		System.out.println((y+1)+" "+(R-x));

	}

}

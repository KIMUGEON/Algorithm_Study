package _20_분할정복.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  [입력]
첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 
다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

  [출력]
첫째 줄에 -1로만 채워진 종이의 개수를, 
둘째 줄에 0으로만 채워진 종이의 개수를, 
셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 */
public class Main_1780 { //종이의 개수

	static int N, map[][];
	static int cnt1, cnt2, cnt3; //-1, 0, 1 카운트
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		===============================  입력   ====================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt1 = 0; cnt2 = 0; cnt3 = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		===============================  풀이   ====================================
		tree(N,0,0); //맵 길이, 행, 열 
		
//		===============================  출력   ====================================
		System.out.print(cnt1 + "\n" + cnt2 + "\n" + cnt3);
	}
	
	public static void tree(int n, int r, int c) {
		if(check(n,r,c)) { //종이 자르기 가능하면 
			if(map[r][c] == -1) { //-1이면
				cnt1++;
			}
			else if(map[r][c] == 0) { //0이면
				cnt2++;
			}
			else cnt3++; //1이면
			return;
		}
		
		int len = n/3; //3등분 해주기
		
		//사각형을 9개로 나누기 
		tree(len,r,c);		
		tree(len,r,c+len);
		tree(len,r,c+len*2);
		
		tree(len,r+len,c);
		tree(len,r+len,c+len);
		tree(len,r+len,c+len*2);
		
		tree(len,r+len*2,c);
		tree(len,r+len*2,c+len);
		tree(len,r+len*2,c+len*2);
		
	}
	
	public static boolean check(int n, int r, int c) { // 종이 자르기
		int data = map[r][c]; //처음 위치 값
		
		for(int i=r; i<r+n; i++) { //현재 공간에서 종이 자르기 가능여부 체크
			for(int j=c; j<c+n; j++) {
				if(data != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}

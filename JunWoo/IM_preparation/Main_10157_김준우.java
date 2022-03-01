package _0301_IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫줄 공연장 크기 C, R 입력(5~1000) 
 * 두번째줄 random 관객의 대기번호 (1~100,000,000)
 * 헷갈리니 공연장 그림 상하 반전할거임
 */
public class Main_10157_김준우 {
	static int C, R, K;	// 공연장 크기 밑 대기번호
	static int[][] hall;
	static int[] dx = {0,1,0,-1};	//하 우 상 좌
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		hall = new int[C+1][R+1];
		int cx = 1; int cy = 1;
		int dir = 0;
		
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i<=C*R; i++) {
			if(i == K) {
				System.out.println(cx + " " + cy);
				break;
			}
			hall[cx][cy] = i;
			int nx = cx+dx[dir];
			int ny = cy+dy[dir];
			if(nx<= 0 || nx>C || ny<= 0 || ny>R || hall[nx][ny] != 0) {
				dir++;
				if(dir == 4) dir = 0;
				nx = cx+dx[dir];
				ny = cy+dy[dir];
			}
			cx = nx; cy = ny;
		}
		
	}

}

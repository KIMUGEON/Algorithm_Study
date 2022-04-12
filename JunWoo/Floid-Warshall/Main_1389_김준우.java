package _0408_플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1389_김준우 {
	static int N, M, INF = 10000000;
	static int[][] kb;
	
	public static int fw() {
		int min = Integer.MAX_VALUE; int inssa = 0;	// 현재까지 최소 케빈베이컨값, 현재까지 가장 작은 사람
		
		//플로이드 와샬 탐색
		for(int k = 1; k<=N; k++) {		//경유 노드
			for(int i = 1; i<=N; i++) {	//출발 노드
				for(int j = 1; j<=N; j++) {	//도착 노드
					//기입력된 값보다 경유하는게 단계가 더 낮은 경우 경유하는 단계를 배열에 입력
					if(kb[i][k] + kb[k][j] < kb[i][j]) {	
						kb[i][j] = kb[i][k] + kb[k][j]; 
					}
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			//i행의 값을 전부 더해서 케빈 베이컨 값을 구함
			int sum = 0;
			for(int j = 1; j<=N; j++) {
				sum += kb[i][j];
			}
			
			//케빈베이컨 값이 최소값보다 작으면 그 사람을 result 값에 넣음. 같은 번호는 스킵하므로 가장 번호가 작은 사람을 출력하게 됨. 
			if(sum<min) {	
				min = sum;
				inssa = i;
			}
		}
		
		return inssa;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//===케빈베이컨 입력====
		kb = new int[N+1][N+1];	//0번 인덱스 사용 안함
		for(int i = 1; i<=N; i++) {
			//자기 자신을 향하는 값과 j가 0인 인덱스 빼고 전부 매우 큰수로 초기화
			Arrays.fill(kb[i], INF);
			kb[i][i] = 0;
			kb[i][0] = 0;
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			kb[a][b] = 1;
			kb[b][a] = 1;
		}
		
		System.out.println(fw());
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetPermission;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 2606번  
 * 제목 : 바이러스
 * 
 * 1번 컴퓨터와 직접 및 간접적으로 연결되어 있는 컴퓨터의 개수를 구하면 1번을 제외한 바이러스에 걸린 컴퓨터의 수를 구할 수 있다
 * 각 컴퓨터의 연결 관계를 2차원 배열을 사용하여 나타내고
 * 2차원 배열을 통해 1번 컴퓨터와 직접 및 간접적으로 연결되어 있는 컴퓨터의 개수를 구한다
 */

public class Main_2606_바이러스 {

	static boolean[] isCheck;
	static boolean[][] map;
	static int comN,netNum;		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		comN = Integer.parseInt(st.nextToken()); // 컴퓨터의 수
		
		st = new StringTokenizer(bf.readLine());
		netNum = Integer.parseInt(st.nextToken()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
		

		map = new boolean[comN+1][comN+1]; // 각 컴퓨터 사이의 연결 관계를 확인할 2차원 배열
		isCheck = new boolean[comN+1]; // 1번 컴퓨터와 직접 및 간접적으로 연결된 다른 컴퓨터가 
		for(int i=0;i<netNum;i++) { // 컴퓨터 사이의 연결 관계 입력
			st = new StringTokenizer(bf.readLine());
			int fCom = Integer.parseInt(st.nextToken());
			int sCom = Integer.parseInt(st.nextToken());
			map[fCom][sCom] = true; 
			map[sCom][fCom] = true;	
		}
		
		virusCheck(map,1); // 1번에 의해 바이러스가 걸린 컴퓨터 확인하기
		
		int cnt=0;
		
		for(int i=2;i<comN+1;i++) { // 1번에 의해 바이러스가 걸린 컴퓨터 개수 구하기
			if(isCheck[i] == true) cnt++; 
		}
		System.out.println(cnt);
	}
	
	public static void virusCheck(boolean[][] map, int r) { // r은 탐색하려는 map 배열의 행
		for(int i=1;i<comN+1;i++) {
			if(map[r][i]==true) { // r번 컴퓨터와 i번 컴퓨터가 연결되어 있다면
				if(isCheck[i]==true) continue; // i번 컴퓨터가 바이러스를 걸린지 이미 확인하였다면 i+1번 컴퓨터 확인
				isCheck[i] = true; // i번 컴퓨터가 바이러스에 걸렸음을 체크
				virusCheck(map,i); // map 배열의 i행 확인하기
			}
		}
	}

}

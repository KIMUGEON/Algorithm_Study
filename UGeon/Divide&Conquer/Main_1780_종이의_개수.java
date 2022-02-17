import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 1780번  
 * 제목 : 종이의 개수
 * 
 * 전체 종이가 같은 수로 저장되어 있는지 확인한다
 * 만약 전체 종이에 같은 수가 저장되어 있다면 저장된 수의 cnt를 1 추가하고 종료
 * 만약 전체 종이에 같은 수가 저장되어 있지 않다면  구역을 1/9로 나누고
 * 구역별로 종이에 같은 수가 저장되어 있는지 탐색 반복
 * 전체 종이에 같은 수가 저장되어 있을 때까지 위와 같은 방법 반복 확인 
 */

public class Main_1780_종이의_개수 {

	static int N,Minus,Zero,Plus;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); // 종이의 크기
		
		map = new int[N][N]; // 종이의 각 칸에 입력되어 있는 수를 저장할 배열 
		Minus =0; // -1이 저장된 종이의 개수
		Zero = 0; // 0이 저장된 종이의 개수
		Plus = 0; // 1이 저장된 종이의 개수
		
		for(int i=0;i<N;i++) { // 종이의 각 칸에 있는 수 저장
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getPaper(0, 0, N); // 종이의 개수 찾기
		System.out.println(Minus); // -1이 저장된 종이의 개수 출력
		System.out.println(Zero); // 0이 저장된 종이의 개수 출력
		System.out.println(Plus); // 1이 저장된 종이의 개수 출력

	}
	
	public static void getPaper(int r, int c, int size) { // 하나의 숫자로만 저장된 종이의 개수를 찾는 메서드
		if(isCheck(r, c, size)) { // 전체 종이가 하나의 숫자로만 저장되어 있는 경우
			switch (map[r][c]) {
			case -1: // 저장된 숫자가 -1인 경우
				Minus++; // -1 cnt 증가
				break; // 탈출
				
			case 0: // 저장된 숫자가 0인 경우
				Zero++; // 0 cnt 증가
				break; // 탈출
				
			case 1: // 저장된 숫자가 1인 경우
				Plus++; // 1 cnt 증가
				break; // 탈출
			}
			return; // 종료
		}
		
		size /= 3; // 전체 종이가 하나의 숫자로만 저장되어 있지 않기 때문에 종이의 구역을 1/9로 나누고
		
		getPaper(r, c, size); // 좌상
		getPaper(r, c+size, size); // 상
		getPaper(r, c+(size)*2, size); // 우상
		
		getPaper(r+size, c, size); // 좌
		getPaper(r+size, c+size, size); // 정중앙
		getPaper(r+size, c+(size)*2, size); // 우
		
		getPaper(r+(size)*2, c, size); // 좌하
		getPaper(r+(size)*2, c+size, size); // 하
		getPaper(r+(size)*2, c+(size)*2, size); // 우하
		
	}
	
	public static boolean isCheck(int r, int c, int size) { // 종이가 하나의 숫자로만 저장되어 있는지 확인하는 메서드
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[r][c]!=map[i][j]) return false; // 종이에 2개 이상의 숫자가 저장되어 있으면 false 반환
			}
		}
		return true; // 종이에 1개의 숫자만 저장되어 있으면 true 반환
	}
	
}

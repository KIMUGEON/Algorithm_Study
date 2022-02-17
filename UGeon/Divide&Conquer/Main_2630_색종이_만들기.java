import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 2630번  
 * 제목 : 색종이 만들기
 * 
 * 전체 종이가 같은 색상으로 칠해져 있는지 확인을 한다
 * 만약 전체 종이가 같은 색상으로 칠해져 있다면 칠해진 색상을 1 추가하고 종료
 * 만약 전체 종이가 같은 색상으로 칠해져 있지 않다면 색상을 구역을 1/4로 나누고
 * 구역별로 종이가 같은 색상으로 칠해져 있는지 탐색 반복
 * 전체 종이가 같은 색상으로 칠해져 있을 때까지 위와 같은 방법 반복 확인 
 */

public class Main_2630_색종이_만들기 {

	static int N,White, Blue;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); // 전체 종이의 한 변의 길이 N
		
		map = new int[N][N]; // 종이에 칠해진 색 정보를 저장할 배열
		
		for(int i=0;i<N;i++) { // 종이에 칠해진 색 정보 저장
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		White =0; // 하얀색 종이 개수
		Blue = 0; // 파란색 종이 개수
		square(0,0,N); // 같은 색으로만 이루어진 정사각형 종이로 나누기
		
		System.out.println(White); // 하얀색 종이 개수 출력
		System.out.println(Blue); // 파란색 종이 개수 출력

		
	}
	
	public static void square(int r, int c, int size) {
		if(isCheck(r, c, size)) { // 전체 종이가 같은 색으로만 칠해져 있으면
			if(map[r][c]==0) White++; // 하얀색으로만 칠해져 있으면 하얀색 종이 개수 추가
			else Blue++; // 파란색으로만 칠해져 있으면 파란색 종이 개수 추가
			
			
			return; // 종료
		}
		
		size /= 2; // 전체 종이가 같은 색으로 칠해져 있지 않으면 종이 나누기
		
		square(r,c,size); // I 구역
		square(r,c+size,size); // II 구역
		square(r+size,c,size); // III 구역
		square(r+size,c+size,size); // IV 구역
		
	}
	
	public static boolean isCheck(int r, int c, int size) { // 전체 종이가 같은 색으로 칠해져 있는지 확인하는 메서드
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[r][c]!=map[i][j]) { // 전체 종이가 같은 색으로 칠해져 있지 않다면
					return false; // false 리턴
				}
			}
		}
		return true; // 전체 종이가 같은 색으로 칠해져 있다면 true 리턴
	}

}

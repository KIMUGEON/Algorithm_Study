import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 1992번  
 * 제목 : 쿼드트리
 * 
 * 배열의 해당 범위가 같은 숫자로만 저장되어 있는지 확인하고
 * 만약 같은 숫자로만 저장되어 있다면 해당 숫자를 압축 표현하여 출력한다
 * 만약 같은 숫자로 저장되어 있지 않다면 해당 범위를 1/4로 구역을 나누어 구역별로 위와 같은 탐색을 반복한다
 * 최종적으로 해당 범위가 같은 숫자로만 이루어졌을 때 압축 표현 방식에 따라 결과를 출력한다
 */

public class Main_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine()); // 영상 크기 N 입력
		
		map = new int[N][N]; // 영상 정보 저장 배열
		
		for(int i=0;i<N;i++) { // 영상 정보 저장
			String str = bf.readLine(); // String으로 한 줄씩 입력 받아서
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0'; // map 배열에 숫자 형태로 저장
			}
		}
		
		QuadTree(0, 0, N); // 쿼드 트리 방법 압축 실행
		System.out.println(sb); // 결과값 출력

	}
	
	public static void QuadTree(int r, int c, int size) { // 쿼드 트리 방법으로 데이터를 압축하기 위해

		if(possibleQT(r,c,size)) { // 압축 가능하면
			sb.append(map[r][c]); // 시작 위치 값 저장하고 종료
			return;
		}
		else {
			
			sb.append('(');
			
			size /= 2; // size 크기 절반으로 줄여주고
			
			QuadTree(r, c, size); // 왼쪽 위
			QuadTree(r, c+size, size); // 오른쪽 위
			QuadTree(r+size, c, size); // 왼쪽 아래
			QuadTree(r+size, c+size, size); // 오른쪽 아래
			
			sb.append(')');
		}
			
		
	}
	
	public static boolean possibleQT(int r, int c, int size) { // 해당 범위 내에서 압축하여 표현할 수 있는지 확인하기 위해
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[i][j] != map[r][c]) return false; // 해당 범위 압축 표현 불가능하면 flase 리턴
			}
		}
		
		return true; // 해당 범위 압축 표현 가능하면 true 리턴
	}

}
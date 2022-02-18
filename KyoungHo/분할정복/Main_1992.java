package _20_분할정복.Silver1;
import java.util.Scanner;

/*
  [입력]
첫째 줄에는 영상의 크기를 나타내는 숫자 N 이 주어진다. 
N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64의 범위를 가진다. 
두 번째 줄부터는 길이 N의 문자열이 N개 들어온다. 
각 문자열은 0 또는 1의 숫자로 이루어져 있으며, 영상의 각 점들을 나타낸다.

  [출력]
영상을 압축한 결과를 출력한다.
 */

public class Main_1992 {//쿼드트리

	static int N,map[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
//		==================  입력   ==================
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //영상의 크기
		map = new int[N][N]; //영상 배열
		
		for(int i=0; i<N; i++) { //영상 배열에 값 넣기
			String line = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
//		==================  풀이   ==================
		tree(N,0,0);	//크기, 행 열 좌표
		
//		==================  출력   ==================
		System.out.println(sb);
		
	}
//	=========================  tree   ==========================
	public static void tree(int n,int r,int c) {
		if(check(n,r,c)) {	//압축 가능한 경우
			sb.append(map[r][c]);
			return;
		}
		
		int len = n/2; //크기 반으로 나누기
		
		sb.append('('); // 출력 포맷, (로 시작해야함
		
		tree(len,r,c);			//왼쪽 위
		tree(len,r,c+len);		//오른쪽 위
		tree(len,r+len,c);		//왼쪽 아래
		tree(len,r+len,c+len);	//오른쪽 아래
		sb.append(')'); //출력 포맷, )로 끝나야함
	}
	
//	=========================  check   ==========================
	public static boolean check(int n, int r, int c) { //압축 가능여부 체크
		int data = map[r][c];	//처음 위치의 값
		
		for(int i=r; i<r+n; i++) {	//현재 공간에서 압축여부 체크(공간 내의 값이 전부 같은 수여야 함)
			for(int j = c; j < c+n; j++) {
				if(data !=map[i][j]) {
					return false; //압축 불가면 false
				}
			}
		}
		
		return true; //압축 가능이면 true
	}

}

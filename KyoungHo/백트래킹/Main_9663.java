package _14_백트래킹.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 { //N-Queen

	static int N,col[],ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		col = new int[N+1]; //0 사용 안함
		setQueen(1);
		System.out.println(ans);
		
	}

	public static void setQueen(int r) { //r : 퀸을 두어야 하는 행
		
		if(!isAvailable(r-1)) return; //직전까지의 상황이 유망하지 않다면 리턴
		
		//기본파트 : 퀸을 모두 놓았다면
		if(r>N) {
			ans++;
			return;
		}
			
		
		
		//1열부터 N열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[r] = i;
			setQueen(r+1);
			
		}
	}
	
	public static boolean isAvailable(int r) { //놓아진 마지막 퀸
		for (int i = 1; i < r; i++) {
			if(col[r] == col[i] || r-i == Math.abs(col[r]-col[i])) return false; //기존 퀸이랑 현재 열번호가 같은 경우(일렬 체크), 대각선 체크
		}
		return true;
	}
	
}

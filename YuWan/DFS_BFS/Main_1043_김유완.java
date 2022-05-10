package study_0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1043_김유완 {
	static int N,M;
	static int[][] arr,arrP;
	static int[] arrT; // 처음 진실을 알고 있는 사람들
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		// 입력
		arr = new int[N+1][N+1];
		arrP = new int[M][]; // 파티별로 누가 참석하는지 번호 넣을 예정
		arrT = new int[N+1]; // 총 사람 중에 누가 진실인지 거짓인지 체크
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if(num != 0) {
			for (int i = 0; i < num; i++) {
				int person = Integer.parseInt(st.nextToken());
				arrT[person] = 1;
			}
		}
		// 파티별 참석하는 사람 알기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arrP[i] = new int[n];
			for (int j = 0; j < n; j++) {
				int person = Integer.parseInt(st.nextToken());
				arrP[i][j] = person;
				if(j != 0)	arr[arrP[i][j-1]][arrP[i][j]] = arr[arrP[i][j]][arrP[i][j-1]] = 1;
			}
		}
		for (int i = 1; i < N+1; i++) {
			if(arrT[i] == 1) check(i); // 진실인사람과 연관된 사람 있는지 확인하러 체크
		}
		int result = 0; // 거짓말 할 수 있는 파티 개수
		// 파티별로 거짓말 할 수 있는 지 없는지 확인
		for (int i = 0; i < M; i++) {
			int size = arrP[i].length;
			int c = 0;
			for (int j = 0; j < size; j++) {
				int temp = arrP[i][j]; // 참석하는 사람 별로 확인
				if(arrT[temp] == 0) c++; // 진실 모르는 경우 c++
			}
			if(c == size) result++; // 참석하는 인원이 다 진실을 모르는 경우
		}
		System.out.println(result);
	}
	public static void check(int n) {
		for (int i = 1; i < N+1; i++) {
			// 서로 이어져있는데 아직 진실을 안다고 체크 안된경우
			if(arr[n][i] == 1 && arrT[i] == 0) { 
				arrT[i] = 1;
				check(i); // 그 이어진 번호 줄에 가서 또 이어져있는거 있는지 확인하기
			}
		}
	}
}
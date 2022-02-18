package study_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830_김유완 {
	static int[][] arr,resultArr; // 원소 크기는 괜찮으니까
	static int N;
	static long B;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행렬 크기
		B = Long.parseLong(st.nextToken()); // 제곱 횟수 - 숫자 크니까 long
		arr = new int[N][N]; // 기본 받는 배열
		resultArr = new int[N][N]; // 결과값을 가진 배열
		for(int i=0;i<N;i++) { // 입력
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())%1000; // 처음에 1일수도있으니까 자체를 1000으로 나눈 나머지로 하기
			}
		}
		resultArr = check(B,arr);
		// 결과 행렬 출력
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(resultArr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	// 분할 나눠보기
	// 각 원소 1000으로 나눈 나머지 출력해야함
	public static int[][] check(long num,int[][] array) {
		// X 1  이면 결과는  X
		if(num==1) { // 1이면 그냥 원소 나눈 나머지만 확인하기		
			return array;
		}
		// X 4이면 temp 는 X 2제곱 하는것
		int[][] temp = check(num/2,array); // 지수곱셈처럼 짝수면 반틈 먼저 
		temp = matrix(temp,temp);
		// X 5이면 temp 는 X 2제곱 하는것 * X 3제곱 하는 것
		if(num%2==1) {
			// 그 중 X 3제곱 하는 것 (이미 X 2제곱 하는것*X 기본)
			temp = matrix(temp,arr); // 처음에 array로 했는데 생각해보니 계속 변하니 arr원래값을 넣어주기
		}
		return temp;
	}
	// 행렬의 곱셈 - 결과값을 tempArr에 저장
	public static int[][] matrix(int[][] temp1,int[][] temp2) {
		int[][] tempArr = new int[N][N];
		int temp = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp = 0;
				for(int k=0;k<N;k++) {
					// 직접 인덱스 값 써보기
					temp += temp1[i][k]*temp2[k][j]; // 와 여기 배열을 arr로 해놨네
				}
				tempArr[i][j] = temp%1000; // 나머지 값으로 넣어주기
			}
		}
		return tempArr;
	}
}
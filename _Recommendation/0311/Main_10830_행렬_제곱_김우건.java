import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 출처 : 백준 알고리즘
 * 번호 : 10830번  
 * 제목 : 행렬 제곱
 * 
 * 지수 B를 절반으로 분할하고 재귀 호출
 * 더이상 쪼개질 수 없을 때까지 위 내용을 계속 반복한다
 */

public class Main_10830_행렬_제곱_김우건 {

	static int N;
	static long B;
	static int[][] Matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행렬의 크기 N
		B = Long.parseLong(st.nextToken()); // 행렬을 곱하는 횟수
		
		Matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = matrixPower(Matrix, B);
		
		matrixPrint(result);
		
	}
	
	public static int[][] matrixPower(int[][] matrix, long b) { // matrix^b
		
		if (b==1) { // 지수 b가 1이면
			matrixDivision(matrix);
			return matrix;
		}
		
		int[][] result = matrixPower(matrix, b/2); // 지수 b를 절반으로 분할하고 재귀 호출
		
		result = matrixMultiplication(result, result); // result 하위 행렬 거듭 제곱
		
		if (b%2 == 1) { // 지수 b가 홀수인 경우
			result = matrixMultiplication(result, Matrix); // Matrix 행렬과 곱하기
		}
		
		return result;
	}
	
	public static int[][] matrixMultiplication(int[][] m1, int[][] m2) { // m1 행렬과 m2 행렬 곱하기 
		
		int[][] matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		return matrixDivision(matrix);
	}
	
	public static int[][] matrixDivision(int[][] matrix) { // 행렬의 각 원소 1000으로 나누기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] %= 1000;
			}
		}
		
		return matrix;
	}
	
	public static void matrixPrint(int[][] matrix) { // matrix 행렬 출력		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			} System.out.println();
		}
	}
}
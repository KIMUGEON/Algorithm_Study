package Divide_Conquer;

import java.util.Scanner;

public class BOJ_1629_곱셈 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong(); // 밑
		long B = sc.nextLong(); // 지수
		long C = sc.nextLong(); // 거듭제곱 결과 나눌 숫자

		System.out.println(divide(A, B, C)%C);
	}

	private static long divide(long base, long exp, long mod) {
		if(exp == 0) {
			return 1;
		}
		
		long temp = divide(base, exp/2, mod)%mod;
		
		if(exp % 2 == 0) {
			return (temp*temp)%mod;
		}
		else {
			return (((temp*temp)%mod)*base)%mod;
		}
	}

}

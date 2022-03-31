package _0322_다이나믹프로그래밍;

import java.util.Scanner;

public class Main_1904_김준우 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ways = new int[1001];
		
		ways[1] = 1;
		ways[2] = 2;
		
		for(int i = 3; i<=n; i++) {
			ways[i] = (ways[i-2] + ways[i-1])%15746;
		}
		
		System.out.println(ways[n]);
		
	}

}


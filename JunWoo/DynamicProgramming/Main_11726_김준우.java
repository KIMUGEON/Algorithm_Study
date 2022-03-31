package _0322_다이나믹프로그래밍;

import java.util.Scanner;

public class Main_11726_김준우 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ways = new int[1001];
		
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;
		
		for(int i = 3; i<=n; i++) {
			ways[i] = (ways[i-2] + ways[i-1])%10007;
		}
		
		System.out.println(ways[n]);
		
	}

}

/*
package _0322_다이나믹프로그래밍;

import java.util.Scanner;

public class Main_11726_김준우 {
	static int n, result;
	static int[] ways;
	
	public static void puttiles(int cur, int m) {
		if(cur == m) {
			ways[m]++;
			return;
		}
		puttiles(cur+1, m);
		if(m-cur>=2) puttiles(cur+2, m);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ways = new int[n+1];
		result = 0;
		
		
		
		puttiles(n-2,n);
		puttiles(n-1,n);
		System.out.println(n+ " : " + ways[n]%10007);
	}

}*/
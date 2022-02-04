package case_11.Bronze2;

import java.util.Scanner;

public class Main_2231 { //분해합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int result = 0;
		
		for(int i=1; i<N; i++) {
			int num = i; 
			int sum =0;
			
			while(num>0) {
				sum += num % 10;
				num /= 10;
			}
			
			if(sum + i == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		
	}

}

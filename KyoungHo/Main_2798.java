package case_11.Bronze2;

import java.util.Scanner;

public class Main_2798 { //블랙잭

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0;
		int max = 0;
		int a[] = new int[N];
		
		for(int i=0; i<N; i++){
			
			a[i] = sc.nextInt();
			
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					sum = a[i] + a[j] + a[k];
					if(sum > max && M>=sum) {
						max = sum;
					}
				}
			}
		}
		
		System.out.print(max);
	}
}

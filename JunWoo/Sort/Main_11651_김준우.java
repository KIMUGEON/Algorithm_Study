import java.util.Arrays;
import java.util.Scanner;

public class Main_11651_±èÁØ¿ì {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int n =0;n<N;n++) {
			arr[n][1] = sc.nextInt();
			arr[n][0] = sc.nextInt();
		}
		
		Arrays.sort(arr, (e1, e2) ->{
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][1] + " " + arr[i][0]);
		}
		
	}

}

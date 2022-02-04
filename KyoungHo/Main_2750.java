package case_12.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2750 { // 수 정렬하기1

	public static void main(String[] args) throws IOException {
		
		//Scanner, System.out.print
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		
//		int arr[] = new int[N];
//		
//		for(int i=0; i<N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		Arrays.sort(arr);
//
//		for(int i=0; i<N; i++) {
//			System.out.println(arr[i]);
//		}
		
		//BufferedReader, StringBuilder
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append(System.getProperty("line.separator")); // 줄바꿈 \n도 가능
		}
		System.out.println(sb);
		
		br.close();
		
	}

}

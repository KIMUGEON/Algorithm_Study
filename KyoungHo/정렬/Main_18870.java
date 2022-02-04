package case_12.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_18870 { // 좌표 압축

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		int X[] = new int[N]; //좌표 배열
		int sX[] = new int[N]; //좌표 배열 (정렬할 배열)
		Map<Integer, Integer> hMap = new HashMap<>(); //중복값 하용X

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
//			X[i] = sX[i] = sc.nextInt();
			X[i] = sX[i] = Integer.parseInt(st.nextToken()); //좌표 넣어주기
		}

		Arrays.sort(sX); //정렬


		for (int i : sX) { // 정렬된 배열을 map에 넣어줌
			if (!hMap.containsKey(i)) {//중복값이 없을경우 hMap에 sX배열의 값과 count값을 넣어줌
				hMap.put(i, count);
				count++;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i : X) {
//			System.out.print(hMap.get(i) + " ");
			int a = hMap.get(i);
			sb.append(a).append(' ');
		}
		System.out.println(sb);
	}
}
//주석은 시간초과...
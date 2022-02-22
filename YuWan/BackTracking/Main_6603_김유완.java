package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_김유완 {
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] arr;
	static boolean[] is; // 방문확인
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) { // 얼만큼 들어오는지 모르니까 0들어오면 끝
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break; // 입력마지막 줄에는 0
			arr = new int[k]; // 배열
			is = new boolean[k];
			for(int i=0;i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			per(0,0);
			sb.append("\n"); // 중간에 한칸 비워줘야함
		}
		System.out.println(sb);
	}
	public static void per(int j,int count) {
		if(count == 6) { // 6개뽑아서 만들어야하니까
			for(int i=0;i<k;i++) {
				if(is[i]==true) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=j;i<k;i++) {
			if(is[i]==false) {
				is[i] = true;
				per(i+1,count+1); // index변수 잘보고 쓰자
				is[i] = false;
			}		
		}
	}
}
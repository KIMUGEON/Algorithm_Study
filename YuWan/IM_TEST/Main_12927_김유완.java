package study_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12927_김유완 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int count = 0; // 스위치 몇번 눌러야하는지
		int[] arr = new int[str.length()+1]; // 1번부터 사용
		// 켜져있으면 Y 꺼져있으면 N
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'Y') arr[i+1] = 1; // on
			else arr[i+1] = 0; // off
		}
		// 모든 전구를 끄기 위해서 스위치를 몇 번 눌러야 하는지 출력
		// 만약, 모든 전구를 끌 수 없다면 -1
		// 배수니까 앞부터 해보면 됨
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == 1) {
				for (int j = i; j < arr.length; j++) {
					if(j%i == 0) { // 배수이면 바꾸기
						if(arr[j] == 1) arr[j] = 0;
						else arr[j] = 1;
					}
				}
				count++;
			}
		}
		// 확인
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == 1) count = -1; // 한바퀴 다 했는데 안되는것
		}
		// 출력
		System.out.println(count);
	}
}
package study_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_김유완 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean is = false;
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] arr = new char[str.length()];
			for (int j = 0; j < str.length(); j++) {
				arr[j] = str.charAt(j);
				is = false;
				if(j>0) {
					if(arr[j]!=arr[j-1]) { // 전과 다르면 그전에 이 값이 나왔는지 확인				
						for (int k = 0; k < j-1; k++) {
							if(arr[k]==arr[j]) {
								is = true;
								break;
							}
						}
					}
				}
				if(is) break; // 하나라도 전에 나왔던 값이 나왓다? 나가기
			}
			if(!is) result++; // 끝까지 확인했는데도 같은 값이 다시 안나타나는거
		}
		System.out.println(result);
	}
}
package study_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3107_김유완 {
	static StringBuilder sb = new StringBuilder(); // 결과
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		str = br.readLine();
		int count = 0;  // 콜론 확인하기
		int i = 0;
		int flag = 0;
		boolean is = false; // 마지막 체크하려고
		// 콜론 중심으로 4자리씩 되어야함
		for (i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if(temp == ':') {
				is = true;
				if(count == 0) {
					if(flag >= 1) { // ::있는 곳 확인
						int cnt = 0;
						for (int r = 0; r < str.length(); r++) {
							if(str.charAt(r) == ':') cnt++;
						}
						// :: 만 있는 경우::1
						if(str.charAt(0)==':' && str.charAt(str.length()-1)==':') cnt = cnt-2;
						else if(str.charAt(0)==':' || str.charAt(str.length()-1)==':') cnt--;
						for (int r = 0; r < 8-cnt; r++) {
							add(0,0);
						}
					}
				}
				else add(i,count);
				count = 0;
				flag++;
			}
			else {
				count++;
				is = false;
			}
		}
		if(!is) add(i,count);
		System.out.println(sb);
	}
	public static void add(int i,int num) {
		for (int t = 0; t < 4-num; t++) { // 0넣기
			sb.append("0");
		}
		for (int t = i-num; t < i; t++) { // 그 뒤 원래 값 넣기
			char temp = str.charAt(t);
			sb.append(temp);
		}
		if(i != str.length() && sb.length() != 39) { // 마지막 :안나오기
			sb.append(":");
		}
	}
}

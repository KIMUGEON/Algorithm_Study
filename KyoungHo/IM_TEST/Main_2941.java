package IM_Test.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  [입력]
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

  [출력]
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */
public class Main_2941 {//크로아티아 알파벳

	public static void main(String[] args) throws IOException {
//		===============================  입력   =======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String line = br.readLine();
		
//		===============================  풀이   =======================================
		for(int i=0; i<str.length; i++) { //크로아티아 알파벳 만큼 돌아주기
			if(line.contains(str[i])) { //크로아티아 알파벳 찾으면 0으로 바꿔주기
				line = line.replace(str[i], "0");
			}
		}
		
//		===============================  출력   =======================================
		System.out.println(line.length());
	}

}

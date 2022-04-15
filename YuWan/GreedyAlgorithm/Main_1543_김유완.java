package study_0415;

import java.util.Scanner;

public class Main_1543_김유완 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); // 공백도 있을 수 있음
		String s = sc.nextLine(); // 검색할 단어
		int result = 0; // 결과값
		int index = 0;
		int strLength = str.length(); // 주어진 문서 길이
		int sLength = s.length(); // 검색할 애 길이
		while(true) {
			if(index >= strLength) break; // 확인끝
			int count = 0;
			int j = 0;
			for (int i = index; i < index+sLength; i++) {
				if(i >= strLength) break; // 예제 3처럼 확인하다 범위 벗어난 경우
				if(str.charAt(i) == s.charAt(j++)) count++; // 값 일치하면 count
				else break;
			}
			if(count == sLength) { // 다 확인 되면 result에 추가하기
				index += sLength; // 중복안되니까 넘기기
				result++;
			}
			else index++;
		}
		System.out.println(result);
	}
}
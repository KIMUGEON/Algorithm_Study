package String;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/2941
 * 걸린 시간 : 15분
 * 리뷰 : 처음에는 문자열의 =, -, j로 끝나는 위치를 찾고 그 위치의 앞부분을 탐색해서
 * 변경해야하는 문자열에 해당하는 경우를 모두 체크하는 방법으로 문제를 풀려했다.
 * 하지만 이 방법은 모든 경우를 if문으로 다 체크해야줘야하기 때문에 비효율적이므로,
 * String의 replaceAll api를 사용해서 해당 문자열을 전부 한글자의 문자로 변환시키는 방법을 생각해냈다.
 */
public class BOJ_2941_크로아티아_알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next(); // 입력받은 문자열
		String[] target = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}; // 변경해야하는 문자열

		for (String s : target) { 
			// target에 해당하는 부분 문자열 모두 "0"으로 바꾸기
			input = input.replaceAll(s, "0");
		}
		
		System.out.println(input.length()); // 변환된 입력 문자열의 길이 출력
	}

}

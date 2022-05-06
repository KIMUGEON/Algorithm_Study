package String;

import java.util.Scanner;
import java.util.Stack;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/9935
 * 걸린 시간 : 60분
 * 리뷰 : 처음엔 replaceAll 이나 contain 같은 문자열 라이브러리로 계속 시도해봤지만,
 * 메모리 초과가 계속 떴다. 문자열 길이가 최대 1,000,000 이므로 시간복잡도가 O(N^2)가 나오는
 * 문자열 라이브러리를 사용하는 대신, 스택을 활용하여 직접 구현을 해줘야 하는 문제였다.
 * 스택을 활용해야 한다는걸 생각하기가 어려웠는데, 자료구조를 효율적으로 사용해서
 * 최대한 시간,공간 복잡도를 줄이는 연습을 자주 해봐야 할 것 같다.
 */
public class BOJ_9935_문자열_폭발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine(); // 입력 문자열
		char[] target = sc.nextLine().toCharArray(); // 폭발 문자열 -> char형 배열로 변환
		
		Stack<Character> stack = new Stack<>(); // 문자를 담을 스택
		int targetLen = target.length; // 폭발 문자열의 길이
		
		// 입력 문자열 한 글자씩 스택에 넣기
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i)); // i번째 문자 스택에 push
			
			int stSize = stack.size(); // 현재 스택의 크기
			
			// 스택의 크기가 폭발 문자열 길이보다 크거나 같을 경우
			if (stSize >= targetLen) {
				boolean flag = true; // 폭발 여부
				
				// 스택의 top부터 내려가면서 폭발 문자와 하나씩 비교
				for (int j = 0; j < targetLen; j++) {
					// 폭발 문자와 같지 않은 문자가 있을 경우
					if (stack.get(stSize-1-j) != target[targetLen-1-j]) {
						flag = false;
						break;
					}
				}
				
				// 폭발을 해야할 경우
				if (flag) {
					// 스택의 top부터 폭발 문자열 길이만큼 꺼내기
					for (int j = 0; j < targetLen; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 스택이 비었을 경우 "FRULA" 출력
		if (stack.size() == 0) {
			sb.append("FRULA");
		}
		// 남은 문자열 출력
		else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}

}

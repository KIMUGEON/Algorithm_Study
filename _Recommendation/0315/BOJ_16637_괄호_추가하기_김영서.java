package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/16637
 * 걸린 시간 : 100분
 */
public class BOJ_16637_괄호_추가하기 {
	static int N, opNum, res;
	static List<Integer> num;
	static List<Character> op;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수식의 길이
		num = new ArrayList<Integer>(); // 피연산자(숫자)를 저장할 리스트
		op = new ArrayList<Character>(); // 연산자를 저장할 리스트
		String s = br.readLine(); // 수식
		
		for (int i = 0; i < N; i++) {
			if(i % 2 == 0) num.add(s.charAt(i)-'0'); // 피연산자 저장
			else op.add(s.charAt(i)); // 연산자 저장
		}
	
		opNum = op.size(); // 연산자의 개수
		isSelected = new boolean[opNum]; // 연산에 괄호를 칠지 안칠지를 선택하는 배열
		res = Integer.MIN_VALUE; // 연산의 최댓값 (결과값)
		
		if (opNum == 0) { // 연산자가 0개이면 피연산자 1개가 결과값
			res = num.get(0);
		}
		else if(opNum == 1) { // 연산자가 1개이면 연산 1번한 값이 결과값
			switch(op.get(0)) {
			case '+':
				res = num.get(0) + num.get(1);
				break;
			case '-':
				res = num.get(0) - num.get(1);
				break;
			case '*':
				res = num.get(0) * num.get(1);
				break;
			}
		}
		else { // 연산자가 2개 이상이면 괄호를 칠 연산 구하러가기
			pickOp(0);
		}
		
		System.out.println(res); // 결과 출력
	}

	// 괄호를 칠지 안칠지의 모든 경우의수를 구하는 함수
	private static void pickOp(int cnt) { // cnt: 직전까지 고려한 연산자의 개수
		if(cnt == opNum) {
			// 모든 연산자를 고려했다면 계산하러 가기
			calculate();
			return;
		}
		
		// 직전의 연산자에 이미 괄호가 쳐져있다면 현재 연산자는 괄호 X (괄호가 중첩되면 안되므로)
		if(cnt-1 >=0 && isSelected[cnt-1]) {
			isSelected[cnt] = false;
			pickOp(cnt+1);
		}
		// 직전의 연산자에 괄호가 쳐져있지 않다면 현재 연산자는 괄호 O or 괄호 X
		else {
			// 괄호를 치는 경우
			isSelected[cnt] = true;
			pickOp(cnt+1);
			
			// 괄호를 치지 않는 경우
			isSelected[cnt] = false;
			pickOp(cnt+1);
		}
		
	}

	private static void calculate() {
		int ans = 0; // 연산 결과
		
		//맨 처음 연산 계산하기 (ans 초기화)
		// 두번째 연산에 괄호가 쳐져있지 않는 경우 -> 그냥 계산하기
		if(!isSelected[1]) {
			switch(op.get(0)) {
			case '+':
				ans = num.get(0) + num.get(1);
				break;
			case '-':
				ans = num.get(0) - num.get(1);
				break;
			case '*':
				ans = num.get(0) * num.get(1);
				break;
			}
		}
		// 두번째 연산에 괄호가 쳐있는 경우 -> 두번째 연산 먼저 수행하고 첫번째 연산 계산하기
		else {
			int temp = 0;
			
			// 두번째 연산
			switch(op.get(1)) {
			case '+':
				temp = num.get(1) + num.get(2);
				break;
			case '-':
				temp = num.get(1) - num.get(2);
				break;
			case '*':
				temp = num.get(1) * num.get(2);
				break;
			}
			
			// 두번째 연산값에 첫번째 연산 수행
			switch(op.get(0)) {
			case '+':
				ans = num.get(0) + temp;
				break;
			case '-':
				ans = num.get(0) - temp;
				break;
			case '*':
				ans = num.get(0) * temp;
				break;
			}
		}
		
		// 나머지 연산 수행하기
		for (int i = 1; i < opNum; i++) {
			// 괄호가 쳐져있는 연산은 pass (이미 수행함)
			if(isSelected[i]) continue;
			// 현재 연산에 괄호가 쳐져있지 않고 다음 연산에 괄호가 쳐져있는 경우 
			// -> 괄호 연산 먼저 수행하고 현재 연산 계산하기
			else if(!isSelected[i] && i+1 < opNum && isSelected[i+1]) {
				int temp = 0;
				
				// 괄호 연산
				switch(op.get(i+1)) {
				case '+':
					temp = num.get(i+1) + num.get(i+2);
					break;
				case '-':
					temp = num.get(i+1) - num.get(i+2);
					break;
				case '*':
					temp = num.get(i+1) * num.get(i+2);
					break;
				}
				
				// 괄호 연산값에 현재 연산 계산
				switch(op.get(i)) {
				case '+':
					ans += temp;
					break;
				case '-':
					ans -= temp;
					break;
				case '*':
					ans *= temp;
					break;
				}
			}
			// 나머지 경우 -> 그냥 평범하게 연산 수행
			else {
				switch(op.get(i)) {
				case '+':
					ans += num.get(i+1);
					break;
				case '-':
					ans -= num.get(i+1);
					break;
				case '*':
					ans *= num.get(i+1);
					break;
				}
			}
		}
		
		res = Math.max(res, ans); // 연산값이 최댓값이면 갱신
	}

}

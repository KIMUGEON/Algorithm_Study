package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 * 걸린 시간 : 100분
 * 리뷰 : + 연산을 수행하는 곳에 괄호를 쳐서 먼저 수행해주고, 그 후 처음부터 차례로 남은 - 연산을 수행해주었다.
 * 0으로 시작하는 숫자를 정수형으로 바꿔주기 위해 문자열을 다루는 과정과,
 * + 연산만을 먼저 수행하기 위해 어떤 자료구조를 이용해서 어떻게 처리해줘야 하는지 때문에 오랜 시간이 걸린 문제였다.
 */
public class BOJ_1541_잃어버린_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] nums = s.split("\\+|-"); // split으로 피연산자만 저장
		int N = nums.length; // 피연산자 개수
		char[] op = new char[nums.length-1]; // 연산자 저장하는 배열
		int cnt = 0;
		int res = 0;
		
		// 연산자 뽑아내기
		for(int i=0; i<s.length(); i++) {
			// 문자가 - 또는 + 이면 그 연산자 배열에 저장
			if(s.charAt(i) == '-' || s.charAt(i) == '+') {
				op[cnt++] = s.charAt(i);
			}
		}
		
		// 0으로 시작하는 피연산자 0 제거하기 ex) "00095" -> "95"
		for(int i=0; i<N; i++) {
			String n = nums[i];
			
			if(n.equals("00") || n.equals("000") || n.equals("0000") || n.equals("00000")) {
				nums[i] = "0";
				continue;
			}
			
			// 피연산자가 일의 자리 수이거나, 0으로 시작하지 않으면 pass
			if(n.length() == 1 || n.charAt(0) != '0') continue;
			
			// 문자가 0으로 시작하지 않는 지점을 찾고 그 지점부터 끝까지 복사해서 값 바꾸기
			for(int j=0; j<n.length(); j++) {
				if(n.charAt(j) != '0') {
					nums[i] = n.substring(j);
					break;
				}
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(); // 피연산자를 저장하는 리스트
		
		// 피연산자 전부 int형으로 바꿔서 리스트에 넣기
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(nums[i]));
		}
		
		int pNum = 0; // 리스트에서 현재 주목하고 있는 포인터
		
		// + 연산자만 미리 먼저 수행하기 (+ 연산자는 괄호 쳐서 먼저 수행)
		for(int i=0; i<op.length; i++) {
			if(op[i] == '+') { // 연산자가 +이면 피연산자 2개를 더해서 포인터 자리에 넣어주기
				int temp = list.get(pNum) + list.get(pNum+1); // 피연산자1 + 피연산자2
				list.remove(pNum);  // 피연산자1 제거
				list.set(pNum, temp); // 피연산자2를 temp 값으로 대체
			}
			else { 
				pNum++; // 포인터 증가
			}
		}
		
		if(list.size() == 1) {
			// 피연산자가 1개이면 이미 연산이 끝나있는 상태이므로 그대로 출력
			System.out.println(list.get(0));
			return; // 프로그램 종료
		}
		
		// 피연산자가 2개 이상이면 결과값을 피연산자1-피연산자2로 초기화
		res = list.get(0) - list.get(1);
		
		// 남은 연산 수행(-연산자만 남았으므로 -만 해줌)
		for(int i=2; i<list.size(); i++) {
			res -= list.get(i);
		}
		
		// 결과 출력
		System.out.println(res);
	}
}

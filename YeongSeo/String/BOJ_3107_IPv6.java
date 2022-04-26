package String;

import java.util.Scanner;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/3107
 * 걸린 시간 : 40분
 * 리뷰 : 문자열을 split 해줄 때 앞이나 중간에 데이터가 없을 경우에는 처리를 하지만,
 * 마지막에 데이터가 없을 경우 처리를 하지 않아서 1:: -> ["1"] 이렇게 처리되는 문제가 발생하였다.
 * split의 두번째 인자에 -1을 넣어주면 마지막 공백도 처리를 해줘서 원하던 결과대로 -1 줬을 시 1:: -> ["1","",""] 로 split 할 수 있었다.
 */
public class BOJ_3107_IPv6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); // 문자열 입력
		
		// ":" 을 기준으로 split, 두번째 인자로 -1을 주면 1:: 과 같이 "" 공백도 처리를 해준다.
		// -1 안줬을 시 1:: -> ["1"]	-1 줬을 시 1:: -> ["1","",""]
		String[] splits = s.split(":", -1);
		
		// 각 그룹에 축약된 0 집어넣기 
		for (int i = 0; i < splits.length; i++) {
			String group = splits[i]; // i번째 그룹 문자열
			
			// 그룹이 비어있고, 첫번째이거나 마지막 그룹이면 pass
			if (group.equals("") && i != 0 && i != splits.length - 1) continue;
			
			// 0을 붙여줘야하는 개수
			int zeroCnt = 4 - group.length();
//			String zero = "0".repeat(zeroCnt); // 자바 11 이상에서만 가능
			String zero = ""; // 0 문자열
			
			// 0을 붙여줘야하는 개수만큼 0 나열해서 0 문자열 만들기
			while (--zeroCnt >= 0) {
				zero += "0";
			}
			
			// i번째 그룹 0 문자열 + 원래 문자열로 바꾸기
			splits[i] = zero + group;
		}
		
		// 복원된 IPv6주소 출력
		for (int i = 0; i < splits.length; i++) {
			// i번째 그룹이 비어있을 경우 (복원이 안되었을 경우)
			if(splits[i].equals("")) {
				int cnt = 8 - splits.length + 1; // 0으로 이루어진 연속된 그룹의 개수
				// cnt만큼 0000 그룹 출력하기
				while (--cnt >= 0) {
					System.out.print("0000");
					if (i != splits.length - 1) System.out.print(":"); // 마지막 그룹이 아닐 경우 콜론 출력
				}
			}
			// i번째 그룹이 복원되었을 경우
			else {
				System.out.print(splits[i]); // i번째 그룹 출력
				if (i != splits.length - 1) System.out.print(":"); // 마지막 그룹이 아닐 경우 콜론 출력
			}
		}
		
	}

}

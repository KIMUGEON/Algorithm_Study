package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1316
 * 걸린 시간 : 20분
 * 리뷰 : 알파벳이 소문자로만 이루어졌다 했으므로 (char형 알파벳 - 97)을 하면
 * a부터 z까지 각가 0부터 25의 값이 나오게 된다.
 * 이를 통해 알파벳이 이미 쓰여졌는지 사용 체크를 하면서 그룹 단어에 해당한지 아닌지 검사해주었다.
 */
public class BOJ_1316_그룹_단어_체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 단어의 개수
		String[] words = new String[N]; // 단어 배열
		boolean[] isChecked; // 알파벳이 이미 쓰여졌는지 체크하는 배열
		
		// 단어 입력
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		// 단어 하나씩 꺼내서 그룹 단어인지 체크
		for (String word : words) {
			isChecked = new boolean[26]; // 알파벳 체크 배열 초기화
			char ch = word.charAt(0); // 첫번째 알파벳 철자
			isChecked[ch-97] = true; // 첫번째 알파벳 사용 체크
			
			// 두번째 철자부터 끝까지 방문하기
			for (int i = 1; i < word.length(); i++) {
				// 연속된 알파벳 철자가 나왔으면 pass
				if (word.charAt(i) == ch) continue;
				
				// 다른 알파벳 철자가 나왔으면 ch에 새로운 알파벳 저장
				ch = word.charAt(i);
				
				// 새로운 알파벳이 이미 쓰여졌을 경우 -> 그룹 단어가 아님
				if (isChecked[ch-97]) {
					// 전체 단어 개수에서 1 감소시키고 break
					N -= 1;
					break;
				}
				
				// 새로운 알파벳이 아직 안쓰여졌을 경우 -> 사용 체크
				isChecked[ch-97] = true;
			}
		}
		
		// 결과 출력
		System.out.println(N);
	}

}

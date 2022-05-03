package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/20055
 * 걸린 시간 : 100분
 * 리뷰 : 처음에는 컨베이어 벨트 그림이 위에서 본 구조인줄 알고, 원형 형태로 로봇을 옮겨주는 줄 알았다..
 * 하지만 문제를 잘 읽어보니 "위아래로 감싸며 돌고 있다" 라고 명시되어 있고,
 * 심지어 N번 칸이 있는 위치를 "내리는 위치"라고 친절하게 써져 있었는데 이를 간과해서 시간을 좀 빼앗겼다ㅜㅜ
 * 항상 문제 꼼꼼히 읽기!!
*/
public class BOJ_20055_컨베이어_벨트_위의_로봇 {
	static int N, K, beltSize, step;
	static int[] belt;
	static boolean[] haveRobot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트의 길이
		K = Integer.parseInt(st.nextToken()); // 내구도 0인 칸 K개 이상 조건
		beltSize = 2*N; // 위아래 벨트의 길이
		belt = new int[beltSize]; // 벨트의 각 칸의 내구도 배열
		haveRobot = new boolean[N]; // 로봇이 올려져있는지 여부를 체크할 배열
		
		// 내구도 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < beltSize; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		step = 0; // 총 몇번 단계가 수행되었는지
		
		// K가 0 이하가될때까지 시뮬레이션 단계 실행 
		// (각 칸의 내구도가 0이 되면 바로 K 1 감소)
		while (K > 0) {
			step++; // 진행된 단계 횟수 1 증가
			phase1(); // 1번째 과정 실행
			phase2(); // 2번째 과정 실행
			phase3(); // 3번째 과정 실행
		}

		System.out.println(step); // 결과 출력
	}

	// 위아래 벨트를 한칸씩 회전시키는 함수 -> 벨트의 내구도값과 로봇을 함께 이동시키기
	private static void phase1() {
		int temp = belt[beltSize-1]; // 마지막칸 벨트의 내구도값 기억
		// 벨트의 내구도값 한칸씩 옮기기
		for (int i = beltSize-1; i > 0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = temp; // 첫번재칸 벨트에 기억했던 temp값 저장
		
		haveRobot[N-1] = false; // 내리는 위치에 있는 로봇 내리기
		// 벨트의 로봇위치 한칸씩 옮기기 
		// (아래벨트에는 로봇이 절대 위치할 수 없으니 윗벨트만 실행해줌)
		for (int i = N-1; i > 0; i--) {
			haveRobot[i] = haveRobot[i-1];
		}
		haveRobot[0] = false; // 올리는 위치에는 로봇이 항상 없으므로 false
	}
	
	// 벨트 위의 로봇을 한칸씩 이동시키는 함수 -> 벨트의 내구도값은 그대로 두고 로봇만 이동시키기
	private static void phase2() {
		haveRobot[N-1] = false; // 내리는 위치에 있는 로봇 내리기
		
		// 벨트 위의 로봇 한칸씩 이동
		for (int i = N-2; i >= 0; i--) {
			// 현재 칸에 로봇이 없을 경우 pass
			if (!haveRobot[i]) continue;

			int next = i+1; // 이동할 위치의 인덱스값
			// 이동하려는 칸에 로봇이 없고, 그 칸의 내구도가 1이상일 경우에만 이동
			if (!haveRobot[next] && belt[next] >= 1) {
				haveRobot[next] = true;
				haveRobot[i] = false;
				belt[next] -= 1;
				
				// 이동한 칸의 내구도가 0이 되었으면 K 1 감소
				if (belt[next] == 0) K--;
			}
		}
	}
	
	// 올리는 위치에 로봇을 올리는 함수
	private static void phase3() {
		// 첫번째 칸에 로봇이 없고, 그 칸의 내구도가 0이 아닐 경우에만 로봇 올리기
		if (!haveRobot[0] && belt[0] != 0) {
			haveRobot[0] = true;
			belt[0] -= 1;
			
			// 내구도가 0이 되었으면 K 1 감소
			if (belt[0] == 0) K--;
		}
	}

}

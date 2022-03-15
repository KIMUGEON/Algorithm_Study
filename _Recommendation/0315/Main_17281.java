package A_Test.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
  [입력]
첫째 줄에 이닝 수 N(2 ≤ N ≤ 50)이 주어진다. 
둘째 줄부터 N개의 줄에는 각 선수가 각 이닝에서 얻는 결과가 1번 이닝부터 N번 이닝까지 순서대로 주어진다. 
이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다. 
각 결과가 의미하는 정수는 다음과 같다.
안타: 1
2루타: 2
3루타: 3
홈런: 4
아웃: 0
각 이닝에는 아웃을 기록하는 타자가 적어도 한 명 존재한다.

  [출력]
아인타팀이 얻을 수 있는 최대 점수를 출력한다.
 */

public class Main_17281 {//⚾

	static int N, max, game[][], order[];
	static boolean check[];
	
	public static void main(String[] args) throws IOException {
//		============================  입력   =======================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine()); //이닝 수
		game = new int[N+1][10]; //선수가 얻는 결과
		order = new int[10]; //선수 순서
		check = new boolean[10];
		max = Integer.MIN_VALUE;
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<10; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		============================  풀이   =======================================
		order[4] = 1; //1번 선수는 4번타자
		
		permutation(1); //선수의 순서 설정, 순열
		
//		============================  출력   =======================================
		System.out.println(max);
		
	}

//	================ permutation ================
	private static void permutation(int idx) {
		if(idx>9) {//9명 선수까지 완료하면
			play(); //게임 시작
			return;
		}
		
		if(idx == 4) { //4번타자는 이미 정함
			permutation(idx+1);
			return;
		}
		
		for(int i=2; i<10; i++) { //1번 선수는 4번타자로 미리 정해놔서 2부터 시작, 순열
			if(!check[i]) {
				check[i] = true;
				order[idx] = i;
				permutation(idx+1);
				check[i] = false;
			}
		}
	}

//	=========== play ============
	private static void play() {
		int score = 0; //점수
		int turn = 1; //턴
		int inning = 1; //이닝
		int out = 0; //아웃
		int base[] = new int[4]; //홈, 1루, 2루, 3루
		
		while(inning <= N) { //이닝이 끝날때까지
			
			if(out == 3) { //3아웃이면
				inning++; //이닝수 증가
				out=0; //아웃카운트 0으로
				Arrays.fill(base, 0); //초기화
				continue;
			}
			
			int player = order[turn]; //타순
			int result = game[inning][player]; //선수가 얻는 결과
			
			base[0] = 1; //홈에 타자있음
			
			switch(result) { //선수가 얻는 결과, 1:안타, 2:2루타, 3:3루타, 4:4루타, 0:아웃
			case 1: //안타 : 주자는 다음 베이스로 (0이면 1로), 3루 주자는 들어오고 점수 냄
				score += base[3];
				base[3] = base[2];
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 0;
				break;
				
			case 2: //2루타 : 주자는 다음 베이스로 (0이면 2로), 2루부터 3루 주자까지 들어오고 점수 냄
				score += base[3] + base[2];
				base[3] = base[1];
				base[2] = base[0];
				base[0] = base[1] = 0;
				break;
				
			case 3: //3루타 : 주자는 다음 베이스로 (0이면 3으로), 1루부터 3루 주자까지 들어오고 점수 냄
				score += base[3] + base[2] + base[1];
				base[3] = base[0];
				base[0] = base[1] = base[2] = 0;
				break;
				
			case 4: //홈런 : 모든 주자 들어오고 점수 냄
				score += base[3] + base[2] + base[1] + base[0];
				base[0] = base[1] = base[2] = base[3] = 0;
				break;
			
			default:
				out++;
				base[0] = 0;
				break;
			}
			
			max = Math.max(max, score); //최대점수 구하기
			
			if(turn == 9) { // 9번타자까지 쳤으면 1번타자부터 다시
				turn = 1;
			} 
			
			else {
				turn++;
			}
			
		}
		
	}
}

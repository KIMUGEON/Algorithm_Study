import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_김준우 {
	static int N, R;
	static int gap;
	static int[][] stat;	//능력치
	static int[] team1, team2;
	static int statsum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		R = N/2;
		
		stat = new int[N][N];
		team1 = new int[R];
		team2 = new int[R];
		gap = 101; statsum = 0;
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<N;j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
				statsum += stat[i][j];
			}
		}
		
		MakeTeam(0,0);
		sb.append(gap);
		System.out.println(sb);
		
	}
	
	public static void MakeTeam(int cnt, int start) {
		if(cnt == R) {
			int stat1 = 0; int stat2 = 0; //각 팀의 능력치
			int pick1 = 0; int pick2 = 0;
			int gap_t = 0;	//각 팀의 능력치 차이
			
			//상대팀 배열 저장
			for(int i = 0;i<N;i++) {
				//team1에 들어있는 값을 차례대로 탐색한다. i값과 같다면 다음 값을 가리킨다.
				if(team1[pick1] == i) {
					if(pick1<R-1)pick1++;
				}
				//i가 team1에 들어있지 않기때문에 team2에 i값을 저장하고 탐색 인덱스 증가. 
				else {
					team2[pick2] = i;
					if(pick2<R-1)pick2++;
				}
			}
			
			//팀별 점수를 각각 합친다.
			for(int i = 0;i<R;i++) {
				for(int j =0;j<R;j++) {
					if(i!=j) {	//자기 자신과의 조합인 경우는 제외
						stat1 += stat[team1[i]][team1[j]];
						stat2 += stat[team2[i]][team2[j]];
					}
				}
			}
			
			gap_t = Math.abs(stat1-stat2);
			if(gap_t<gap) {
				gap = gap_t;
			}
			
			return;
		}
		for(int i = start;i<N;i++) {
			team1[cnt] = i;
			MakeTeam(cnt+1,i+1);
		}
	}

}

package _0222_백트래킹;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_김준우 {
	static int k;	//숫자개수
	static int C = 6;	//복권 뽑는 개수
	static int[] S, selected;	//S: 입력받은 집합 S, selected: 선택된 6개 수 배열
	static StringBuilder sb= new StringBuilder();
	
	public static void select(int cnt, int start) {
		//6개가 모두 선택되면 Stringbuilder를 통해 출력
		if(cnt == C) {
			for(int i = 0;i<6;i++) {
				sb.append(selected[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//6개 선택될 때까지 숫자 선택
		for(int i = start; i<k; i++) {
			selected[cnt] = S[i];
			select(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;	//0이 입력되면 반복문 종료
			S = new int[k];
			for(int i = 0; i<k;i++) {
				S[i] =Integer.parseInt(st.nextToken());
			}
			Arrays.sort(S);
			selected = new int[C];
			
			select(0,0);	//숫자선택
			
			sb.append("\n");
		}
		System.out.println(sb);	//출력
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int normal[] = new int[100]; //정해놓은 구간 및 속도
		int test[] = new int[100]; //테스트용 구간 및 속도
		int idx=0;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken()); //몇층동안 
			int speed = Integer.parseInt(st.nextToken()); //어떤 속도로
			
			for(int j=idx;j<floor+idx;j++) //해당하는 구간에 속도 넣기
				normal[j]=speed;
			
			idx+=floor; //층 수 늘려주기
		}
		idx=0;
		for(int i=0;i<M;i++) //테스트
		{
			st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken()); //몇층동안
			int speed = Integer.parseInt(st.nextToken()); //어떤속도로
			
			for(int j=idx;j<floor+idx;j++) //해당 구간에 속도 넣기
				test[j]=speed;
			idx+=floor;
		}
		int result = 0;
		for(int i=0;i<100;i++)
			result = Math.max(result, test[i]-normal[i]); //모든 구간 탐색하며 값의 차이가 가장 큰 값 넣기.
		
		System.out.println(result);
		
		
	}

}

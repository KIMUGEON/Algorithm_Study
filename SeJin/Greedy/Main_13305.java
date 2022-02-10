import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int edge[] = new int[N-1]; //도시간 거리 (4개도시일시 거리는 3개)
		int vertex[] = new int[N]; // 도시 기름값
		long result=0; //결과값
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N-1;i++)
			edge[i]=Integer.parseInt(st.nextToken()); //도시간 거리 받아오기
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			vertex[i] =Integer.parseInt(st.nextToken()); // 도시별 기름값 받아오기
		
		//풀이 방법 : 각 도시를 지나오며 이전에 있던 도시보다 기름값이 저렴하면 해당 도시까지의 거리만 기름을 넣고 다시 찾는 방법
		
		int preOilValue = vertex[0]; // 마지막으로 기름을 넣은곳의 가격
		long distance = 0;// 누적 도시간 거리
		for(int i=1;i<N;i++)
		{
			if(preOilValue >= vertex[i]) // 기름값이 저렴한 도시를 만났을 때 (누적 거리 * 지금까지 온 도시중 가장 저렴한 곳의 가격)
			{
				distance += edge[i-1];
				result += distance * preOilValue;
				preOilValue = vertex[i];
				distance = 0;
			}
			else //기름값이 더 비싸면 거리 추가하고 넘어가기
				distance+=edge[i-1];
		}
		if(distance!=0)
			result+=preOilValue * distance;
		System.out.println(result);
	}

}

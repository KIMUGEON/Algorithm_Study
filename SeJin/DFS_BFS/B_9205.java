import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9205 {
	public static class location
	{
		int x;
		int y;
		public location(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static int homeX, targetX;
	static int homeY, targetY, n;
	static boolean visited[];
	static ArrayList<location> cu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++)
		{
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			//집 좌표
			
			visited=new boolean[n];
			cu = new ArrayList<>();
			//편의점 좌표 넣을 리스트
			for(int j=0;j<n;j++)
			{
				st = new StringTokenizer(br.readLine());
				int cuX = Integer.parseInt(st.nextToken());
				int cuY = Integer.parseInt(st.nextToken());
				
				cu.add(new location(cuX,cuY));
			}
			st = new StringTokenizer(br.readLine());
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());
			if(bfs())
				System.out.println("happy");
			else
				System.out.println("sad");
				
		}

	}
	
	public static boolean bfs()
	{
		Queue<location> q = new LinkedList<>();
		q.offer(new location(homeX,homeY)); //출발지점인 집
		
		while(!q.isEmpty())
		{
			location temp = q.poll();
			
			if(Math.abs(temp.x - targetX) + Math.abs(temp.y-targetY) <= 1000) //맥주 한박스로 갈수있는 거리에 target이 있을 시 return
				return true;
			
			for(int i=0;i<n;i++)
			{
				if(visited[i]==false)
				{
					if(Math.abs(temp.x - cu.get(i).x) + Math.abs(temp.y-cu.get(i).y) <= 1000)//맥주 한박스 이내로 갈 수 있는 거리 다 찾아서 bfs반복
					{
						visited[i]=true;
						q.offer(new location(cu.get(i).x, cu.get(i).y));//해당 편의점을 출발지로 설정하고 다시 bfs
					}
				}
			}
		}
		return false;
	}

}

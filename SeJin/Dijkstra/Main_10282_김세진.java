import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_김세진 {

	static class computer implements Comparable<computer>
	{
		int connect;
		int time;
		public computer(int connect, int time) {
			super();
			this.connect = connect;
			this.time = time;
		}
		
		@Override
		public int compareTo(computer o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}
	static ArrayList<ArrayList<computer>> list = new ArrayList<>();
	static int n,d,c, distance[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(new ArrayList<computer>());
			for(int i=0;i<d;i++)
			{
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int time = Integer.parseInt(st.nextToken());
				
				list.get(end).add(new computer(start,time));
			}
			
			visited = new boolean[10001];
			distance = new int[10001];
			Arrays.fill(visited, false);
			Arrays.fill(distance, 987654321);
			dijkstra(c-1);
			int cnt=0;
			int result=0;
			for(int i=0;i<n;i++)
				if(visited[i]==true)
					cnt++;
			for(int i=0;i<n;i++)
				if(distance[i] != 987654321)
					if(result < distance[i])
						result = distance[i];
			System.out.println(cnt + " " + result);
		}

	}
	
	static int[] dijkstra(int c)
	{
		
		PriorityQueue<computer> pq = new PriorityQueue<>();
		pq.add(new computer(c,0));
		Arrays.fill(distance, 987654321);
		distance[c]=0;
		visited[c]=true;
		while(!pq.isEmpty())
		{
			computer temp = pq.poll();
			int current = temp.connect;
			int time = temp.time;
			
			for(computer next : list.get(current))
			{
				if(visited[current]==true)
				{
					if(distance[next.connect] > distance[current]+next.time)
					{
						distance[next.connect] = distance[current]+next.time;
						pq.add(new computer(next.connect,distance[next.connect]));
						visited[next.connect]=true;
					}
				}
			}
		
		}
		return distance;
	}

}

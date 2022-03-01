package _0215_DFSBFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_김준우 {
	static int arr[][];
	static boolean visit[];
	static int N,C,start,cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		arr = new int[N][N]; 
		visit = new boolean[N];
		start = 0;
		
		for(int i = 0 ; i<C; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int c1 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			arr[c1][c2]++;
			arr[c2][c1]++;
		}
		
		System.out.println(bfs(start));
	}
	
	public static int bfs (int i) {
		cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int n=0;n<N;n++) {
				if(arr[temp][n] == 1 && visit[n] == false) {
					q.offer(n);
					visit[n] = true;
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}

}

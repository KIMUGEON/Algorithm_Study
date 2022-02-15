package study_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_김유완 {
	static int node,edge,count;
	static int[][] arr;
	static boolean[] is; // 노드를 거쳐 갔는지 확인하기
	static Queue<Integer> q = new LinkedList<Integer>(); // bfs로 풀어보기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		node = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		edge = Integer.parseInt(br.readLine()); // 연결되어있는 선의 수
		StringTokenizer st;
		arr = new int[node+1][node+1];
		is = new boolean[node+1]; // 1번 부터니까 개수 하나 추가
		for(int i=0;i<edge;i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 arr[x][y] = 1;
			 arr[y][x] = 1;
		}
		bfs(1); // 1번부터 확인
		System.out.println(count);
	}
	public static void bfs(int index) {
		q.offer(index); // 처음 1
		is[index] = true; // 방문 체크
		while(!q.isEmpty()) {
			int top = q.poll();
			for(int i=1;i<node+1;i++) {
				if(arr[top][i] == 1 && is[i] == false) {
					q.offer(i); // 연결된아이 큐에 넣기
					is[i] = true; // 방문한거 확인하기
					count++;
				}
			}
		}
	}
}
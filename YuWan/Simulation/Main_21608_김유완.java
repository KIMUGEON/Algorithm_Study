package study_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21608_김유완 {
	static int N;
	static int[][] arr; // 좋아하는 애가 누군지 넣어놓는 함수
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static Node[][] nodeArr;
	static class Node{
		int r,c,s,e,l; // r행 c열 s학생번호 e빈칸수 l좋아하는 사람수

		public Node(int r, int c, int s, int e, int l) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.e = e;
			this.l = l;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N*N+1][4];
		map = new int[N][N]; // 자리 정하기
		nodeArr = new Node[N][N];
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				int y = Integer.parseInt(st.nextToken());
				arr[x][j] = y;
			}
			check(x); // 순서대로 자리 확인해서 넣기
		}
		System.out.println(sum());
	}
	public static void check(int student) {
		Queue<Node> q = new LinkedList<>();
		int likeMax = -1;
		int empty = 0; // 빈칸 수
		int like = 0; // 좋아하는 사람 있는 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				empty = 0; // 빈칸 수
				like = 0; // 좋아하는 사람 있는 수
				for (int k = 0; k < 4; k++) {
					int nr = i + dx[k];
					int nc = j + dy[k];
					if(nr>=0 && nc>=0 && nr<N && nc<N && map[i][j] == 0) {
						for (int t = 0; t < 4; t++) {
							if(map[nr][nc] == arr[student][t]) like++;
						}
						if(map[nr][nc] == 0) empty++;
					}
				}
				if(like == 4) { // 좋아하는 사람이 4칸 모두 있으면 이건 그냥 무조건 이거
					map[i][j] = student;
					nodeArr[i][j] = new Node(i,j,student,empty,like); // 좋아하는 사람들로 둘러쌓여있다
				}
				else {
					if(likeMax < like && map[i][j] == 0) { // 좋아하는 사람이 많은것이 우선순위를 가지니까 q지우고 새로 더하기
						q.clear();
						q.add(new Node(i,j,student,empty,like));
						likeMax = like;
					}
					else if(likeMax == like) { // 빈칸이 더 많은 곳
						Node temp = q.poll();
						if(temp.e < empty) {
							q.clear();
							q.add(new Node(i,j,student,empty,like));
						}
						else q.add(temp);
					}
				}
			}
		}
		Node temp = q.poll(); // 맨위에 있는 값 행이 우선이고 열이 우선임
		nodeArr[temp.r][temp.c] = temp;
		map[temp.r][temp.c] = temp.s;
	}
	public static int sum() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = map[i][j];
				int count = 0; // 만족도 구하기
				for (int k = 0; k < 4; k++) {
					int nr = i + dx[k];
					int nc = j + dy[k];
					if(nr>=0 && nc>=0 && nr<N && nc<N) {
						for (int t = 0; t < 4; t++) { // 좋아하는 사람인지 확인
							if(map[nr][nc] == arr[num][t]) count++;
						}
					}
				}
				switch(count) { // 4방향 확인후 최종 만족도
				case 0: result += 0; break;
				case 1: result += 1; break;
				case 2: result += 10; break;
				case 3: result += 100; break;
				case 4: result += 1000; break;
				}
			}
		}
		return result;
	}
}

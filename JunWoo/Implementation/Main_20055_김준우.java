package _0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_20055_김준우 {
	static int N, K, cnt = 0;
	static int[] belt;
	
	static LinkedList<Integer> robots = new LinkedList<>();
	
	public static void print() {
		System.out.print(Arrays.toString(belt));System.out.println(robots.toString());
	}

	//벨트 돌리기(시계방향 한칸씩)
	public static void rotate() {
		int[] copy_belt = Arrays.copyOf(belt, N*2);
		
		for (int i = 0; i < N*2; i++) {
			belt[(i+1)%(N*2)] = copy_belt[i];
		}
		
		for (int i = 0; i < robots.size(); i++) {
			robots.set(i, (robots.get(i) + 1) % (N*2) );
			if(robots.get(i) == N-1) {
				robots.remove(i);	//로봇 리스트에서 제거
				i--;
				continue;
			}
		}
	}
	
	//로봇 이동하기
	public static void moveRobot() {
		//이동할 로봇이 없으면 스킵
		if(robots.size() == 0) return;
		
		loop:
		for (int i = 0; i < robots.size(); i++) {
			int cc = robots.get(i);
			int nc = (cc+1) % (N*2);
			
			//이동할 칸이 내구도가 0이라면 이동하지 않는다.
			if(belt[nc] == 0) continue;
			
			//그 자리에 다른 로봇이 있다면 이동하지 않는다.
			for (int j = 0; j < robots.size(); j++) {
				if(j == i) continue;	//자기 자신은 패스
				if(nc == robots.get(j)) continue loop;
			}
			
			belt[nc] --;	//이동칸 내구도 감소
			if(belt[nc] == 0) cnt++;
			robots.set(i, (robots.get(i) + 1) % (N*2) );	//로봇 좌표 이동
			
			if(nc == N-1) {
				robots.remove(i);	//로봇 리스트에서 제거
				i--;
				continue;
			}
		}
		
	}
	
	//로봇 올리기
	public static void addRobot() {
		//올리는 곳 내구도가 0이면 올리지 않는다
		if(belt[0] == 0) return;
		
		robots.add(0);	//새 로봇 리스트에 추가
		belt[0] --;	//로봇 올린 칸 내구도 감소

		if(belt[0] == 0) cnt++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N(벨트 가로 길이), K(내구도가 K개이면 종료) 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[N*2];
		
		//belt 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N*2; i++)	belt[i] = Integer.parseInt(st.nextToken());
		
		int i = 1;
		while(true) {
			rotate();
			moveRobot();
			addRobot();
			
			if(cnt >= K) {
				System.out.println(i);
				break;
			}
			//System.out.println();
			
			i++;
		}
		
		
		
	}

}

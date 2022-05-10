package Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 문제 출처 : 백준
 * 문제 링크 : https://www.acmicpc.net/problem/1043
 * 걸린 시간 : 100분
*/
public class BOJ_1043_거짓말 {
	static int N, M;
	static int[] parents;
	static boolean[] knowTruth;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 파티의 수
		
		makeSet(); // 단위집합 생성

		knowTruth = new boolean[N+1]; // 진실을 알고 있는지 여부를 체크하는 배열
		st = new StringTokenizer(br.readLine(), " ");
		int knowTruthCnt = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		
		// 진실을 아는 사람의 수가 0일 경우
		if (knowTruthCnt == 0) {
			// 모든 파티에서 과장되게 말할 수 있음
			System.out.println(M);
			return;
		}
		
		// 진실을 아는 사람 true로 체크
		for (int i = 0; i < knowTruthCnt; i++) {
			int value = Integer.parseInt(st.nextToken());
			knowTruth[value] = true;
		}
		
		List<Integer>[] party = new ArrayList[M]; // 파티 배열
		
		// 파티 배열의 각 값에 리스트 인스턴스 생성
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}
		
		// 파티 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 파티에 참가하는 사람의 수
			
			// 파티에 참가하는 사람의 번호 입력 및 추가
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				party[i].add(value);
			}
			
			// 파티에 참가하는 사람 두명씩 앞뒤로 union해서 합치기
			// -> 모두가 같은 parent를 갖게 됨
			for (int j = 0; j < n-1; j++) {
				union(party[i].get(j), party[i].get(j+1));
			}
		}
		
		// 진실을 알고있는 사람이 속한 파티의 대표자를
		// 진실을 알고있는 사람으로 바꾸기
		for (int i = 1; i <= N; i++) {
			if (knowTruth[i]) {
				knowTruth[findSet(i)] = true;
			}
		}
		
		int ans = 0; // 과장되게 말할 수 있는 파티의 개수
		
		// 각 파티에서 과장되게 말할 수 있는지 체크
		for (int i = 0; i < M; i++) {
			int parent = findSet(party[i].get(0));
			// 파티의 대표자가 진실을 알고있지 않은 경우
			// 그 파티에선 과장되게 말할 수 있음
			if(!knowTruth[parent]) ans++;
		}
		
		// 결과 출력
		System.out.println(ans);
	}

	// 단위집합 생성
	private static void makeSet() {
		parents = new int[N+1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	private static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	
	// a,b 두 집합 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) parents[bRoot] = aRoot;
	}

}

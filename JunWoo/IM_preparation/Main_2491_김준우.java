package _0301_IM대비;
/*	각각 0~9로 이루어진 수열을 입력받는다
 * 같거나 커지는 경우, 작거나 커지는 경우 두가지의 수열 중 가장 길이가 긴 것을 찾아내어 길이를 출력
 * 링크드리스트로 구현해서 하나씩 빼면서 오름차순 수열의 경우와 내림차순 수열의 경우를 각각 체크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2491_김준우 {

	public static void main(String[] args) throws IOException {
		//======input 1st line=======================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//수열 길이
		
		//=======input 2nd line =========================
		LinkedList<Integer> list = new LinkedList<>();	//수열
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int max = 1;	//최고 수열 길이
		int alen = 0;	//오름차순 수열 길이
		int dlen = 0;	//내림차순 수열 길이
		int prev = -1;	//이전에 뽑은 숫자(비교용)
		
		while(!list.isEmpty()) {
			int cur = list.poll();
			
			//첫번째 숫자인 경우 초기화
			if(prev<0) {
				alen = 1;
				dlen = 1;
				prev = cur;
				continue;
			}
			
			//이전값보다 크거나 같다면 오름차순 수열 길이 증가. 아니라면 수열 길이 1로 다시 초기화
			if(cur >= prev) {
				alen++;
				if(alen>max) max = alen;
			}
			else {
				alen = 1;
			}
			
			//이전값보다 크거나 같다면 내림차순 수열 길이 증가. 아니라면 수열 길이 1로 다시 초기화
			if(cur <= prev) {
				dlen++;
				if(dlen>max) max = dlen;
			}
			else {
				dlen = 1;
			}
			
			prev = cur;
			if(alen + list.size()<max && dlen + list.size()<max) break;	//현재 각각 수열의 길이+남은 숫자의 갯수가 모두 최대값보다 작다면 break
		}
		
		System.out.println(max);
		
		
	}

}

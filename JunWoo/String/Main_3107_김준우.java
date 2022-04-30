package _0425_;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3107_김준우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input, ":");

		int reduced = 8-st.countTokens();	//생략된 토큰 수
		
		LinkedList<Character> q = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			//큐에 값을 담은 상태에서 :를 만나면 생략된 0과 큐의 값들을 출력
			if(c == ':' && !q.isEmpty()) {
				//0출력
				for (int zero = 0; zero < 4-q.size(); zero++) {
					System.out.print(0);
				}
				//큐의 값 출력
				while(!q.isEmpty()) {
					System.out.print(q.pop());
				}
				if(i < input.length()-1) System.out.print(":");
			}
			//q에 콜론이 들어있는데 콜론을 또만난 경우 = 2번째 규칙
			else if(c == ':' && q.isEmpty()) {
				//생략된 0 그룹만큼 출력
				for (int j = 0; j < reduced; j++) {
					System.out.print("0000");
					if(i < input.length()-1 || j < reduced-1) System.out.print(":");
				}
				//다음 값도 :이라면 스킵
				if(i < input.length()-1) if(input.charAt(i+1) == ':') i++;
			}
			else {
				q.add(c);
			}
			
		}
		
		if(!q.isEmpty()) {
			for (int zero = 0; zero < 4-q.size(); zero++) {
				System.out.print(0);
			}
			while(!q.isEmpty()) {
				System.out.print(q.pop());
			}
		}
		
	}

}
package _0422_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1316_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	//입력받을 단어 수
		
		int cnt = 0;	//그룹단어의 개수
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			LinkedList<Character> q = new LinkedList<>();
			
			for (int j = 0; j < str.length(); j++) {
				char val = str.charAt(j);
				
				//첫번째 알파벳이면 큐에 넣기
				if(q.isEmpty()) {
					q.push(val);
				}
				else {
					if (q.get(0) != val) {	//연속되는 값이 아닌경우
						//이미 큐에 있는 값인 경우
						if(q.contains(val)) {break;}
						
						//새로운 값이 들어온 경우
						q.push(val);
					}
				}
				
				//마지막 단어 인경우 cnt 증가
				if(j == str.length() - 1) {
					cnt ++;
				}
				
			}
		}
		
		System.out.println(cnt);
	}

}

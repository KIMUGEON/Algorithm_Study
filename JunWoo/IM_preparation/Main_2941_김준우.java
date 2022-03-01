package _0225_IM대비;
/*	boj 2941
 * 알고리즘 스터디 02/25
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_2941_김준우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;	//알파벳 갯수
		
		//입력값을 링크드리스트에 받아서 헤드부터 꺼내쓰도록 구현
		String str = br.readLine();	
		LinkedList<Character> input = new LinkedList<Character>();	
		for(int i = 0; i<str.length(); i++) {
			input.add(str.charAt(i));
		}
		
		while(!input.isEmpty()) {
			char cur = input.poll();	//헤드값을 받아옴
			char next;				
			
			if(input.isEmpty()) {	//이게 마지막 값이면  갯수 증가후 종료
				num++;
				break;
			}
			
			switch (cur) {
			case 'c':
				next = input.peek();
				if(next == '=' || next == '-') {
					input.poll();			//현재 값이 c인경우 다음값이 =, - 인 경우 다음값까지 제거 후 갯수 증가 
				}
				break;
			case 'd':
				next = input.peek();
				if(next == 'z' && input.size() >= 2) {
					if(input.get(1) == '=') {
						input.poll();
						input.poll();
					}
				}
				else if(next == '-') {
					input.poll();
				}
				break;
			case 'l':
				next = input.peek();
				if(next == 'j') {
					input.poll();
				}
				break;
			case 'n':
				next = input.peek();
				if(next == 'j') {
					input.poll();
				}
				break;
			case 's':
				next = input.peek();
				if(next == '=') {
					input.poll();
				}
				break;
			case 'z':
				next = input.peek();
				if(next == '=') {
					input.poll();
				}
				break;
			default:
				break;
			}
			num++;
		}
		
		System.out.println(num);
		
	}

}

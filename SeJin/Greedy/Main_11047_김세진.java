import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken()); // 동전 종류 개수
		int target = Integer.parseInt(st.nextToken()); // 목표금액
		
		Stack<Integer> s = new Stack<Integer>(); // 비싼것부터 빼기 위해 stack사용
		for(int i=0;i<N;i++)
			s.push(Integer.parseInt(br.readLine()));
		int price =0; //금액
		int result = 0; //동전개수
		while(target!=0)
		{
			if(target/s.peek()==0) // 나눠지지 않으면 target이 더 작으므로 스택에서 뺀다
				s.pop();
			else
			{
				result+=target/s.peek(); // 넣은 동전 개수만큼 result 추가
				price = s.peek() * (target/s.peek()); // 나눈 몫만큼 금액을 곱해준다.
				target -= price; // 그 이후 타겟에서 그 금액을 뺸다
				s.pop(); // 계산 끝났으므로 스택에서 빼기
				
			}
		}
		System.out.println(result);
	}

}

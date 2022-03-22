import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
  [입력]
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

  [출력]
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

  [규칙]
n	fibo0	fibo1  =>n에 따른 0, 1호출회수
0	1		0
1	0		1
2	1		1
3	1		2
4	2		3
5	3		5
6	5		8

n에 대한 fibo0(0 호출 횟수) = n-1의 fibo1
n에 대한 fibo1(1 호출 횟수) = n-1의 fibo0 + n-1의 fibo1

 */
public class Main_1003 { //피보나치 수열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스
		
		int arr[] = new int[T];
		
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int o[] = new int[41]; //n의 범위가 40까지로 주어짐
		int l[] = new int[41];
		
		o[0] = 1; //n이 0일때 0 호출횟수
		o[1] = 0; //n이 1일때 0 호출횟수
		l[0] = 0; //n이 0일때 1 호출횟수
		l[1] = 1; //n이 1일때 1 호출횟수
		
		for(int i=2; i<41; i++) { //n의 범위가 40까지로 주어짐
			o[i] = o[i-1] + o[i-2];
			l[i] = l[i-1] + l[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			sb.append(o[arr[i]]).append(" ").append(l[arr[i]]).append("\n");
		}
		
		System.out.print(sb);
	}

}
